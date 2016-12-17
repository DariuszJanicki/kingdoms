package components.components.setting;

import components.input.key.KeyFunctionMapper;
import components.input.listener.Keyboard;
import components.input.listener.Mouse;
import components.input.mouse.MouseFunctionMapper;
import lombok.Getter;
import lombok.Setter;
import utils.Opt;
import utils.points.Rect;

@Setter
@Getter
abstract class Clickable extends Tickable {

    private Opt<Mouse> mouse = Opt.empty();
    private Opt<Keyboard> keyboard = Opt.empty();

    /* ========== DEFAULT ========== */
    Clickable(Rect rect) {
        super(rect);
    }

    public MouseFunctionMapper createClickMapper() {
        mouse.ifNotPresent(() -> {
            mouse = Opt.of(new Mouse());
            addMouseListener(mouse.get());
        });
        return mouse.get().getMouseMapping();
    }

    protected KeyFunctionMapper createKeyMapper() {
        keyboard.ifNotPresent(() -> {
            keyboard = Opt.of(new Keyboard());
            addKeyListener(keyboard.get());
        });
        return keyboard.get().getKeyMapping();
    }
}
