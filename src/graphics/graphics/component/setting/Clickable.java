package graphics.graphics.component.setting;

import graphics.graphics.ClickFunction;
import graphics.graphics.details.points.Rect;
import graphics.input.GameMouseEvent;
import lombok.Getter;
import lombok.Setter;
import utils.Bool;

@Setter
@Getter
abstract class Clickable extends Tickable {

    private ClickFunction clickFunction = new ClickFunction();

    /* ========== CONSTRUCTOR ========== */
    Clickable(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    public void click(GameMouseEvent e) {
        clickFunction.click(e);
    }

    /* ========== DEFAULT ========== */
    Bool hasAction(GameMouseEvent e) {
        return clickFunction.hasAction(e);
    }
}
