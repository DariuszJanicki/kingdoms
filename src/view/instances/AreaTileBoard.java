package view.instances;

import engine.model.map.SettlementArea;
import engine.model.map.GameMap;
import engine.points.Coords;
import engine.points.Point;
import engine.points.Rect;
import lombok.Setter;
import utils.Bool;
import utils.Opt;
import view.component.TileBoardComponent;
import view.component.GameGraphics;

final class AreaTileBoard extends TileBoardComponent<AreaTile> {

    private final BoardScreenMover boardScreenMover = new BoardScreenMover();
    @Setter
    private GameMap<SettlementArea> map;
    private Bool isVisible = Bool.FALSE;

    /* ========== PUBLIC ========== */
    @Override
    public void performTicks() {
        boardScreenMover.tick();
        map.tick();
    }

    public void show() {
        isVisible = Bool.TRUE;
    }

    /* ========== PROTECTED ========== */
    @Override
    protected void draw(GameGraphics g, Coords tileCoords) {
        isVisible.ifTrue(() ->
                map.get(tileCoords.plus(boardScreenMover.getCurrentView()))
                        .ifPresent(field -> draw(g, field, getTiles().get(tileCoords))));
    }

    @Override
    protected AreaTile tileFactoryMethod(Coords coords) {
        Point point = Point.of(coords.getX(), coords.getY()).mul(24).add(rect.getStartPoint());
        AreaTile tileComponent = new AreaTile(new Rect(point, point.add(24, 24)));
        addComponent(tileComponent);
        return tileComponent;
    }

    /* ========== DEFAULT ========== */
    AreaTileBoard(Rect rect, GameMap<SettlementArea> map) {
        super(rect);
        this.map = map;
    }

    /* ========== PRIVATE ========== */
    private void draw(GameGraphics g, SettlementArea field, Opt<AreaTile> tile) {
        tile.ifPresent(t -> draw(g, field, t));
    }

    private void draw(GameGraphics g, SettlementArea field, AreaTile tile) {
        tile.setElement(field);
        tile.setDelta(boardScreenMover.getDelta());
        tile.setMap(map);
        tile.draw(g, field);
        tile.draw(g);
    }
}
