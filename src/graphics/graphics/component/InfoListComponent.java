package graphics.graphics.component;

import graphics.graphics.GameGraphics;
import graphics.graphics.details.points.Rect;

import java.util.List;
import java.util.function.Supplier;

public class InfoListComponent extends ListComponent {

    private final Supplier<List<String>> supplier;

    /* ========== PUBLIC ========== */
    public InfoListComponent(Rect rect, Supplier<List<String>> supplier) {
        super(rect);
        this.supplier = supplier;
    }

    @Override
    public void draw(GameGraphics g) {
        setTexts(supplier.get());
        super.draw(g);
    }
}