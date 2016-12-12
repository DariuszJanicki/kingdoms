package base.utils;

import engine.points.Coords;
import engine.points.Size;
import utils.Opt;

import java.util.ArrayList;
import java.util.List;

public final class GameArray<T> {

    private List<List<T>> array;
    private Size size;

    /* ========== PUBLIC ========== */
    public GameArray(Size size, ObjFactory<T> factory) {
        this.size = size;
        createTiles(factory);
    }

    public Opt<T> get(Coords coords) {
        return Opt.ofNullable(coords.check(size)
                ? array.get(coords.getX()).get(coords.getY())
                : null);
    }

    /* ========== PRIVATE ========== */
    private void createTiles(ObjFactory<T> factory) {
        array = new ArrayList<>(size.getX() + 2);
        for (int i = 0; i <= size.getX() + 1; ++i) {
            array.add(i, new ArrayList<>(size.getY() + 2));
            for (int j = 0; j <= size.getY() + 1; ++j) {
                array.get(i).add(j, factory.create(new Coords(i, j)));
            }
        }
    }
}
