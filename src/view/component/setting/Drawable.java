package view.component.setting;

import view.component.GameGraphics;
import engine.points.Rect;

abstract class Drawable extends Rectangular {

    /* ========== DEFAULT ========== */
    Drawable(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    public abstract void draw(GameGraphics g);
}
