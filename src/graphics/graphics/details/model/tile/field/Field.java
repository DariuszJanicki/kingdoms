package graphics.graphics.details.model.tile.field;

import graphics.graphics.details.loader.tile.TerrainTileType;
import graphics.graphics.details.model.settlement.Settlement;
import graphics.graphics.details.model.terrain.Terrain;
import graphics.graphics.details.points.Coords;
import lombok.Getter;
import lombok.Setter;
import utils.Opt;

@Getter
public class Field {

    private final Terrain terrain;

    @Setter
    private TerrainTileType tile;
    private final Coords coords;

    @Setter
    private Opt<Settlement> settlement = Opt.empty();

    /* ========== CONSTRUCTOR ========== */
    public Field(Terrain terrain, Coords coords) {
        this.terrain = terrain;
        this.coords = coords;
    }
}
