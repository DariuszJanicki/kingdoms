package pl.jamnic.games.kingdoms.model.model.map;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.jamnic.games.kingdoms.model.model.Tickable;
import pl.jamnic.games.kingdoms.model.model.terrain.TerrainType;
import pl.jamnic.games.kingdoms.utils.points.Coords;

@Getter
@RequiredArgsConstructor
public abstract class AbstractArea implements Tickable {

    private final TerrainType terrain;
    private final Coords coords;
}
