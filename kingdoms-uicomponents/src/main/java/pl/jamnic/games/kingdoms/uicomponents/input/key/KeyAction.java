package pl.jamnic.games.kingdoms.uicomponents.input.key;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import utils.Bool;
import utils.Opt;

import java.awt.event.KeyEvent;
import java.util.Arrays;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum KeyAction {

    UP(KeyEvent.VK_UP, KeyEvent.KEY_PRESSED),
    DOWN(KeyEvent.VK_DOWN, KeyEvent.KEY_PRESSED),
    RIGHT(KeyEvent.VK_RIGHT, KeyEvent.KEY_PRESSED),
    LEFT(KeyEvent.VK_LEFT, KeyEvent.KEY_PRESSED);

    private Integer button;
    private Integer action;

    /* ========== STATIC ========== */
    public static Opt<KeyAction> of(KeyEvent event) {
        return Opt.of(Arrays.stream(values())
                .filter(action -> fits(action, event).isTrue())
                .findFirst());
    }

    private static Bool fits(KeyAction action, KeyEvent event) {
        return Bool.of(
                action.button.equals(event.getKeyCode()) &&
                action.action.equals(event.getID()));
    }
}
