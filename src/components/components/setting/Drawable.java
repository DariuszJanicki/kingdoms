package components.components.setting;

import components.components.GameGraphics;
import utils.points.Rect;

abstract class Drawable extends Rectangular {

    /* ========== DEFAULT ========== */
    Drawable(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    public abstract void draw(GameGraphics g);
}
