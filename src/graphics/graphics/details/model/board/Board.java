package graphics.graphics.details.model.board;

import graphics.frame.constants.FrameConstants;
import graphics.graphics.GameGraphics;
import graphics.graphics.Mat;
import graphics.graphics.Point;
import graphics.graphics.Rect;
import graphics.graphics.clickable.Component;
import graphics.graphics.details.Coords;
import graphics.graphics.details.Size;
import graphics.graphics.details.model.map.GameMap;
import graphics.graphics.details.model.tile.Tile;
import graphics.graphics.details.model.tile.field.Field;
import lombok.Getter;

public class Board extends Component {

    private GameMap map;
    private Size size;

    private Tile[][] tiles;

    @Getter
    private Point delta = new Point(0, 0);
    private Coords destinationLocation = new Coords(0, 0);
    private Coords currentLocation = new Coords(0, 0);

    public Board(Rect rect, GameMap map) {
        super(rect);

        this.map = map;
        this.size = rect.toSize().div(FrameConstants.baseTile);

        createTiles(size);
    }

    /* ========== PUBLIC ========== */
    @Override
    public void draw(GameGraphics g) {
        for (int i = 0; i <= size.getX() + 1; ++i) {
            for (int j = 0; j <= size.getY() + 1; ++j) {
                draw(g, new Coords(i, j));
            }
        }
    }

    @Override
    public void tick() {
        if (currentLocation.notEqual(destinationLocation)) {
            int x = Mat.signum(currentLocation.xDifference(destinationLocation));
            int y = Mat.signum(currentLocation.yDifference(destinationLocation));

            if (Math.abs(delta.getX()) < FrameConstants.baseTile && Math.abs(delta.getY()) < FrameConstants.baseTile) {
                delta = new Point(delta.getX() + 3 * x, delta.getY() + 3 * y);
            } else {
                if (Math.abs(delta.getY()) >= FrameConstants.baseTile) {
                    currentLocation = new Coords(currentLocation.getX(), currentLocation.getY() - y);
                } else if (Math.abs(delta.getX()) >= FrameConstants.baseTile) {
                    currentLocation = new Coords(currentLocation.getX() - x, currentLocation.getY());
                }
                delta = new Point(0, 0);
            }
        }
    }

    public void setDestinationLocation(Coords coords) {
        if (checkCoords(destinationLocation.plus(coords))
                && currentLocation.difference(destinationLocation).length() < 3) {
            destinationLocation = destinationLocation.plus(coords);
        }
    }

    /* ========== PRIVATE ========== */
    private void draw(GameGraphics g, Coords tileCoords) {
        Coords mapCoords = tileCoords.plus(currentLocation);
        map.get(mapCoords)
                .ifPresent(f -> drawTile(g, f, getTile(tileCoords)));
    }

    private void drawTile(GameGraphics g, Field field, Tile tile) {
        tile.setField(field);
        g.draw(field.getTerrainTile().getImage(), tile.getRect().move(delta));
    }

    private Tile getTile(Coords coords) {
        return tiles[coords.getX()][coords.getY()];
    }

    private boolean checkCoords(Coords coords) {
        return checkX(coords) && checkY(coords);
    }

    private boolean checkX(Coords coords) {
        return coords.getX() >= 0 && coords.getX() + size.getX() < map.getX();
    }

    private boolean checkY(Coords coords) {
        return coords.getY() >= 0 && coords.getY() + size.getY() < map.getY();
    }

    private void createTiles(Size size) {
        tiles = new Tile[size.getX() + 2][];
        for (int i = 0; i <= size.getX() + 1; ++i) {
            tiles[i] = new Tile[size.getY() + 2];
            for (int j = 0; j <= size.getY() + 1; ++j) {
                Point point = new Coords(i, j).toPoint().plus(rect.getStartPoint());
                Tile tile = new Tile(new Rect(point, point.add(FrameConstants.baseTile, FrameConstants.baseTile)));
                add(tiles[i][j] = tile);
            }
        }
    }
}
