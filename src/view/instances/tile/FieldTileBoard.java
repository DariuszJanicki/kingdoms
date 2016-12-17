package view.instances.tile;

import components.components.GameGraphics;
import components.components.TileBoardComponent;
import components.input.key.KeyAction;
import constants.FrameConstants;
import engine.model.map.Field;
import engine.model.map.GameMap;
import lombok.Getter;
import utils.Opt;
import utils.points.Coords;
import utils.points.Point;
import utils.points.Rect;

import java.util.stream.Collectors;

public final class FieldTileBoard extends TileBoardComponent<FieldTile> {

    @Getter
    private final GameMap<Field> map;

    /* ========== PUBLIC ========== */
    public FieldTileBoard(Rect rect, GameMap<Field> map) {
        super(rect);
        this.map = map;
        setFocusable(true);
        createKeyMapper()
                .register(KeyAction.UP, e -> setDestinationView(Coords.toNorth()))
                .register(KeyAction.DOWN, e -> setDestinationView(Coords.toSouth()))
                .register(KeyAction.RIGHT, e -> setDestinationView(Coords.toEast()))
                .register(KeyAction.LEFT, e -> setDestinationView(Coords.toWest()));
    }

    @Override
    public void performTicks() {
        boardScreenMover.tick();
        map.tick();
    }

    public void clear() {
        componentsToRemove
                .addAll(gameComponents
                        .stream()
                        .filter(c -> c.isTemporary().isTrue())
                        .collect(Collectors.toList()));
    }

    /* ========== PROTECTED ========== */
    @Override
    protected void draw(GameGraphics g, Coords tileCoords) {
        map.get(tileCoords.plus(boardScreenMover.getCurrentView()))
                .ifPresent(field -> prepareToDraw(field, getTiles().get(tileCoords)));
    }

    @Override
    protected FieldTile tileFactoryMethod(Coords coords) {
        Point point = Point.of(coords.getX(), coords.getY()).mul(FrameConstants.baseTile).add(rect.getStartPoint());
        FieldTile tile = new FieldTile(
                new Rect(point, point.add(FrameConstants.baseTile, FrameConstants.baseTile)), this);
        addComponent(tile);
        return tile;
    }

    /* ========== PRIVATE ========== */
    private void prepareToDraw(Field field, Opt<FieldTile> tile) {
        tile.ifPresent(t -> prepareToDraw(field, t));
    }

    private void prepareToDraw(Field field, FieldTile tile) {
        tile.setElement(field);
        tile.setDelta(boardScreenMover.getDelta());
    }

    private void setDestinationView(Coords coords) {
        Coords plus = boardScreenMover.transform(coords);
        if (checkCoords(plus) && boardScreenMover.checkDifference()) {
            boardScreenMover.setDestinationView(plus);
        }
    }

    private boolean checkCoords(Coords coords) {
        return coords.check(map.getSize(), getBoardSize());
    }
}
