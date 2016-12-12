package engine.generator;

import engine.loader.tile.list.TerrainTileTypeList;
import engine.model.map.GameMap;
import engine.model.terrain.Direction;
import engine.model.terrain.Terrain;
import engine.model.tile.field.Area;
import engine.points.Coords;
import engine.points.Size;
import utils.Dice;
import utils.Opt;

public enum AreaGenerator {

    INSTANCE;

    /* ========== PUBLIC ========== */
    public GameMap<Area> generateMap(Size size) {
        Area[][] rows = createRows(size);
        GameMap<Area> map = new GameMap<>(size, rows);
        fillTerrain(map);
        return map;
    }

    public Area createField(Coords coords) {
        Terrain type = new Dice<Terrain>().randomElementOf(Terrain.values());
        return new Area(type, coords);
    }

    /* ========== PRIVATE ========== */
    private Area[][] createRows(Size size) {
        Area[][] map = new Area[size.getX()][];
        for (int row = 0; row < size.getX(); ++row) {
            createColumn(size, map, row);
        }
        return map;
    }

    private void createColumn(Size size, Area[][] map, int row) {
        map[row] = new Area[size.getY()];
        for (int column = 0; column < size.getY(); ++column) {
            createField(map, row, column);
        }
    }

    private void createField(Area[][] map, int row, int column) {
        map[row][column] = createField(new Coords(row, column));
    }

    private void fillTerrain(GameMap<Area> map) {
        for (int i = 0; i < map.getSize().getX(); ++i) {
            for (int j = 0; j < map.getSize().getY(); ++j) {
                map.get(new Coords(i, j)).ifPresent(f -> process(map, f));
            }
        }
    }

    private void process(GameMap<Area> map, Area field) {
        setTerrainTile(map, field);
    }

    private void setTerrainTile(GameMap<Area> map, Area field) {
        Terrain terrain = field.getTerrain();
        Coords coords = field.getCoords();

        Direction direction = Direction.getDirection(
                equals(terrain, map.get(coords.north())),
                equals(terrain, map.get(coords.south())),
                equals(terrain, map.get(coords.east())),
                equals(terrain, map.get(coords.west())));

        field.setTile(TerrainTileTypeList.singleton().getTile(terrain, direction));
    }

    private boolean equals(Terrain terrain, Opt<Area> field) {
        return field.isPresent().isTrue() && field.get().getTerrain() == terrain;
    }
}