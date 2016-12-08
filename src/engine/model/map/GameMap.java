package engine.model.map;

import engine.points.Coords;
import engine.points.Size;
import engine.model.tile.field.Field;
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
        return Opt.ofNullable(coords.check(size)
                ? map[coords.getX()][coords.getY()]
                : null);
    }

    public void tick() {
        for (int i = 0; i <= size.getX(); ++i) {
            for (int j = 0; j <= size.getY(); ++j) {
                get(new Coords(i, j)).ifPresent(Field::tick);
            }
        }
    }
}
