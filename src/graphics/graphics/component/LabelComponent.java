package graphics.graphics.component;

import graphics.graphics.component.setting.AbstractComponent;
import graphics.graphics.GameGraphics;
import graphics.graphics.details.points.Rect;
import lombok.Getter;
import utils.Opt;

import java.awt.*;

public abstract class LabelComponent extends AbstractComponent {

    public static final int WIDTH_OFFSET = 5;
    public static final int HEIGHT_OFFSET = 15;

    @Getter
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
