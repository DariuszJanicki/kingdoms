package engine.model.map;

import base.utils.GameArray;
import engine.model.Tickable;
import engine.points.Coords;
import engine.points.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import utils.Opt;

@Getter
@RequiredArgsConstructor
public final class GameMap<T extends AbstractArea> {

    private final Size size;
    private final GameArray<T> array;

    /* ========== PUBLIC ========== */
    public Opt<T> get(Coords coords) {
        return array.get(coords);
    }

    public void tick() {
        for (int i = 0; i <= size.getX(); ++i) {
            for (int j = 0; j <= size.getY(); ++j) {
                get(new Coords(i, j)).ifPresent(Tickable::tick);
            }
        }
    }
}
