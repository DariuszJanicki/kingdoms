package graphics.graphics.details.generator;

import graphics.graphics.details.Coords;
import graphics.graphics.details.Size;
import graphics.graphics.details.loader.TerrainTileTypeList;
import graphics.graphics.details.model.map.GameMap;
import graphics.graphics.details.model.terrain.Direction;
import graphics.graphics.details.model.terrain.Terrain;
import graphics.graphics.details.model.tile.field.Field;
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
                map.get(new Coords(i, j)).ifPresent(f -> setTerrainTile(map, f));
            }
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

        field.setTerrainTile(TerrainTileTypeList.INSTANCE.getTile(terrain, direction));
    }

    private boolean equals(Terrain terrain, Opt<Field> field) {
        return field.isPresent().isTrue() && field.get().getTerrain() == terrain;
    }
}
