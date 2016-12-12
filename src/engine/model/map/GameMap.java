package engine.model.map;

import engine.points.Coords;
import engine.points.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import utils.Opt;
import view.interfaces.Tickable;

@Getter
@AllArgsConstructor
public final class GameMap<T extends Tickable> {

    private Size size;
    private T[][] map;

    /* ========== PUBLIC ========== */
    public Opt<T> get(Coords coords) {
        return Opt.ofNullable(coords.check(size)
                ? map[coords.getX()][coords.getY()]
                : null);
    }

    public void tick() {
        for (int i = 0; i <= size.getX(); ++i) {
            for (int j = 0; j <= size.getY(); ++j) {
                get(new Coords(i, j)).ifPresent(T::tick);
            }
        }
    }
}
