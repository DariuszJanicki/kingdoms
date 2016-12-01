package graphics.graphics.instances.components;

import graphics.graphics.GameGraphics;
import graphics.graphics.clickable.Component;
import graphics.graphics.details.points.Rect;
import utils.Opt;

import java.awt.*;

public abstract class LabelComponent extends Component {

    private static final int WIDTH_OFFSET = 5;
    private static final int HEIGHT_OFFSET = 15;

    protected Opt<String> text = Opt.empty();

    /* ========== CONSTRUCTOR ========== */
    public LabelComponent(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    @Override
    public void draw(GameGraphics g) {
        text.ifPresent(t -> drawText(g, t));
    }

    /* ========== PRIVATE ========== */
    private void drawText(GameGraphics g, String t) {
        g.setColor(Color.BLACK);
        g.getGraphics().drawString(t,
                rect.getStartPoint().getX() + WIDTH_OFFSET,
                rect.getStartPoint().getY() + HEIGHT_OFFSET
        );
    }
}
