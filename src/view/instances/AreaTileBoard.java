package view.instances;

import engine.model.map.Area;
import engine.model.map.GameMap;
import engine.points.Coords;
import engine.points.Point;
import engine.points.Rect;
import lombok.Setter;
import utils.Bool;
import utils.Opt;
import view.component.GameGraphics;
import view.component.TileBoardComponent;

final class AreaTileBoard extends TileBoardComponent<AreaTile> {

    private final BoardScreenMover boardScreenMover = new BoardScreenMover();
    @Setter
    private Opt<GameMap<Area>> map = Opt.empty();

    /* ========== PUBLIC ========== */
    public AreaTileBoard(Rect rect, GameMap<Area> map) {
        super(rect);
        this.map = Opt.ofNullable(map);
    }

    @Override
    public void performTicks() {
        boardScreenMover.tick();
        map.ifPresent(GameMap::tick);
    }

    @Override
    public Bool isTemporary() {
        return Bool.TRUE;
    }

    /* ========== PROTECTED ========== */
    @Override
    protected void draw(GameGraphics g, Coords tileCoords) {
        map.ifPresent(map -> map
                .get(tileCoords.plus(boardScreenMover.getCurrentView()))
                .ifPresent(field -> draw(g, field, getTiles()
                        .get(tileCoords))));
    }

    @Override
    protected AreaTile tileFactoryMethod(Coords coords) {
        int size = 32;
        Point point = Point.of(coords.getX(), coords.getY()).mul(size).add(rect.getStartPoint());
        AreaTile tileComponent = new AreaTile(new Rect(point, point.add(size, size)));
        addComponent(tileComponent);
        return tileComponent;
    }

    /* ========== PRIVATE ========== */
    private void draw(GameGraphics g, Area area, Opt<AreaTile> tile) {
        tile.ifPresent(t -> draw(g, area, t));
    }

    private void draw(GameGraphics g, Area area, AreaTile tile) {
        tile.setElement(area);
        tile.setDelta(boardScreenMover.getDelta());
        tile.setMap(map);
        tile.draw(g, area);
    }
}
