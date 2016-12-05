package graphics.graphics.instances;

import graphics.graphics.GameGraphics;
import graphics.graphics.component.ListComponent;
import graphics.graphics.details.points.Rect;

public class TileSettlementInfo extends ListComponent {

    /* ========== CONSTRUCTOR ========== */
    public TileSettlementInfo(Rect rect) {
        super(rect);
    }

    @Override
    public void draw(GameGraphics g) {
        setTexts(model.getVillagers());
        super.draw(g);
    }
}
