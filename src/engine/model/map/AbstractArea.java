package engine.model.map;

import engine.model.terrain.TerrainType;
import utils.points.Coords;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import engine.model.Tickable;

@Getter
@RequiredArgsConstructor
public abstract class AbstractArea implements Tickable {

    private final TerrainType terrain;
    private final Coords coords;
}
