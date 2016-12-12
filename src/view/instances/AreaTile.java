package view.instances;

import engine.model.settlement.Settlement;
import engine.model.tile.field.Area;
import engine.points.Point;
import engine.points.Rect;
import lombok.Setter;
import utils.Bool;
import view.click.GameMouseEvent;
import view.click.MouseAction;
import view.component.TileComponent;
import view.component.setting.AbstractComponent;
import view.interfaces.GameGraphics;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

final class AreaTile extends TileComponent<Area> {

    @Setter
    private Point delta;
    private Bool highlight = Bool.FALSE;

    /* ========== DEFAULT ========== */
    AreaTile(Rect rect) {
        super(rect);
        getClickFunctionMapper()
                .register(MouseAction.LEFT_CLICK, this::leftMouse)
                .register(MouseAction.RIGHT_CLICK, this::rightMouse)
                .register(MouseAction.HOVER, g -> highlight = Bool.TRUE)
                .register(MouseAction.HOVER_EXIT, g -> highlight = Bool.FALSE);
    }

    /* ========== PROTECTED ========== */
    protected void draw(GameGraphics g, Area field) {
        g.draw(field.getTile().getImage(), rect.move(this.delta));
        field.getSettlement().ifPresent(s -> drawSettlement(g, s));

        highlight.ifTrue(() -> {
            g.setColor(new Color(255, 255, 255, 200));
            g.draw(rect.move(this.delta));
        });
    }

    /* ========== PRIVATE ========== */
    private void leftMouse(GameMouseEvent e) {
        element.ifPresent(this::printInformationToModel);
    }

    private void rightMouse(GameMouseEvent e) {
        clear();
        addComponent(new TileContextList(Rect.of(e.getPoint(), Point.of(32, 96).add(e.getPoint()))));
    }

    private void printInformationToModel(Area field) {
        model.setCurrentTileInfo(field.getTerrain() + " " + field.getCoords());
        field.getSettlement()
                .ifPresent(settlement -> model.setVillagers(settlement.getInhabitants().list()));
    }

    private void clear() {
        List<AbstractComponent> collect = components.stream()
                .filter(c -> c instanceof TileContextList)
                .collect(Collectors.toList());
        componentsToRemove.addAll(collect);
    }

    private void drawSettlement(GameGraphics g, Settlement settlement) {
        String size = String.valueOf(settlement.getInhabitants().list().size());
        g.draw(settlement.getTile().getImage(), rect.move(delta));
        drawText(g, size);
    }

    private void drawText(GameGraphics g, String size) {
        Point add = rect.getStartPoint().add(0, 12);
        g.setColor(new Color(255, 255, 255, 200));
        g.draw(Rect.of(rect.getStartPoint(), rect.getStartPoint().add(g.stringWidth(size), 15)).move(delta));
        g.setColor(Color.BLACK);
        g.drawString(size, add.add(delta));
    }
}