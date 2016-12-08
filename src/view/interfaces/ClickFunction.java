package view.interfaces;

import lombok.Getter;
import utils.Bool;
import utils.Opt;

import java.awt.event.MouseEvent;
import java.util.function.Consumer;

@Getter
public final class ClickFunction {

    private Opt<Consumer<MouseEvent>> leftClick = Opt.empty();
    private Opt<Consumer<MouseEvent>> rightClick = Opt.empty();

    /* ========== PUBLIC ========== */
    public static ClickFunction of() {
        return new ClickFunction();
    }

    public void click(MouseEvent e) {
        isLeftClicked(e).ifTrue(() -> leftClick.ifPresent(c -> c.accept(e)));
        isRightClicked(e).ifTrue(() -> rightClick.ifPresent(c -> c.accept(e)));
    }

    public ClickFunction registerLeft(Consumer<MouseEvent> function) {
        this.leftClick = Opt.ofNullable(function);
        return this;
    }

    public ClickFunction registerRight(Consumer<MouseEvent> function) {
        this.rightClick = Opt.ofNullable(function);
        return this;
    }

    /* ========== PRIVATE ========== */
    private Bool isLeftClicked(MouseEvent event) {
        return Bool.of(event.getButton() == MouseEvent.BUTTON1);
    }

    private Bool isRightClicked(MouseEvent event) {
        return Bool.of(event.getButton() == MouseEvent.BUTTON3);
    }
}
