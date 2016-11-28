package graphics.graphics.details.points;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class Rect {

    private Point startPoint;
    private Point endPoint;

    /* ========== PRIVATE CONSTRUCTOR ========== */
    private Rect(Integer x1, Integer y1, Integer x2, Integer y2) {
        this.startPoint = Point.of(x1, y1);
        this.endPoint = Point.of(x2, y2);
    }

    /* ========== FACTORY ========== */
    public static Rect of(Integer x1, Integer y1, Integer x2, Integer y2) {
        return new Rect(x1, y1, x2, y2);
    }

    /* ========== OVERRIDE ========== */
    @Override
    public String toString() {
        return startPoint + " - " + endPoint;
    }

    /* ========== PUBLIC ========== */
    public boolean contains(Point point) {
        return point.getX() >= startPoint.getX() &&
                point.getY() >= startPoint.getY() &&
                point.getX() <= endPoint.getX() &&
                point.getY() <= endPoint.getY();
    }

    public Size toSize() {
        return Size.of(endPoint.getX() - startPoint.getX(), endPoint.getY() - startPoint.getY());
    }

    public Rect move(Point point) {
        return new Rect(startPoint.add(point), endPoint.add(point));
    }
}
