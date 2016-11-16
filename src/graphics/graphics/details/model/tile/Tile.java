package graphics.graphics.details.model.tile;

import graphics.graphics.GameGraphics;
import graphics.graphics.Rect;
import graphics.graphics.clickable.Component;
import graphics.graphics.details.model.tile.field.Field;

public class Tile extends Component {

    private Field field;

    /* ========== CONSTRUCTOR ========== */
    public Tile(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    public Tile setField(Field field) {
        this.field = field;
        return this;
    }

    public void draw(GameGraphics g) {
        g.draw(field.getTerrainTile().getImage(), rect);
    }
}
