package graphics.graphics.component.setting;

import graphics.graphics.details.points.Rect;

abstract class Tickable extends Drawable {

    /* ========== CONSTRUCTOR ========== */
    Tickable(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    public void tick() {
    }
}
