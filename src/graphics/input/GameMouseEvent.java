package graphics.input;

import graphics.graphics.details.points.Point;
import utils.Bool;

import java.awt.event.MouseEvent;

/**
 * Wraps @link MouseEvent.
 */
public final class GameMouseEvent {

    private MouseEvent event;
    private Point point;

    /* ========== PUBLIC STATIC ========== */
    public static GameMouseEvent of(MouseEvent event) {
        return new GameMouseEvent(event);
    }

    /* ========== CONSTRUCTOR ========== */
    private GameMouseEvent(MouseEvent event) {
        this.event = event;
    }

    /* ========== PUBLIC ========== */
    public Point getPoint() {
        return point == null ? point = Point.of(event.getX(), event.getY()) : point;
    }

    public Bool isLeftClicked() {
        return Bool.of(event.getButton() == MouseEvent.BUTTON1);
    }

    public Bool isRightClicked() {
        return Bool.of(event.getButton() == MouseEvent.BUTTON3);
    }
}
