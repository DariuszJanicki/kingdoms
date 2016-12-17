package engine.model.map;

import utils.datastructure.GameArray;
import engine.model.Tickable;
import utils.points.Coords;
import utils.points.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import utils.Opt;

@Getter
@RequiredArgsConstructor
public final class GameMap<T extends AbstractArea> {

    private final Size size;
    @Getter
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
