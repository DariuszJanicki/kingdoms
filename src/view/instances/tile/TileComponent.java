package view.instances.tile;

import components.components.GameGraphics;
import engine.model.Tickable;
import engine.model.map.AbstractArea;
import utils.points.Point;
import utils.points.Rect;
import lombok.Setter;
import utils.Bool;
import utils.Opt;
import components.components.setting.AbstractComponent;

import java.awt.*;

public abstract class TileComponent<T extends AbstractArea> extends AbstractComponent {

    @Setter
    protected Point delta;
    Bool highlight = Bool.FALSE;

    Opt<T> element = Opt.empty();

    /* ========== PUBLIC ========== */
    TileComponent(Rect rect) {
        super(rect);
    }

    void setElement(T element) {
        this.element = Opt.ofNullable(element);
    }

    @Override
    public void performTicks() {
        element.ifPresent(Tickable::tick);
    }

    /* ========== PROTECTED ========== */
    void highlight(GameGraphics g) {
        highlight.ifTrue(() -> {
            g.setColor(new Color(255, 255, 255, 200));
            g.draw(rect.move(this.delta));
        });
    }
}
