package graphics.graphics.details.model.tile.field;

import graphics.graphics.details.Coords;
import graphics.graphics.details.loader.TerrainTileType;
import graphics.graphics.details.model.terrain.Terrain;
import lombok.Getter;

@Getter
public class Field {

    private Terrain terrain;
    private TerrainTileType terrainTile;
    private Coords coords;

    /* ========== CONSTRUCTOR ========== */
    public Field(Terrain terrain, Coords coords) {
        this.terrain = terrain;
        this.coords = coords;
    }

    /* ========== PUBLIC ========== */
    public void setTerrainTile(TerrainTileType terrainTile) {
        this.terrainTile = terrainTile;
    }
}
