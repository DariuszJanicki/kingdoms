package view.component;

import view.interfaces.GameGraphics;
import view.component.setting.AbstractComponent;
import engine.points.Rect;
import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class ListComponent extends AbstractComponent {

    private static final int WIDTH_OFFSET = 5;
    private static final int HEIGHT_OFFSET = 15;

    @Getter
    protected List<String> texts = new ArrayList<>();

    /* ========== PUBLIC ========== */
    @Override
    public void draw(GameGraphics g) {
        for(int i = 0; i < texts.size(); ++i) {
            drawText(g, texts.get(i), i);
        }
    }

    /* ========== DEFAULT ========== */
    ListComponent(Rect rect) {
        super(rect);
    }

    void setTexts(List<String> texts) {
        if (Objects.nonNull(texts)) {
            this.texts = new ArrayList<>(texts);
        }
    }

    /* ========== PRIVATE ========== */
    private void drawText(GameGraphics g, String text, Integer index) {
        g.setColor(Color.BLACK);
        g.drawString(text, rect.getStartPoint().add(WIDTH_OFFSET, (index + 1) * HEIGHT_OFFSET));
    }
}
