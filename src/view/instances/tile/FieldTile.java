package view.instances.tile;

import engine.model.map.Field;
import engine.model.settlement.Settlement;
import utils.points.Point;
import utils.points.Rect;
import utils.Bool;
import components.input.mouse.GameMouseEvent;
import components.input.mouse.MouseAction;
import components.components.GameGraphics;
import view.drawer.FieldDrawer;
import view.instances.contextlist.TileContextList;

final class FieldTile extends TileComponent<Field> {

    private final FieldTileBoard parent;

    /* ========== DEFAULT ========== */
    FieldTile(Rect rect, FieldTileBoard parent) {
        super(rect);
        this.parent = parent;
        createClickMapper()
                .register(MouseAction.LEFT_CLICK, this::leftMouse)
                .register(MouseAction.RIGHT_CLICK, this::rightMouse)
                .register(MouseAction.HOVER, g -> highlight = Bool.TRUE)
                .register(MouseAction.HOVER_EXIT, g -> highlight = Bool.FALSE);
    }

    /* ========== PROTECTED ========== */
    @Override
    public void draw(GameGraphics g) {
        element.ifPresent(() -> FieldDrawer.draw(g, element.get(), parent.getMap(), rect, delta));
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
        parent.addComponent(new AreaTileBoard(Rect.of(50, 200, 400, 550), s.getSettlementAreaMap()));
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