package engine.model.field;

import view.loader.tile.TerrainTileType;
import engine.model.building.Building;
import engine.model.terrain.Terrain;
import engine.points.Coords;
import lombok.Getter;
import lombok.Setter;
import utils.Opt;
import view.interfaces.Tickable;

@Getter
public class Area implements Tickable {

    private final Terrain terrain;

    private final Coords coords;

    @Setter
    private Opt<Building> building = Opt.empty();

    /* ========== CONSTRUCTOR ========== */
    public Area(Terrain terrain, Coords coords) {
        this.terrain = terrain;
        this.coords = coords;
    }

    @Override
    public void tick() {
        building.ifPresent(Building::tick);
    }
}
