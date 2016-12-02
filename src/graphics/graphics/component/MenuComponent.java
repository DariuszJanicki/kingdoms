package graphics.graphics.component;

import graphics.graphics.component.setting.AbstractComponent;
import graphics.graphics.GameGraphics;
import graphics.graphics.details.points.Rect;

import java.awt.*;

/**
 * Place for any other component.
 *
 * @author Janicki Dariusz
 */
public abstract class MenuComponent extends AbstractComponent {

    /* ========== CONSTRUCTOR ========== */
    public MenuComponent(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    @Override
    public void draw(GameGraphics g) {
        g.setColor(Color.white);
        g.draw(rect);
    }
}
