package graphics.graphics;

import graphics.input.GameMouseEvent;
import lombok.Getter;
import utils.Bool;
import utils.Opt;

import java.util.function.Consumer;

@Getter
public final class HoverFunction {

    private Opt<Consumer<GameMouseEvent>> hover = Opt.empty();

    /* ========== PUBLIC ========== */
    public void hover(GameMouseEvent e) {
        e.isHover().ifTrue(() -> hover.ifPresent(c -> c.accept(e)));
    }

    public HoverFunction registerHover(Consumer<GameMouseEvent> function) {
        this.hover = Opt.ofNullable(function);
        return this;
    }

    public Bool hasHover(GameMouseEvent e) {
        return e.isHover().and(hover.isPresent());
    }
}
