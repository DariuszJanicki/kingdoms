package pl.jamnic.games.kingdoms.model.model.map;

import lombok.Getter;
import lombok.Setter;
import pl.jamnic.games.kingdoms.model.model.building.Building;
import pl.jamnic.games.kingdoms.model.model.terrain.TerrainType;
import pl.jamnic.games.kingdoms.utils.points.Coords;
import utils.Opt;

@Getter
public final class Area extends AbstractArea {

    @Setter
    private Opt<Building> building = Opt.empty();

    /* ========== PUBLIC ========== */
    public Area(TerrainType terrain, Coords coords) {
        super(terrain, coords);
    }

    @Override
    public void tick() {
        building.ifPresent(Building::tick);
    }
}
