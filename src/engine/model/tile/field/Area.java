package engine.model.tile.field;

import engine.loader.tile.TerrainTileType;
import engine.model.settlement.Settlement;
import engine.model.terrain.Terrain;
import engine.points.Coords;
import lombok.Getter;
import lombok.Setter;
import utils.Opt;
import view.interfaces.Tickable;

@Getter
public class Area implements Tickable {

    private final Terrain terrain;

    @Setter
    private TerrainTileType tile;
    private final Coords coords;

    @Setter
    private Opt<Settlement> settlement = Opt.empty();

    /* ========== CONSTRUCTOR ========== */
    public Area(Terrain terrain, Coords coords) {
        this.terrain = terrain;
        this.coords = coords;
    }

    @Override
    public void tick() {
        settlement.ifPresent(Settlement::tick);
    }
}
