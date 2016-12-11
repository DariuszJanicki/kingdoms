package view.instances;

import engine.model.settlement.Settlement;
import engine.model.tile.field.Field;
import engine.points.Point;
import engine.points.Rect;
import lombok.Setter;
import utils.Bool;
import utils.Opt;
import view.component.setting.AbstractComponent;
import view.interfaces.GameGraphics;
import view.click.GameMouseEvent;
import view.click.MouseAction;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

class Tile extends AbstractComponent {

    private Opt<Field> field = Opt.empty();
    @Setter
    private Point delta;
    private Bool highlight = Bool.FALSE;

    /* ========== CONSTRUCTOR ========== */
    Tile(Rect rect) {
        super(rect);
        getClickFunctionMapper()
                .register(MouseAction.LEFT_CLICK, this::leftMouse)
                .register(MouseAction.RIGHT_CLICK, this::rightMouse)
                .register(MouseAction.HOVER, this::hover)
                .register(MouseAction.HOVER_EXIT, this::hoverOff);
    }

    /* ========== PUBLIC ========== */
    Tile setField(Field field) {
        this.field = Opt.ofNullable(field);
        return this;
    }

    @Override
    public void draw(GameGraphics g) {
        field.ifPresent(f -> {
            g.draw(f.getTile().getImage(), rect.move(this.delta));
            f.getSettlement().ifPresent(s -> drawSettlement(g, s));

            highlight.ifTrue(() -> {
                g.setColor(new Color(255, 255, 255, 200));
                g.draw(rect.move(this.delta));
            });
        });
    }

    @Override
    public void performTicks() {
        field.ifPresent(Field::tick);
    }

    /* ========== PRIVATE ========== */
    private void leftMouse(GameMouseEvent e) {
        field.ifPresent(f -> {
            model.setCurrentTileInfo(f.getTerrain() + " " + f.getCoords());
            f.getSettlement()
                    .ifPresent(settlement -> model.setVillagers(settlement.getInhabitants().list()));
        });
    }

    private void rightMouse(GameMouseEvent e) {
        clear();
        addComponent(new BoardOptionList(Rect.of(e.getPoint(), Point.of(32, 96).add(e.getPoint()))));
    }

    private void clear() {
        List<AbstractComponent> collect = components.stream()
                .filter(c -> c instanceof BoardOptionList)
                .collect(Collectors.toList());
        componentsToRemove.addAll(collect);
    }

    private void hover(GameMouseEvent e) {
        highlight = Bool.TRUE;
    }

    private void hoverOff(GameMouseEvent e) {
        highlight = Bool.FALSE;
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
