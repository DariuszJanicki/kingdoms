package components.input.key;

import lombok.Getter;
import utils.Opt;

import java.awt.event.KeyEvent;

@Getter
public final class GameKeyEvent {

    private KeyEvent event;
    private Opt<KeyAction> action = Opt.empty();

    /* ========== PUBLIC ========== */
    public GameKeyEvent(KeyEvent event) {
        event.getID();
        this.event = event;
        this.action = KeyAction.of(event);
    }
}
