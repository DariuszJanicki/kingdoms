package graphics.graphics.details;

public class Size extends Tuple {

    /* ========== CONSTRUCTOR ========== */
    public Size(Integer x, Integer y) {
        super(x, y);
    }

    /* ========== CONSTRUCTOR ========== */
    public Size div(int div) {
        return new Size(x / div, y / div);
    }

    public Size plus(int x, int y) {
        return new Size(this.x + x, this.y + y);
    }
}
