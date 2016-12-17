package pl.jamnic.games.kingdoms.view.instances.tile;

import lombok.Setter;
import pl.jamnic.games.kingdoms.model.model.Tickable;
import pl.jamnic.games.kingdoms.model.model.map.AbstractArea;
import pl.jamnic.games.kingdoms.uicomponents.components.GameGraphics;
import pl.jamnic.games.kingdoms.uicomponents.setting.AbstractComponent;
import pl.jamnic.games.kingdoms.utils.points.Point;
import pl.jamnic.games.kingdoms.utils.points.Rect;
import utils.Bool;
import utils.Opt;

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
