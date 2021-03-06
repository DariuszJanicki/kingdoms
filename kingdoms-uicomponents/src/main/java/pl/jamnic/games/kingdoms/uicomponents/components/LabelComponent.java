package pl.jamnic.games.kingdoms.uicomponents.components;

import pl.jamnic.games.kingdoms.uicomponents.setting.AbstractComponent;
import pl.jamnic.games.kingdoms.utils.points.Rect;
import lombok.Getter;
import utils.Opt;

import java.awt.*;

public abstract class LabelComponent extends AbstractComponent {

    private static final int WIDTH_OFFSET = 5;
    public static final int HEIGHT_OFFSET = 15;

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
