package view.generator;

import base.utils.GameArray;
import engine.model.map.GameMap;
import engine.model.map.SettlementArea;
import engine.model.terrain.TerrainType;
import engine.points.Coords;
import engine.points.Size;
import utils.Dice;

public enum AreaGenerator {

    INSTANCE;

    /* ========== PUBLIC ========== */
    public GameMap<SettlementArea> generateMap(Size size) {
        return new GameMap<>(size, new GameArray<>(size, this::createField));
    }

    /* ========== PRIVATE ========== */
    private SettlementArea createField(Coords coords) {
        TerrainType type = new Dice<TerrainType>().randomElementOf(TerrainType.values());
        return new SettlementArea(type, coords);
    }
}
