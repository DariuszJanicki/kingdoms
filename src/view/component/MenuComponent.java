package view.component;

import view.component.setting.AbstractComponent;
import view.interfaces.GameGraphics;
import engine.points.Rect;

import java.awt.*;

/**
 * Place for any other view.component.
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
