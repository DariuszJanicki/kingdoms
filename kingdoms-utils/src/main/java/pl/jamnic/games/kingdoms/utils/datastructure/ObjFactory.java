package pl.jamnic.games.kingdoms.utils.datastructure;

import pl.jamnic.games.kingdoms.utils.points.Coords;

public interface ObjFactory<T>{

    T create(Coords coords);

}
