package graphics.graphics.components;

import graphics.graphics.GameGraphics;
import graphics.graphics.Rect;
import graphics.graphics.clickable.Component;
import lombok.Setter;

import java.awt.*;

public class TextLabelComponent extends Component {

    @Setter
    private String label;

    /* ========== CONSTRUCTOR ========== */
    public TextLabelComponent(Rect rect, String label) {
        super(rect);
        this.label = label;
    }

    /* ========== CONSTRUCTOR ========== */
    @Override
    public void draw(GameGraphics g) {
        g.setColor(Color.BLACK);
        g.getGraphics().drawString(label, rect.getStartPoint().getX() + 5, rect.getStartPoint().getY() + 15);
    }
}
