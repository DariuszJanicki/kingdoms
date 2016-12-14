package view.instances;

import base.frame.constants.FrameConstants;
import engine.model.map.MapArea;
import engine.model.map.GameMap;
import engine.points.Coords;
import engine.points.Point;
import engine.points.Rect;
import utils.Opt;
import view.component.TileBoardComponent;
import view.component.GameGraphics;

public final class FieldTileBoard extends TileBoardComponent<FieldTile> {

    private final BoardScreenMover boardScreenMover = new BoardScreenMover();
    private final GameMap<MapArea> map;
    private final AreaTileBoard board;

    /* ========== PUBLIC ========== */
    @Override
    public void performTicks() {
        boardScreenMover.tick();
        map.tick();
    }

    public void setDestinationView(Coords coords) {
        Coords plus = boardScreenMover.transform(coords);
        if (checkCoords(plus) && boardScreenMover.checkDifference()) {
            boardScreenMover.setDestinationView(plus);
        }
    }

    /* ========== PROTECTED ========== */
    @Override
    protected void draw(GameGraphics g, Coords tileCoords) {
        map.get(tileCoords.plus(boardScreenMover.getCurrentView()))
                .ifPresent(field -> draw(g, field, getTiles().get(tileCoords)));
    }

    @Override
    protected FieldTile tileFactoryMethod(Coords coords) {
        Point point = Point.of(coords.getX(), coords.getY()).mul(FrameConstants.baseTile).add(rect.getStartPoint());
        FieldTile tileComponent = new FieldTile(new Rect(point, point.add(FrameConstants.baseTile, FrameConstants.baseTile)), board);
        addComponent(tileComponent);
        return tileComponent;
    }

    /* ========== DEFAULT ========== */
    FieldTileBoard(Rect rect, GameMap<MapArea> map, AreaTileBoard board) {
        super(rect);
        this.map = map;
        this.board = board;
    }

    /* ========== PRIVATE ========== */
    private void draw(GameGraphics g, MapArea mapArea, Opt<FieldTile> tile) {
        tile.ifPresent(t -> draw(g, mapArea, t));
    }

    private void draw(GameGraphics g, MapArea mapArea, FieldTile tile) {
        tile.setElement(mapArea);
        tile.setMap(map);
        tile.setDelta(boardScreenMover.getDelta());
        tile.draw(g);
    }

    private boolean checkCoords(Coords coords) {
        return coords.check(map.getSize(), getBoardSize());
    }
}
