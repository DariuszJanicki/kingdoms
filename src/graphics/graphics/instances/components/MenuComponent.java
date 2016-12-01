package graphics.graphics.instances.components;

import graphics.graphics.GameGraphics;
import graphics.graphics.clickable.Component;
import graphics.graphics.details.points.Rect;

import java.awt.*;

/**
 * Place for any other components.
 *
 * @author Janicki Dariusz
 */
public abstract class MenuComponent extends Component {

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
