package view.instances.tile;

import base.frame.constants.FrameConstants;
import engine.model.map.Field;
import engine.model.map.GameMap;
import engine.points.Coords;
import engine.points.Point;
import engine.points.Rect;
import lombok.Getter;
import utils.Opt;
import view.component.GameGraphics;
import view.component.TileBoardComponent;

import java.util.stream.Collectors;

public final class FieldTileBoard extends TileBoardComponent<FieldTile> {

    @Getter
    private final GameMap<Field> map;

    /* ========== PUBLIC ========== */
    public FieldTileBoard(Rect rect, GameMap<Field> map) {
        super(rect);
        this.map = map;
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
                .ifPresent(field -> draw(field, getTiles().get(tileCoords)));
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
    private void draw(Field field, Opt<FieldTile> tile) {
        tile.ifPresent(t -> draw(field, t));
    }

    private void draw(Field field, FieldTile tile) {
        tile.setElement(field);
        tile.setDelta(boardScreenMover.getDelta());
    }

    private boolean checkCoords(Coords coords) {
        return coords.check(map.getSize(), getBoardSize());
    }
}
