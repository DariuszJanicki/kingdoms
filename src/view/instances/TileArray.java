package view.instances;

import base.frame.constants.FrameConstants;
import engine.points.Point;
import engine.points.Rect;
import engine.points.Coords;
import engine.points.Size;
import utils.Opt;
import view.component.TileBoardComponent;

public final class TileArray {

    private Tile[][] tiles;
    private Size size;

    /* ========== PUBLIC ========== */
    public TileArray(Size size, TileBoardComponent board) {
        createTiles(size, board);
        this.size = size;
    }

    public Opt<Tile> get(Coords coords) {
        return Opt.ofNullable(coords.check(size)
                ? tiles[coords.getX()][coords.getY()]
                : null);
    }

    /* ========== PRIVATE ========== */
    private void createTiles(Size size, TileBoardComponent board) {
        tiles = new Tile[size.getX() + 2][];
        for (int i = 0; i <= size.getX() + 1; ++i) {
            tiles[i] = new Tile[size.getY() + 2];
            for (int j = 0; j <= size.getY() + 1; ++j) {
                newTile(board, new Coords(i, j));
            }
        }
    }

    private void newTile(TileBoardComponent board, Coords coords) {
        Point point = coords.toPoint().add(board.getRect().getStartPoint());
        Tile tile = new Tile(new Rect(point, point.add(FrameConstants.baseTile, FrameConstants.baseTile)));
        board.addComponent(tiles[coords.getX()][coords.getY()] = tile);
    }
}
