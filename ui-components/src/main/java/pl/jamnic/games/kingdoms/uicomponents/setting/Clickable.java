package pl.jamnic.games.kingdoms.uicomponents.setting;

import pl.jamnic.games.kingdoms.uicomponents.input.key.KeyFunctionMapper;
import pl.jamnic.games.kingdoms.uicomponents.input.listener.Keyboard;
import pl.jamnic.games.kingdoms.uicomponents.input.listener.Mouse;
import pl.jamnic.games.kingdoms.uicomponents.input.mouse.MouseFunctionMapper;
import lombok.Getter;
import lombok.Setter;
import utils.Opt;
import pl.jamnic.games.kingdoms.utils.points.Rect;

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
