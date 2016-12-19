package pl.jamnic.games.kingdoms.uicomponents.setting;

import pl.jamnic.games.kingdoms.utils.points.Rect;

abstract class Tickable extends Drawable {

    /* ========== CONSTRUCTOR ========== */
    Tickable(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    public void performTicks() {
    }
}
