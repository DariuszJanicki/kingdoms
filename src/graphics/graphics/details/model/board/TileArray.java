package graphics.graphics.details.model.board;

import graphics.frame.constants.FrameConstants;
import graphics.graphics.details.points.Point;
import graphics.graphics.details.points.Rect;
import graphics.graphics.details.points.Coords;
import graphics.graphics.details.points.Size;
import graphics.graphics.details.model.tile.Tile;
import utils.Opt;

public class TileArray {

    private Tile[][] tiles;
    private Size size;

    public TileArray(Size size, Board board) {
        createTiles(size, board);
        this.size = size;
    }

    /* ========== PUBLIC ========== */
    public Opt<Tile> get(Coords coords) {
        return Opt.ofNullable(coords.check(size)
                ? tiles[coords.getX()][coords.getY()]
                : null);
    }

    /* ========== PRIVATE ========== */
    private void createTiles(Size size, Board board) {
        tiles = new Tile[size.getX() + 2][];
        for (int i = 0; i <= size.getX() + 1; ++i) {
            tiles[i] = new Tile[size.getY() + 2];
            for (int j = 0; j <= size.getY() + 1; ++j) {
                Point point = new Coords(i, j).toPoint().add(board.getRect().getStartPoint());
                Tile tile = new Tile(new Rect(point, point.add(FrameConstants.baseTile, FrameConstants.baseTile)));
                board.add(tiles[i][j] = tile);
            }
        }
    }
}
