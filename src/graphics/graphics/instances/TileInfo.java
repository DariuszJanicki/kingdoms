package graphics.graphics.instances;

import graphics.graphics.GameGraphics;
import graphics.graphics.details.points.Rect;
import graphics.graphics.component.LabelComponent;
import utils.Opt;

public class TileInfo extends LabelComponent {

    /* ========== CONSTRUCTOR ========== */
    public TileInfo(Rect rect) {
        super(rect);
    }

    @Override
    public void draw(GameGraphics g) {
        text = Opt.ofNullable(model.getCurrentTileInfo());
        super.draw(g);
    }
}
