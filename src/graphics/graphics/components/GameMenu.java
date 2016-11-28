package graphics.graphics.components;

import graphics.graphics.GameGraphics;
import graphics.graphics.details.points.Rect;
import graphics.graphics.clickable.Component;

import java.awt.*;

public class GameMenu extends Component {

    /* ========== CONSTRUCTOR ========== */
    public GameMenu(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    @Override
    public void draw(GameGraphics g) {
        g.setColor(Color.white);
        g.draw(rect);
    }
}
