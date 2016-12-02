package graphics.graphics.component.setting;

import graphics.graphics.GameGraphics;
import graphics.graphics.details.points.Rect;

abstract class Drawable extends Rectangular {

    /* ========== CONSTRUCTOR ========== */
    Drawable(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    public abstract void draw(GameGraphics g);
}
