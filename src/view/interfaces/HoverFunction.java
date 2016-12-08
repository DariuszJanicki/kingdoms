package view.interfaces;

import lombok.Getter;
import utils.Opt;

import java.awt.event.MouseEvent;
import java.util.function.Consumer;

@Getter
public final class HoverFunction {

    private Opt<Consumer<MouseEvent>> hover = Opt.empty();
    private Opt<Consumer<MouseEvent>> hoverOff = Opt.empty();

    /* ========== PUBLIC ========== */
    public static HoverFunction of() {
        return new HoverFunction();
    }

    public void hover(MouseEvent e) {
        hover.isPresent().ifTrue(() -> hover.ifPresent(c -> c.accept(e)));
    }

    public HoverFunction registerHover(Consumer<MouseEvent> function) {
        this.hover = Opt.ofNullable(function);
        return this;
    }

    public HoverFunction registerHoverOff(Consumer<MouseEvent> function) {
        this.hoverOff = Opt.ofNullable(function);
        return this;
    }

    public void hoverOff(MouseEvent e) {
        hoverOff.isPresent().ifTrue(() -> hoverOff.ifPresent(c -> c.accept(e)));
    }
}
