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
}
