package view.component.setting;

import engine.points.Rect;
import input.Mouse;
import lombok.Getter;
import lombok.Setter;
import view.interfaces.ClickFunction;
import view.interfaces.HoverFunction;

@Setter
@Getter
abstract class Clickable extends Tickable {

    private Mouse listener = new Mouse();

    /* ========== DEFAULT ========== */
    Clickable(Rect rect) {
        super(rect);
        addMouseListener(listener);
    }

    public void registerClick(ClickFunction click) {
        listener.setClickFunction(click);
    }

    public void registerHover(HoverFunction hover) {
        listener.setHoverFunction(hover);
    }
}
