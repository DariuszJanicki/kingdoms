package view.component.setting;

import engine.points.Rect;

abstract class Tickable extends Drawable {

    /* ========== CONSTRUCTOR ========== */
    Tickable(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    public void performTicks() {
    }
}
