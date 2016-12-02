package graphics.graphics.details.model.tile;

import graphics.graphics.component.setting.AbstractComponent;
import graphics.graphics.GameGraphics;
import graphics.graphics.details.model.tile.field.Field;
import graphics.graphics.details.points.Rect;
import graphics.input.GameMouseEvent;

public class Tile extends AbstractComponent {

    private Field field;

    /* ========== CONSTRUCTOR ========== */
    public Tile(Rect rect) {
        super(rect);
        registerLeftMouseAction(this::leftMouse);
    }

    /* ========== PUBLIC ========== */
    public Tile setField(Field field) {
        this.field = field;
        return this;
    }

    @Override
    public void draw(GameGraphics g) {
    }

    @Override
    public void tick() {
        field.tick();
    }

    /* ========== PRIVATE ========== */
    private void leftMouse(GameMouseEvent e) {
        model.setCurrentTileInfo(field.getTerrain() + " " + field.getCoords());
    }
}
