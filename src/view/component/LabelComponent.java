package view.component;

import view.component.setting.AbstractComponent;
import engine.points.Rect;
import lombok.Getter;
import utils.Opt;

import java.awt.*;

public abstract class LabelComponent extends AbstractComponent {

    private static final int WIDTH_OFFSET = 5;
    static final int HEIGHT_OFFSET = 15;

    @Getter
    protected Opt<String> text = Opt.empty();

    /* ========== PUBLIC ========== */
    public LabelComponent(Rect rect) {
        super(rect);
    }

    @Override
    public void draw(GameGraphics g) {
        text.ifPresent(t -> drawText(g, t));
    }

    /* ========== PROTECTED ========== */
    protected void setText(String text) {
        this.text = Opt.ofNullable(text);
    }

    /* ========== PRIVATE ========== */
    private void drawText(GameGraphics g, String t) {
        g.setColor(Color.BLACK);
        g.drawString(t, rect.getStartPoint().add(WIDTH_OFFSET, HEIGHT_OFFSET));
    }
}
