package view.instances;

import base.frame.constants.FrameConstants;
import engine.model.map.GameMap;
import engine.model.tile.field.Field;
import engine.points.Coords;
import engine.points.Point;
import engine.points.Rect;
import utils.Opt;
import view.component.TileBoardComponent;
import view.interfaces.GameGraphics;

public final class FieldTileBoard extends TileBoardComponent<FieldTile> {

    private final BoardScreenMover boardScreenMover = new BoardScreenMover();
    private final GameMap<Field> map;

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
        FieldTile tileComponent = new FieldTile(new Rect(point, point.add(FrameConstants.baseTile, FrameConstants.baseTile)));
        addComponent(tileComponent);
        return tileComponent;
    }

    /* ========== DEFAULT ========== */
    FieldTileBoard(Rect rect, GameMap<Field> map) {
        super(rect);
        this.map = map;
    }

    /* ========== PRIVATE ========== */
    private void draw(GameGraphics g, Field field, Opt<FieldTile> tile) {
        tile.ifPresent(t -> draw(g, field, t));
    }

    private void draw(GameGraphics g, Field field, FieldTile tile) {
        tile.setElement(field);
        tile.setDelta(boardScreenMover.getDelta());
        tile.draw(g);
    }

    private boolean checkCoords(Coords coords) {
        return coords.check(map.getSize(), getBoardSize());
    }
}
