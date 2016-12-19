package pl.jamnic.games.kingdoms.view.instances.tile;

import pl.jamnic.games.kingdoms.model.model.map.Field;
import pl.jamnic.games.kingdoms.model.model.settlement.Settlement;
import pl.jamnic.games.kingdoms.uicomponents.components.GameGraphics;
import pl.jamnic.games.kingdoms.uicomponents.input.mouse.GameMouseEvent;
import pl.jamnic.games.kingdoms.uicomponents.input.mouse.MouseAction;
import pl.jamnic.games.kingdoms.utils.points.Point;
import pl.jamnic.games.kingdoms.utils.points.Rect;
import pl.jamnic.games.kingdoms.view.drawer.FieldDrawer;
import pl.jamnic.games.kingdoms.view.instances.contextlist.TileContextList;
import utils.Bool;

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