package graphics.graphics;

import graphics.input.GameMouseEvent;
import lombok.Getter;
import utils.Bool;
import utils.Opt;

import java.util.function.Consumer;

@Getter
public final class ClickFunction {

    private Opt<Consumer<GameMouseEvent>> leftClick = Opt.empty();
    private Opt<Consumer<GameMouseEvent>> rightClick = Opt.empty();

    /* ========== PUBLIC ========== */
    public void click(GameMouseEvent e) {
        e.isLeftClicked().ifTrue(() -> leftClick.ifPresent(c -> c.accept(e)));
        e.isRightClicked().ifTrue(() -> rightClick.ifPresent(c -> c.accept(e)));
    }

    public ClickFunction registerLeft(Consumer<GameMouseEvent> function) {
        this.leftClick = Opt.ofNullable(function);
        return this;
    }

    public ClickFunction registerRight(Consumer<GameMouseEvent> function) {
        this.rightClick = Opt.ofNullable(function);
        return this;
    }

    public Bool hasAction(GameMouseEvent event) {
        return isRightClicked(event).or(isLeftClicked(event));
    }

    /* ========== PRIVATE ========== */
    private Bool isRightClicked(GameMouseEvent event) {
        return event.isRightClicked().and(rightClick.isPresent());
    }

    private Bool isLeftClicked(GameMouseEvent event) {
        return event.isLeftClicked().and(leftClick.isPresent());
    }
}
