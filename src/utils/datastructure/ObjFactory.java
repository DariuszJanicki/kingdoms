package utils.datastructure;

import utils.points.Coords;

public interface ObjFactory<T>{

    T create(Coords coords);

}
