package graphics.graphics.component;

import graphics.graphics.GameGraphics;
import graphics.graphics.details.points.Rect;

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
