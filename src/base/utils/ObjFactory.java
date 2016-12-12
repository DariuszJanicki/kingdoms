package base.utils;

import engine.points.Coords;

public interface ObjFactory<T>{

    T create(Coords coords);

}
