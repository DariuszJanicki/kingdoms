package view.component.setting;

import view.interfaces.GameGraphics;
import engine.points.Rect;

abstract class Drawable extends Rectangular {

    /* ========== CONSTRUCTOR ========== */
    Drawable(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    public abstract void draw(GameGraphics g);
}