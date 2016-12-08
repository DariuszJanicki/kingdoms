package view.component;

import view.interfaces.GameGraphics;
import engine.points.Rect;

import java.util.function.Supplier;

public final class InfoComponent extends LabelComponent {

    private final Supplier<String> supplier;

    /* ========== PUBLIC ========== */
    public InfoComponent(Rect rect, Supplier<String> supplier) {
        super(rect);
        this.supplier = supplier;
    }

    @Override
    public void draw(GameGraphics g) {
        setText(supplier.get());
        super.draw(g);
    }
}
