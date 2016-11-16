package graphics.graphics.details;

import graphics.frame.constants.FrameConstants;
import graphics.graphics.Point;

public class Coords extends Tuple {

    /* ========== CONSTRUCTOR ========== */
    public Coords(Integer x, Integer y) {
        super(x, y);
    }

    /* ========== PUBLIC ========== */
    public Point toPoint() {
        return new Point(x, y).mul(FrameConstants.baseTile);
    }

    public Coords plus(Coords coords) {
        return new Coords(x + coords.x, y + coords.y);
    }

    public Coords north() {
        return new Coords(x, y - 1);
    }

    public Coords south() {
        return new Coords(x, y + 1);
    }

    public Coords east() {
        return new Coords(x + 1, y);
    }

    public Coords west() {
        return new Coords(x - 1, y);
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
