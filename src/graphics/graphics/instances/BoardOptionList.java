package graphics.graphics.instances;

import graphics.graphics.GameGraphics;
import graphics.graphics.instances.components.OptionListComponent;
import graphics.graphics.details.points.Rect;

import java.awt.*;

public class BoardOptionList extends OptionListComponent {

    /* ========== CONSTRUCTOR ========== */
    public BoardOptionList(Rect rect) {
        super(rect);
    }

    /* ========== PROTECTED ========== */
    protected void drawComponent(GameGraphics g) {
        g.setColor(Color.white);
        g.draw(rect);
    }
}
