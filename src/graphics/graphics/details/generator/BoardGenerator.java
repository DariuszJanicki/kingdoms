package graphics.graphics.details.generator;

import graphics.graphics.details.loader.tile.list.SettlementTileTypeList;
import graphics.graphics.details.loader.tile.list.TerrainTileTypeList;
import graphics.graphics.details.model.map.GameMap;
import graphics.graphics.details.model.settlement.Settlement;
import graphics.graphics.details.model.settlement.SettlementType;
import graphics.graphics.details.model.terrain.Direction;
import graphics.graphics.details.model.terrain.Terrain;
import graphics.graphics.details.model.tile.field.Field;
import graphics.graphics.details.points.Coords;
import graphics.graphics.details.points.Size;
import utils.Dice;
import utils.Opt;

public enum BoardGenerator {

    INSTANCE;

    /* ========== PUBLIC ========== */
    public GameMap generateMap(Size size) {
        Field[][] rows = createRows(size);
        GameMap map = new GameMap(size, rows);
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

    private void fillTerrain(GameMap map) {
        for (int i = 0; i < map.getSize().getX(); ++i) {
            for (int j = 0; j < map.getSize().getY(); ++j) {
                map.get(new Coords(i, j)).ifPresent(f -> process(map, f));
            }
        }
    }

    private void process(GameMap map, Field field) {
        setTerrainTile(map, field);

        if (Dice.k(20) == 0 && field.getTerrain() != Terrain.WATER) {
            SettlementType type = new Dice<SettlementType>().randomElementOf(SettlementType.values());
            Settlement settlement = new Settlement(type, field, SettlementTileTypeList.singleton().getTile(type));
            field.setSettlement(Opt.of(settlement));
        }
    }

    private void setTerrainTile(GameMap map, Field field) {
        Terrain terrain = field.getTerrain();
        Coords coords = field.getCoords();

        Direction direction = Direction.getDirection(
                equals(terrain, map.get(coords.north())),
                equals(terrain, map.get(coords.south())),
                equals(terrain, map.get(coords.east())),
                equals(terrain, map.get(coords.west())));

        field.setTile(TerrainTileTypeList.singleton().getTile(terrain, direction));
    }

    private boolean equals(Terrain terrain, Opt<Field> field) {
        return field.isPresent().isTrue() && field.get().getTerrain() == terrain;
    }
}
