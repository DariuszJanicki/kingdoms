package view.generator;

import base.utils.GameArray;
import engine.model.map.GameMap;
import engine.model.map.Field;
import engine.model.terrain.TerrainType;
import engine.points.Coords;
import engine.points.Size;
import utils.Dice;
import utils.Opt;

public enum BoardGenerator {

    INSTANCE;

    /* ========== PUBLIC ========== */
    public GameMap<Field> generateMap(Size size) {
        return new GameMap<>(size, new GameArray<>(size, this::createField));
    }

    /* ========== PRIVATE ========== */
    private Field createField(Coords coords) {
        TerrainType type = new Dice<TerrainType>().randomElementOf(TerrainType.values());

        Field field = new Field(type, new Coords(coords.getX(), coords.getY()));
        if (Dice.k(100) == 0 && field.getTerrain() != TerrainType.WATER) {
            field.setSettlement(Opt.of(SettlementGenerator.INSTANCE.createRandom(field)));
        }

        return field;
    }
}
