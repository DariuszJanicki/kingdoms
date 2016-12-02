package graphics.graphics.component.setting;

import graphics.graphics.details.points.Rect;
import graphics.input.GameMouseEvent;
import utils.Bool;
import utils.Opt;

import java.util.function.Consumer;

abstract class Clickable extends Tickable {

    private Opt<Consumer<GameMouseEvent>> leftOnClick = Opt.empty();
    private Opt<Consumer<GameMouseEvent>> rightOnClick = Opt.empty();

    /* ========== CONSTRUCTOR ========== */
    Clickable(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    public void click(GameMouseEvent e) {
        e.isLeftClicked().ifTrue(() -> leftOnClick.ifPresent(c -> c.accept(e)));
        e.isRightClicked().ifTrue(() -> rightOnClick.ifPresent(c -> c.accept(e)));
    }

    /* ========== PROTECTED ========== */
    public void registerLeftMouseAction(Consumer<GameMouseEvent> functional) {
        this.leftOnClick = Opt.ofNullable(functional);
    }

    public void registerRightMouseAction(Consumer<GameMouseEvent> functional) {
        this.rightOnClick = Opt.ofNullable(functional);
    }

    /* ========== DEFAULT ========== */
    Bool hasAction(GameMouseEvent event) {
        return isRightClicked(event).or(isLeftClicked(event));
    }

    /* ========== PRIVATE ========== */
    private Bool isRightClicked(GameMouseEvent event) {
        return event.isRightClicked().and(rightOnClick.isPresent());
    }

    private Bool isLeftClicked(GameMouseEvent event) {
        return event.isLeftClicked().and(leftOnClick.isPresent());
    }
}
