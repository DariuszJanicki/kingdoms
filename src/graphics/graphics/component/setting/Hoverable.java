package graphics.graphics.component.setting;

import graphics.graphics.HoverFunction;
import graphics.graphics.details.points.Rect;
import graphics.input.GameMouseEvent;
import lombok.Getter;
import lombok.Setter;
import utils.Bool;

@Setter
@Getter
abstract class Hoverable extends Clickable {

    private HoverFunction hoverFunction = new HoverFunction();

    /* ========== CONSTRUCTOR ========== */
    Hoverable(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    public void hover(GameMouseEvent e) {
        System.out.println(e + " " + this);
//        hoverFunction.hover(e);
    }

    Bool hasHover(GameMouseEvent e) {
        return hoverFunction.hasHover(e);
    }
}
