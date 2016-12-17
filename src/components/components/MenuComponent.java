package components.components;

import components.components.setting.AbstractComponent;
import utils.points.Rect;

import java.awt.*;

/**
 * Place for any other components.components.component.
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
