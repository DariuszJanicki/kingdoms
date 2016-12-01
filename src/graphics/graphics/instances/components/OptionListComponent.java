package graphics.graphics.instances.components;

import graphics.graphics.GameGraphics;
import graphics.graphics.clickable.Component;
import graphics.graphics.details.points.Rect;

import java.awt.*;

/**
 * Option list which appears when mouse-right click is detected. Contains various options.
 *
 * @author Janicki Dariusz
 */
public abstract class OptionListComponent extends Component {

    /* ========== CONSTRUCTOR ========== */
    public OptionListComponent(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    @Override
    public void draw(GameGraphics g) {
        isVisible.ifTrue(() -> drawComponent(g));
    }

    /* ========== PROTECTED ========== */
    protected void drawComponent(GameGraphics g) {
        g.setColor(Color.white);
        g.draw(rect);
    }
}
