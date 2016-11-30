package graphics.graphics.components;

import graphics.graphics.GameGraphics;
import graphics.graphics.components.abstrac.OptionListComponent;
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
