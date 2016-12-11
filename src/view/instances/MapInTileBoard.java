package view.instances;

import engine.model.map.GameMap;
import engine.model.tile.field.Field;
import engine.points.Coords;
import engine.points.Rect;
import utils.Opt;
import view.component.TileBoardComponent;
import view.interfaces.GameGraphics;

public final class MapInTileBoard extends TileBoardComponent {

    private final BoardScreenMover boardScreenMover = new BoardScreenMover();
    private final GameMap<Field> map;

    /* ========== PUBLIC ========== */
    MapInTileBoard(Rect rect, GameMap<Field> map) {
        super(rect);
        this.map = map;
    }

    protected void draw(GameGraphics g, Coords tileCoords) {
        map.get(tileCoords.plus(boardScreenMover.getCurrentView()))
                .ifPresent(field -> draw(g, field, getTiles().get(tileCoords)));
    }

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

    /* ========== PRIVATE ========== */
    private void draw(GameGraphics g, Field field, Opt<Tile> tile) {
        tile.ifPresent(t -> draw(g, field, t));
    }

    private void draw(GameGraphics g, Field field, Tile tile) {
        tile.setField(field);
        tile.setDelta(boardScreenMover.getDelta());
        tile.draw(g);
    }

    private boolean checkCoords(Coords coords) {
        return coords.check(map.getSize(), getBoardSize());
    }
}
