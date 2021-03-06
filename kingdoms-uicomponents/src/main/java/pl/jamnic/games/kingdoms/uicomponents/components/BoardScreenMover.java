package pl.jamnic.games.kingdoms.uicomponents.components;

import pl.jamnic.games.kingdoms.constants.FrameConstants;
import lombok.Getter;
import lombok.Setter;
import pl.jamnic.games.kingdoms.utils.math.Mat;
import pl.jamnic.games.kingdoms.utils.points.Coords;
import pl.jamnic.games.kingdoms.utils.points.Point;

public final class BoardScreenMover {

    private static final Integer ANIMATION_SPEED = 8;

    @Setter
    private Coords destinationView = new Coords();

    @Getter
    private Coords currentView = new Coords();

    @Getter
    private Point delta = Point.of();

    /* ========== PUBLIC ========== */
    public void tick() {
        if (currentView.notEqual(destinationView)) {
            move();
        }
    }

    /* ========== DEFAULT ========== */
    public boolean checkDifference() {
        return currentView.difference(destinationView).length() < 3;
    }

    public Coords transform(Coords coords) {
        return destinationView.plus(coords);
    }

    /* ========== PRIVATE ========== */
    private void move() {
        Integer x = Mat.signum(currentView.xDifference(destinationView));
        Integer y = Mat.signum(currentView.yDifference(destinationView));

        if (nextTileNotReachedYet()) {
            delta = (delta.add(Point.of(x, y).mul(ANIMATION_SPEED)));
        } else {
            switchCurrentLocation(x, y);
        }
    }

    private void switchCurrentLocation(Integer x, Integer y) {
        if (!lesser(delta.getY())) {
            currentView = currentView.plus(0, -y);
        }

        if (!lesser(delta.getX())) {
            currentView = currentView.plus(-x, 0);
        }
        delta = Point.of();
    }

    private boolean nextTileNotReachedYet() {
        return lesser(delta.getX()) && lesser(delta.getY());
    }

    private boolean lesser(Integer x) {
        return Math.abs(x) < FrameConstants.baseTile;
    }
}