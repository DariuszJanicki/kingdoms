package graphics.graphics.details.model.board;

import graphics.frame.constants.FrameConstants;
import graphics.graphics.GameGraphics;
import graphics.graphics.Point;
import graphics.graphics.Rect;
import graphics.graphics.clickable.Component;
import graphics.graphics.details.Coords;
import graphics.graphics.details.Size;
import graphics.graphics.details.model.map.GameMap;
import graphics.graphics.details.model.tile.Tile;
import lombok.Getter;

public class Board extends Component {

    private GameMap map;
    private Size size;

    private Tile[][] tiles;

    @Getter
    private Coords currentLocation;

    public Board(Rect rect, GameMap map, Coords location) {
        super(rect);

        this.map = map;
        this.size = rect.toSize().div(FrameConstants.baseTile);
        this.currentLocation = location;

        createTiles(size);
    }

    /* ========== PUBLIC ========== */
    public void draw(GameGraphics g) {
        for (int i = 0; i < size.getX(); ++i) {
            for (int j = 0; j < size.getY(); ++j) {
                draw(g, new Coords(i, j));
            }
        }
    }

    public void setCurrentLocation(Coords coords) {
        if (checkX(coords) && checkY(coords)) {
            currentLocation = coords;
        }
    }

    /* ========== PRIVATE ========== */
    private void draw(GameGraphics g, Coords tileCoords) {
        Coords mapCoords = tileCoords.plus(currentLocation);
        map.get(mapCoords)
                .ifPresent(f -> getTile(tileCoords).setField(f).draw(g));
    }

    private Tile getTile(Coords coords) {
        return tiles[coords.getX()][coords.getY()];
    }

    private boolean checkX(Coords coords) {
        return coords.getX() >= 0 && coords.getX() + size.getX() < map.getX();
    }

    private boolean checkY(Coords coords) {
        return coords.getY() >= 0 && coords.getY() + size.getY() < map.getY();
    }

    private void createTiles(Size size) {
        tiles = new Tile[size.getX()][];
        for (int i = 0; i < size.getX(); ++i) {
            tiles[i] = new Tile[size.getY()];
            for (int j = 0; j < size.getY(); ++j) {
                Point point = new Coords(i, j).toPoint().plus(rect.getStartPoint());
                Tile tile = new Tile(new Rect(point, point.add(FrameConstants.baseTile, FrameConstants.baseTile)));
                registerComponent(tiles[i][j] = tile);
            }
        }
    }
}
