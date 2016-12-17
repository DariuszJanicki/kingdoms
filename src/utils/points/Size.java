package utils.points;

public final class Size extends Tuple {

    /* ========== CONSTRUCTOR ========== */
    private Size(Integer x, Integer y) {
        super(x, y);
    }

    /* ========== STATIC ========== */
    public static Size of(Integer x, Integer y) {
        return new Size(x, y);
    }

    /* ========== PUBLIC ========== */
    public Size div(int div) {
        return new Size(x / div, y / div);
    }

    public Size add(int x, int y) {
        return new Size(this.x + x, this.y + y);
    }
}
