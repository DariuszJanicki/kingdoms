package graphics.graphics.instances;

import graphics.graphics.GameGraphics;
import graphics.graphics.component.LabelComponent;
import graphics.graphics.details.points.Rect;

public class TileInfo extends LabelComponent {

    /* ========== CONSTRUCTOR ========== */
    public TileInfo(Rect rect) {
        super(rect);
    }

    @Override
    public void draw(GameGraphics g) {
        setText(model.getCurrentTileInfo());
        super.draw(g);
    }
}
