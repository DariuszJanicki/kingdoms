package view.generator;

import engine.model.field.Field;
import engine.model.map.GameMap;
import engine.model.terrain.Terrain;
import engine.points.Coords;
import engine.points.Size;
import utils.Dice;
import utils.Opt;

public enum BoardGenerator {

    INSTANCE;

    /* ========== PUBLIC ========== */
    public GameMap<Field> generateMap(Size size) {
        Field[][] rows = createRows(size);
        GameMap<Field> map = new GameMap<>(size, rows);
        fillTerrain(map);
        return map;
    }

    /* ========== PRIVATE ========== */
    private Field[][] createRows(Size size) {
        Field[][] map = new Field[size.getX()][];
        for (int row = 0; row < size.getX(); ++row) {
            createColumn(size, map, row);
        }
        return map;
    }

    private void createColumn(Size size, Field[][] map, int row) {
        map[row] = new Field[size.getY()];
        for (int column = 0; column < size.getY(); ++column) {
            createField(map, row, column);
        }
    }

    private void createField(Field[][] map, int row, int column) {
        Terrain type = new Dice<Terrain>().randomElementOf(Terrain.values());
        map[row][column] = new Field(type, new Coords(row, column));
    }

    private void fillTerrain(GameMap<Field> map) {
        for (int i = 0; i < map.getSize().getX(); ++i) {
            for (int j = 0; j < map.getSize().getY(); ++j) {
                map.get(new Coords(i, j)).ifPresent(f -> process(map, f));
            }
        }
    }

    private void process(GameMap<Field> map, Field field) {
        if (Dice.k(100) == 0 && field.getTerrain() != Terrain.WATER) {
            field.setSettlement(Opt.of(SettlementGenerator.INSTANCE.createRandom(field)));
        }
    }
}