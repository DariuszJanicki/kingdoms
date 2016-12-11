package view.component.setting;

import engine.points.Rect;
import input.Mouse;
import lombok.Getter;
import lombok.Setter;
import view.click.ClickFunctionMapper;

@Setter
@Getter
abstract class Clickable extends Tickable {

    private Mouse listener = new Mouse();

    /* ========== DEFAULT ========== */
    Clickable(Rect rect) {
        super(rect);
        addMouseListener(listener);
    }

    public ClickFunctionMapper getClickFunctionMapper() {
        return listener.getClickFunctionMapper();
    }

}
