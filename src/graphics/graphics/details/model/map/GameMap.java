package graphics.graphics.details.model.map;

import graphics.graphics.details.Coords;
import graphics.graphics.details.Size;
import graphics.graphics.details.model.tile.field.Field;
import lombok.Getter;
import utils.Opt;

@Getter
public class GameMap {

    private Size size;
    private Field[][] map;

    /* ========== CONSTRUCTOR ========== */
    public GameMap(Size size, Field[][] map) {
        this.size = size;
        this.map = map;
    }

    /* ========== PUBLIC ========== */
    public Opt<Field> get(Coords coords) {
        return Opt.ofNullable(checkX(coords) && checkY(coords)
                ? map[coords.getX()][coords.getY()]
                : null);
    }

    public int getX() {
        return size.getX();
    }

    public int getY() {
        return size.getY();
    }

    /* ========== PRIVATE ========== */
    private boolean checkX(Coords coords) {
        return coords.getX() >= 0 && coords.getX() < size.getX();
    }

    private boolean checkY(Coords coords) {
        return coords.getY() >= 0 && coords.getY() < size.getY();
    }
}
