package pl.jamnic.games.kingdoms.uicomponents.setting;

import pl.jamnic.games.kingdoms.uicomponents.components.GameGraphics;
import pl.jamnic.games.kingdoms.utils.points.Rect;

abstract class Drawable extends Rectangular {

    /* ========== DEFAULT ========== */
    Drawable(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    public abstract void draw(GameGraphics g);
}
