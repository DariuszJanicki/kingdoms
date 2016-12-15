package view.instances;

import engine.model.map.Field;
import engine.model.settlement.Settlement;
import engine.points.Point;
import engine.points.Rect;
import utils.Bool;
import view.click.GameMouseEvent;
import view.click.MouseAction;
import view.component.GameGraphics;
import view.component.TileComponent;
import view.drawer.FieldDrawer;

final class FieldTile extends TileComponent<Field> {

    private final FieldTileBoard parent;

    /* ========== DEFAULT ========== */
    FieldTile(Rect rect, FieldTileBoard parent) {
        super(rect);
        this.parent = parent;
        getClickFunctionMapper()
                .register(MouseAction.LEFT_CLICK, this::leftMouse)
                .register(MouseAction.RIGHT_CLICK, this::rightMouse)
                .register(MouseAction.HOVER, g -> highlight = Bool.TRUE)
                .register(MouseAction.HOVER_EXIT, g -> highlight = Bool.FALSE);
    }

    /* ========== PROTECTED ========== */
    protected void draw(GameGraphics g, Field wrapper) {
        FieldDrawer.draw(g, wrapper, parent.getMap(), rect, delta);
        highlight(g);
    }

    /* ========== PRIVATE ========== */
    private void leftMouse(GameMouseEvent e) {
        parent.clear();
        element.ifPresent(this::printInformationToModel);
        element.ifPresent(field -> field.getSettlement()
                .ifPresent(this::showAreaMap));
    }

    private void showAreaMap(Settlement s) {
        parent.addComponent(new AreaTileBoard(Rect.of(50, 200, 400, 400), s.getSettlementAreaMap()));
    }

    private void rightMouse(GameMouseEvent e) {
        parent.addComponent(new TileContextList(Rect.of(e.getPoint(), Point.of(32, 96).add(e.getPoint()))));
    }

    private void printInformationToModel(Field wrapper) {
        model.setCurrentTileInfo(wrapper.getTerrain() + " " + wrapper.getCoords());
        wrapper.getSettlement()
                .ifPresent(settlement -> model.setVillagers(settlement.getSettlementPeople().list()));
    }
}