package graphics.graphics.components;

import graphics.graphics.GameGraphics;
import graphics.graphics.Rect;
import graphics.graphics.clickable.Component;

import java.awt.*;
import java.util.Objects;

public class TextLabelComponent extends Component {

    /* ========== CONSTRUCTOR ========== */
    public TextLabelComponent(Rect rect) {
        super(rect);
    }

    /* ========== CONSTRUCTOR ========== */
    @Override
    public void draw(GameGraphics g) {
        g.setColor(Color.BLACK);
        String currentTileInfo = model.getCurrentTileInfo();
        if (Objects.nonNull(currentTileInfo)) {
            g.getGraphics().drawString(currentTileInfo, rect.getStartPoint().getX() + 5, rect.getStartPoint().getY() + 15);
        }
    }
}
