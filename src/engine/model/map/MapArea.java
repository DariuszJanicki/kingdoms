package engine.model.map;

import engine.model.settlement.Settlement;
import engine.model.terrain.TerrainType;
import engine.points.Coords;
import lombok.Getter;
import lombok.Setter;
import utils.Opt;

@Getter
public final class MapArea extends AbstractArea {

    @Setter
    private Opt<Settlement> settlement = Opt.empty();

    /* ========== PUBLIC ========== */
    public MapArea(TerrainType terrain, Coords coords) {
        super(terrain, coords);
    }

    @Override
    public void tick() {
        settlement.ifPresent(Settlement::tick);
    }
}
