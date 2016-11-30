package graphics.graphics.details.model.board;

import graphics.frame.constants.FrameConstants;
import graphics.graphics.GameGraphics;
import graphics.graphics.clickable.Component;
import graphics.graphics.components.BoardOptionList;
import graphics.graphics.details.model.map.GameMap;
import graphics.graphics.details.model.tile.Tile;
import graphics.graphics.details.model.tile.field.Field;
import graphics.graphics.details.points.Coords;
import graphics.graphics.details.points.Point;
import graphics.graphics.details.points.Rect;
import graphics.graphics.details.points.Size;
import graphics.input.GameMouseEvent;
import graphics.utils.Mat;
import lombok.Getter;
import utils.Opt;

import java.util.List;
import java.util.stream.Collectors;

public class Board extends Component {

    private GameMap map;
    private TileArray tiles;

    private Size size;

    @Getter
    private Point delta = Point.of(0, 0);
    private Coords destination = new Coords(0, 0);
    private Coords current = new Coords(0, 0);

    public Board(Rect rect, GameMap map) {
        super(rect);

        this.map = map;
        this.size = rect.toSize().div(FrameConstants.baseTile);
        tiles = new TileArray(size.add(3, 3), this);
        registerRightMouseAction(this::rightMouse);
    }

    /* ========== PUBLIC ========== */
    @Override
    public void draw(GameGraphics g) {
        for (int i = -1; i <= size.getX(); ++i) {
            for (int j = -1; j <= size.getY(); ++j) {
                draw(g, new Coords(i, j));
            }
        }
    }

    @Override
    public void tick() {
        if (current.notEqual(destination)) {
            move();
        }

        map.tick();
    }

    public void setDestination(Coords coords) {
        Coords transformed = destination.plus(coords);

        if (checkCoords(transformed) && checkDifference()) {
            destination = transformed;
        }
    }

    /* ========== PRIVATE ========== */
    private void draw(GameGraphics g, Coords tileCoords) {
        Coords mapCoords = tileCoords.plus(current);
        map.get(mapCoords)
                .ifPresent(f -> drawTile(g, f, tiles.get(tileCoords)));
    }

    private void drawTile(GameGraphics g, Field field, Opt<Tile> tile) {
        tile.ifPresent(t -> drawTile(g, field, t));
    }

    private void drawTile(GameGraphics g, Field field, Tile tile) {
        tile.setField(field);
        g.draw(field.getTile().getImage(), tile.getRect().move(delta));
        field.getSettlement().ifPresent(s -> g.draw(s.getTile().getImage(), tile.getRect().move(delta)));
    }

    private boolean checkCoords(Coords coords) {
        return coords.check(map.getSize(), size);
    }

    private boolean checkDifference() {
        return current.difference(destination).length() < 3;
    }

    private void move() {
        int x = Mat.signum(current.xDifference(destination));
        int y = Mat.signum(current.yDifference(destination));

        if (nextTileNotReachedYet()) {
            delta = delta.add(8 * x, 8 * y);
        } else {
            switchCurrentLocation(x, y);
        }
    }

    private void switchCurrentLocation(int x, int y) {
        if (!lesser(delta.getY())) {
            current = current.plus(0, -y);
        }

        if (!lesser(delta.getX())) {
            current = current.plus(-x, 0);
        }
        delta = Point.of(0, 0);
    }

    private boolean nextTileNotReachedYet() {
        return lesser(delta.getX()) && lesser(delta.getY());
    }

    private boolean lesser(Integer x) {
        return Math.abs(x) < FrameConstants.baseTile;
    }

    private void rightMouse(GameMouseEvent e) {
        clear();
        add(new BoardOptionList(Rect.of(e.getPoint(), Point.of(32, 96).add(e.getPoint()))));
    }

    private void clear() {
        List<Component> collect = components.stream().filter(c -> c instanceof BoardOptionList).collect(Collectors.toList());
        components.removeAll(collect);
    }
}
