package pl.jamnic.games.kingdoms.utils.points;

public final class Point extends Tuple {

    /* ========== CONSTRUCTOR ========== */
    private Point(Integer x, Integer y) {
        super(x, y);
    }

    /* ========== STATIC ========== */
    public static Point of(Integer x, Integer y) {
        return new Point(x, y);
    }

    public static Point of() {
        return Point.of(0, 0);
    }

    /* ========== OVERRIDE ========== */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /* ========== PUBLIC ========== */
    public Point mul(Integer mul) {
        return new Point(x * mul, y * mul);
    }

    public Point add(Integer x, Integer y) {
        return new Point(this.x + x, this.y + y);
    }

    public Point add(Point point) {
        return add(point.x, point.y);
    }

    public Point diff(Point point) {
        return new Point(this.x - point.x, this.y - point.y);
    }

    public static Point of(java.awt.Point point) {
        return new Point((int) point.getX(), (int) point.getY());
    }
}
