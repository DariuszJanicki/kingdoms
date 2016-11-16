package graphics.graphics.components;

import graphics.frame.constants.FrameConstants;
import graphics.graphics.GameGraphics;
import graphics.graphics.Rect;
import graphics.graphics.clickable.Component;

import java.awt.*;

public class GameMenu extends Component {

    /* ========== CONSTRUCTOR ========== */
    public GameMenu(Rect rect) {
        super(rect);
        registerComponent(createTextLabel());
    }

    /* ========== PUBLIC ========== */
    @Override
    public void draw(GameGraphics g) {
        g.setColor(Color.white);
        g.draw(rect);
    }

    /* ========== PRIVATE ========== */
    private TextLabelComponent createTextLabel() {
        return new TextLabelComponent(new Rect(0, 0, FrameConstants.baseTile * 3, FrameConstants.baseTile * 3));
    }
}
