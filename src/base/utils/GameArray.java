package base.utils;

import engine.points.Coords;
import engine.points.Size;
import utils.Opt;

public class GameArray<T> {

    private T[][] array;
    private Size size;

    public GameArray(Size size) {
        this.size = size;
    }

    public Opt<T> get(Coords coords) {
        return Opt.ofNullable(coords.check(size)
                ? array[coords.getX()][coords.getY()]
                : null);
    }

}
