package view.instances;

import base.frame.constants.FrameConstants;
import base.utils.GameArray;
import engine.points.Coords;
import engine.points.Point;
import engine.points.Rect;
import engine.points.Size;
import view.component.TileBoardComponent;

public final class TileArray extends GameArray<Tile> {

    /* ========== PUBLIC ========== */
    public TileArray(Size size, TileBoardComponent board) {
        super(size);
        createTiles(coords -> newTile(board, coords));
    }

    /* ========== PRIVATE ========== */
    private Tile newTile(TileBoardComponent board, Coords coords) {
        Point point = coords.toPoint().add(board.getRect().getStartPoint());
        Tile tileComponent = new Tile(new Rect(point, point.add(FrameConstants.baseTile, FrameConstants.baseTile)));
        board.addComponent(tileComponent);
        return tileComponent;
    }
}
