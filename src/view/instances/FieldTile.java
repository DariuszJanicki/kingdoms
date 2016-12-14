package view.instances;

import engine.model.field.Field;
import engine.model.map.GameMap;
import engine.points.Point;
import engine.points.Rect;
import lombok.Setter;
import utils.Bool;
import view.click.GameMouseEvent;
import view.click.MouseAction;
import view.component.TileComponent;
import view.component.setting.AbstractComponent;
import view.drawer.FieldDrawer;
import view.interfaces.GameGraphics;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

final class FieldTile extends TileComponent<Field> {

    @Setter
    private Point delta;
    private Bool highlight = Bool.FALSE;
    @Setter
    private GameMap<Field> map;

    /* ========== DEFAULT ========== */
    FieldTile(Rect rect) {
        super(rect);
        getClickFunctionMapper()
                .register(MouseAction.LEFT_CLICK, this::leftMouse)
                .register(MouseAction.RIGHT_CLICK, this::rightMouse)
                .register(MouseAction.HOVER, g -> highlight = Bool.TRUE)
                .register(MouseAction.HOVER_EXIT, g -> highlight = Bool.FALSE);
    }

    /* ========== PROTECTED ========== */
    protected void draw(GameGraphics g, Field wrapper) {

        FieldDrawer.draw(g, wrapper, map, rect, delta);

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

    private void printInformationToModel(Field wrapper) {
        model.setCurrentTileInfo(wrapper.getTerrain() + " " + wrapper.getCoords());
        wrapper.getSettlement()
                .ifPresent(settlement -> model.setVillagers(settlement.getInhabitants().list()));
    }

    private void clear() {
        List<AbstractComponent> collect = components.stream()
                .filter(c -> c instanceof TileContextList)
                .collect(Collectors.toList());
        componentsToRemove.addAll(collect);
    }
}