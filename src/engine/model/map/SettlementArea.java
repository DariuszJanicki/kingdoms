package engine.model.map;

import engine.model.building.Building;
import engine.model.terrain.TerrainType;
import engine.points.Coords;
import lombok.Getter;
import lombok.Setter;
import utils.Opt;

@Getter
public final class SettlementArea extends AbstractArea {

    @Setter
    private Opt<Building> building = Opt.empty();

    /* ========== PUBLIC ========== */
    public SettlementArea(TerrainType terrain, Coords coords) {
        super(terrain, coords);
    }

    @Override
    public void tick() {
        building.ifPresent(Building::tick);
    }
}
