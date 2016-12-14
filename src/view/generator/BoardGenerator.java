package view.generator;

import base.utils.GameArray;
import engine.model.map.GameMap;
import engine.model.map.MapArea;
import engine.model.terrain.TerrainType;
import engine.points.Coords;
import engine.points.Size;
import utils.Dice;
import utils.Opt;

public enum BoardGenerator {

    INSTANCE;

    /* ========== PUBLIC ========== */
    public GameMap<MapArea> generateMap(Size size) {
        return new GameMap<>(size, new GameArray<>(size, this::createField));
    }

    /* ========== PRIVATE ========== */
    private MapArea createField(Coords coords) {
        TerrainType type = new Dice<TerrainType>().randomElementOf(TerrainType.values());

        MapArea mapArea = new MapArea(type, new Coords(coords.getX(), coords.getY()));
        if (Dice.k(100) == 0 && mapArea.getTerrain() != TerrainType.WATER) {
            mapArea.setSettlement(Opt.of(SettlementGenerator.INSTANCE.createRandom(mapArea)));
        }

        return mapArea;
    }
}
