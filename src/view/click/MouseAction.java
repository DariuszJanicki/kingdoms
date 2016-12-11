package view.click;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import utils.Bool;
import utils.Opt;

import java.awt.event.MouseEvent;
import java.util.Arrays;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum MouseAction {

    LEFT_CLICK(MouseEvent.BUTTON1, MouseEvent.MOUSE_PRESSED),
    RIGHT_CLICK(MouseEvent.BUTTON3, MouseEvent.MOUSE_PRESSED),
    HOVER(MouseEvent.NOBUTTON, MouseEvent.MOUSE_ENTERED),
    HOVER_EXIT(MouseEvent.NOBUTTON, MouseEvent.MOUSE_EXITED);

    private Integer button;
    private Integer action;

    /* ========== STATIC ========== */
    public static Opt<MouseAction> of(MouseEvent event) {
        return Opt.of(Arrays.stream(values())
                .filter(action -> fits(action, event).isTrue())
                .findFirst());
    }

    private static Bool fits(MouseAction action, MouseEvent event) {
        return Bool.of(action.button.equals(event.getButton()) &&
                action.action.equals(event.getID()));
    }
}
