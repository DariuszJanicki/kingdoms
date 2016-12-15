package view.component;

import engine.model.Tickable;
import engine.points.Point;
import engine.points.Rect;
import lombok.Setter;
import utils.Bool;
import utils.Opt;
import view.component.setting.AbstractComponent;

import java.awt.*;

public abstract class TileComponent<T extends Tickable> extends AbstractComponent {

    @Setter
    protected Point delta;
    protected Bool highlight = Bool.FALSE;

    protected Opt<T> element = Opt.empty();

    /* ========== PUBLIC ========== */
    public TileComponent(Rect rect) {
        super(rect);
    }

    public void setElement(T element) {
        this.element = Opt.ofNullable(element);
    }

    @Override
    public void draw(GameGraphics g) {
        element.ifPresent(f -> draw(g, f));
    }

    @Override
    public void performTicks() {
        element.ifPresent(Tickable::tick);
    }

    /* ========== PROTECTED ========== */
    protected abstract void draw(GameGraphics g, T t);

    protected void highlight(GameGraphics g) {
        highlight.ifTrue(() -> {
            g.setColor(new Color(255, 255, 255, 200));
            g.draw(rect.move(this.delta));
        });
    }
}
