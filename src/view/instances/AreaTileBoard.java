package view.instances;

import engine.model.map.GameMap;
import engine.model.tile.field.Area;
import engine.points.Coords;
import engine.points.Point;
import engine.points.Rect;
import utils.Opt;
import view.component.TileBoardComponent;
import view.interfaces.GameGraphics;

public final class AreaTileBoard extends TileBoardComponent<AreaTile> {

    private final BoardScreenMover boardScreenMover = new BoardScreenMover();
    private final GameMap<Area> map;

    /* ========== PUBLIC ========== */
    @Override
    public void performTicks() {
        boardScreenMover.tick();
        map.tick();
    }

    /* ========== PROTECTED ========== */
    @Override
    protected void draw(GameGraphics g, Coords tileCoords) {
        map.get(tileCoords.plus(boardScreenMover.getCurrentView()))
                .ifPresent(field -> draw(g, field, getTiles().get(tileCoords)));
    }

    @Override
    protected AreaTile tileFactoryMethod(Coords coords) {
        Point point = Point.of(coords.getX(), coords.getY()).mul(24).add(rect.getStartPoint());
        AreaTile tileComponent = new AreaTile(new Rect(point, point.add(24, 24)));
        addComponent(tileComponent);
        return tileComponent;
    }

    /* ========== DEFAULT ========== */
    AreaTileBoard(Rect rect, GameMap<Area> map) {
        super(rect);
        this.map = map;
    }

    /* ========== PRIVATE ========== */
    private void draw(GameGraphics g, Area field, Opt<AreaTile> tile) {
        tile.ifPresent(t -> draw(g, field, t));
    }

    private void draw(GameGraphics g, Area field, AreaTile tile) {
        tile.setElement(field);
        tile.setDelta(boardScreenMover.getDelta());
        tile.draw(g);
    }

    private boolean checkCoords(Coords coords) {
        return coords.check(map.getSize(), getBoardSize());
    }
}
