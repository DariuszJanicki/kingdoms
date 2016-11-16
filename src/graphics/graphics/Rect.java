package graphics.graphics;

import graphics.graphics.details.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Rect {

    private Point startPoint;
    private Point endPoint;

    /* ========== CONSTRUCTOR ========== */
    public Rect(int x1, int y1, int x2, int y2) {
        this.startPoint = new Point(x1, y1);
        this.endPoint = new Point(x2, y2);
    }

    /* ========== PUBLIC ========== */
    public boolean contains(Point point) {
        return point.getX() >= startPoint.getX() &&
                point.getY() >= startPoint.getY() &&
                point.getX() <= endPoint.getX() &&
                point.getY() <= endPoint.getY();
    }

    @Override
    public String toString() {
        return startPoint + " - " + endPoint;
    }

    public Size toSize() {
        return new Size(endPoint.getX() - startPoint.getX(), endPoint.getY() - startPoint.getY());
    }
}
