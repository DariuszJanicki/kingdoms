package view.instances;

import base.frame.constants.FrameConstants;
import base.utils.Mat;
import engine.points.Coords;
import engine.points.Point;
import lombok.Getter;
import lombok.Setter;
import view.interfaces.Tickable;

class BoardScreenMover implements Tickable {

    private static final Integer ANIMATION_SPEED = 8;

    @Setter
    private Coords destinationView = new Coords();

    @Getter
    private Coords currentView = new Coords();

    @Getter
    private Point delta = Point.of();

    /* ========== PUBLIC ========== */
    @Override
    public void tick() {
        if (currentView.notEqual(destinationView)) {
            move();
        }
    }

    /* ========== DEFAULT ========== */
    boolean checkDifference() {
        return currentView.difference(destinationView).length() < 3;
    }

    Coords transform(Coords coords) {
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