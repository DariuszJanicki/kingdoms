package graphics.graphics.components;

import graphics.frame.constants.FrameConstants;
import graphics.graphics.GameGraphics;
import graphics.graphics.Rect;
import graphics.graphics.clickable.Component;

import java.awt.*;

public class GameMenu extends Component {

    public GameMenu(Rect rect) {
        super(rect);

        registerComponent(new TextLabelComponent(new Rect(0, 0, FrameConstants.baseTile * 3, FrameConstants.baseTile * 3), "Test label"));
    }

    @Override
    public void draw(GameGraphics g) {
        g.setColor(Color.white);
        g.draw(rect);
    }
}
