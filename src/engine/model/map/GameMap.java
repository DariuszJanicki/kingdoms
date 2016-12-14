package engine.model.map;

import base.utils.GameArray;
import engine.points.Coords;
import engine.points.Size;
import lombok.Getter;
import utils.Opt;
import view.generator.AreaGenerator;
import view.interfaces.Tickable;

@Getter
public final class GameMap<T extends Tickable> {

    private Size size;
    private T[][] map;
    private GameArray<T> array;

    /* ========== PUBLIC ========== */
    public GameMap(Size size, T[][] map) {
        this.size = size;
        this.map = map;
        array = new GameArray<>(size, coords -> (T) AreaGenerator.INSTANCE.createField(coords));
    }

    public Opt<T> get(Coords coords) {
        return Opt.ofNullable(coords.check(size)
                ? map[coords.getX()][coords.getY()]
                : null);
    }

    public void tick() {
        for (int i = 0; i <= size.getX(); ++i) {
            for (int j = 0; j <= size.getY(); ++j) {
                get(new Coords(i, j)).ifPresent(t -> t.tick());
            }
        }
    }
}
