package engine.loader.tile.list;

import engine.loader.Direction;
import engine.model.terrain.TerrainType;
import utils.points.Point;
import engine.loader.loader.TerrainTileLoader;
import engine.loader.tile.TerrainTileType;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.stream.Collectors;

import static engine.loader.Direction.*;

public final class TerrainTileTypeList extends AbstractTileTypeList<TerrainTileType> {

    private static TerrainTileTypeList singleton;

    /* ========== SINGLETON ========== */
    public static TerrainTileTypeList singleton() {
        return singleton == null ? singleton = new TerrainTileTypeList() : singleton;
    }

    /* ========== CONSTRUCTOR ========== */
    private TerrainTileTypeList() {
        loadTerrainTypes();
    }

    /* ========== PUBLIC ========== */
    public TerrainTileType getTile(TerrainType terrain, Direction direction) {
        List<TerrainTileType> collect = list.stream()
                .filter(t -> t.getType() == terrain && t.getDirection() == direction)
                .collect(Collectors.toList());

        if (collect.isEmpty()) {
            return list.get(0);
        }

        return collect.get(0);
    }

    /* ========== PRIVATE ========== */
    private void load(TerrainType terrain, BufferedImage image, Direction direction) {
        list.add(new TerrainTileType(image, terrain, direction));
    }

    private void loadTerrainTypes() {
        load(TerrainType.GRASS, TerrainTileLoader.singleton().loadTile(Point.of(0, 0)), NONE);
        load(TerrainType.GRASS, TerrainTileLoader.singleton().loadTile(Point.of(1, 0)), NONE);

        createWater();

        loadForest();
        loadDesert();
        loadMountain();
        loadRiver();
    }

    private void loadRiver() {
        TerrainTileLoader loader = TerrainTileLoader.singleton();
        TerrainType terrain = TerrainType.RIVER;

        load(terrain, loader.loadTile(Point.of(10, 6)), NONE);
        load(terrain, loader.loadTile(Point.of(11, 6)), NONE);
        load(terrain, loader.loadTile(Point.of(12, 6)), NORTH);
        load(terrain, loader.loadTile(Point.of(13, 6)), NORTH);
        load(terrain, loader.loadTile(Point.of(14, 6)), EAST);
        load(terrain, loader.loadTile(Point.of(15, 6)), EAST);
        load(terrain, loader.loadTile(Point.of(16, 6)), NORTH_EAST);
        load(terrain, loader.loadTile(Point.of(17, 6)), NORTH_EAST);
        load(terrain, loader.loadTile(Point.of(18, 6)), SOUTH);
        load(terrain, loader.loadTile(Point.of(19, 6)), SOUTH);

        load(terrain, loader.loadTile(Point.of(0, 7)), NORTH_SOUTH);
        load(terrain, loader.loadTile(Point.of(1, 7)), NORTH_SOUTH);
        load(terrain, loader.loadTile(Point.of(2, 7)), SOUTH_EAST);
        load(terrain, loader.loadTile(Point.of(3, 7)), SOUTH_EAST);
        load(terrain, loader.loadTile(Point.of(4, 7)), NORTH_SOUTH_EAST);
        load(terrain, loader.loadTile(Point.of(5, 7)), NORTH_SOUTH_EAST);
        load(terrain, loader.loadTile(Point.of(6, 7)), WEST);
        load(terrain, loader.loadTile(Point.of(7, 7)), WEST);
        load(terrain, loader.loadTile(Point.of(8, 7)), NORTH_WEST);
        load(terrain, loader.loadTile(Point.of(9, 7)), NORTH_WEST);
        load(terrain, loader.loadTile(Point.of(10, 7)), EAST_WEST);
        load(terrain, loader.loadTile(Point.of(11, 7)), EAST_WEST);
        load(terrain, loader.loadTile(Point.of(12, 7)), NORTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(13, 7)), NORTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(14, 7)), SOUTH_WEST);
        load(terrain, loader.loadTile(Point.of(15, 7)), SOUTH_WEST);
        load(terrain, loader.loadTile(Point.of(16, 7)), NORTH_SOUTH_WEST);
        load(terrain, loader.loadTile(Point.of(17, 7)), NORTH_SOUTH_WEST);
        load(terrain, loader.loadTile(Point.of(18, 7)), SOUTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(19, 7)), SOUTH_EAST_WEST);

        load(terrain, loader.loadTile(Point.of(0, 8)), NORTH_SOUTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(1, 8)), NORTH_SOUTH_EAST_WEST);
    }

    private void loadMountain() {
        TerrainTileLoader loader = TerrainTileLoader.singleton();
        TerrainType terrain = TerrainType.MOUNTAIN;

        load(terrain, loader.loadTile(Point.of(18, 4)), NONE);
        load(terrain, loader.loadTile(Point.of(19, 4)), NONE);

        load(terrain, loader.loadTile(Point.of(0, 5)), NORTH);
        load(terrain, loader.loadTile(Point.of(1, 5)), NORTH);
        load(terrain, loader.loadTile(Point.of(2, 5)), EAST);
        load(terrain, loader.loadTile(Point.of(3, 5)), EAST);
        load(terrain, loader.loadTile(Point.of(4, 5)), NORTH_EAST);
        load(terrain, loader.loadTile(Point.of(5, 5)), NORTH_EAST);
        load(terrain, loader.loadTile(Point.of(6, 5)), SOUTH);
        load(terrain, loader.loadTile(Point.of(7, 5)), SOUTH);
        load(terrain, loader.loadTile(Point.of(8, 5)), NORTH_SOUTH);
        load(terrain, loader.loadTile(Point.of(9, 5)), NORTH_SOUTH);
        load(terrain, loader.loadTile(Point.of(10, 5)), SOUTH_EAST);
        load(terrain, loader.loadTile(Point.of(11, 5)), SOUTH_EAST);
        load(terrain, loader.loadTile(Point.of(12, 5)), NORTH_SOUTH_EAST);
        load(terrain, loader.loadTile(Point.of(13, 5)), NORTH_SOUTH_EAST);
        load(terrain, loader.loadTile(Point.of(14, 5)), WEST);
        load(terrain, loader.loadTile(Point.of(15, 5)), WEST);
        load(terrain, loader.loadTile(Point.of(16, 5)), NORTH_WEST);
        load(terrain, loader.loadTile(Point.of(17, 5)), NORTH_WEST);
        load(terrain, loader.loadTile(Point.of(18, 5)), EAST_WEST);
        load(terrain, loader.loadTile(Point.of(19, 5)), EAST_WEST);

        load(terrain, loader.loadTile(Point.of(0, 6)), NORTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(1, 6)), NORTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(2, 6)), SOUTH_WEST);
        load(terrain, loader.loadTile(Point.of(3, 6)), SOUTH_WEST);
        load(terrain, loader.loadTile(Point.of(4, 6)), NORTH_SOUTH_WEST);
        load(terrain, loader.loadTile(Point.of(5, 6)), NORTH_SOUTH_WEST);
        load(terrain, loader.loadTile(Point.of(6, 6)), SOUTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(7, 6)), SOUTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(8, 6)), NORTH_SOUTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(9, 6)), NORTH_SOUTH_EAST_WEST);
    }

    private void loadDesert() {
        TerrainType terrain = TerrainType.DESERT;
        TerrainTileLoader loader = TerrainTileLoader.singleton();

        load(terrain, loader.loadTile(Point.of(6, 3)), NONE);
        load(terrain, loader.loadTile(Point.of(7, 3)), NONE);
        load(terrain, loader.loadTile(Point.of(8, 3)), NORTH);
        load(terrain, loader.loadTile(Point.of(9, 3)), NORTH);
        load(terrain, loader.loadTile(Point.of(10, 3)), EAST);
        load(terrain, loader.loadTile(Point.of(11, 3)), EAST);
        load(terrain, loader.loadTile(Point.of(12, 3)), NORTH_EAST);
        load(terrain, loader.loadTile(Point.of(13, 3)), NORTH_EAST);
        load(terrain, loader.loadTile(Point.of(14, 3)), SOUTH);
        load(terrain, loader.loadTile(Point.of(15, 3)), SOUTH);
        load(terrain, loader.loadTile(Point.of(16, 3)), NORTH_SOUTH);
        load(terrain, loader.loadTile(Point.of(17, 3)), NORTH_SOUTH);
        load(terrain, loader.loadTile(Point.of(18, 3)), SOUTH_EAST);
        load(terrain, loader.loadTile(Point.of(19, 3)), SOUTH_EAST);

        load(terrain, loader.loadTile(Point.of(0, 4)), NORTH_SOUTH_EAST);
        load(terrain, loader.loadTile(Point.of(1, 4)), NORTH_SOUTH_EAST);
        load(terrain, loader.loadTile(Point.of(2, 4)), WEST);
        load(terrain, loader.loadTile(Point.of(3, 4)), WEST);
        load(terrain, loader.loadTile(Point.of(4, 4)), NORTH_WEST);
        load(terrain, loader.loadTile(Point.of(5, 4)), NORTH_WEST);
        load(terrain, loader.loadTile(Point.of(6, 4)), EAST_WEST);
        load(terrain, loader.loadTile(Point.of(7, 4)), EAST_WEST);
        load(terrain, loader.loadTile(Point.of(8, 4)), NORTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(9, 4)), NORTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(10, 4)), SOUTH_WEST);
        load(terrain, loader.loadTile(Point.of(11, 4)), SOUTH_WEST);
        load(terrain, loader.loadTile(Point.of(12, 4)), NORTH_SOUTH_WEST);
        load(terrain, loader.loadTile(Point.of(13, 4)), NORTH_SOUTH_WEST);
        load(terrain, loader.loadTile(Point.of(14, 4)), SOUTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(15, 4)), SOUTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(16, 4)), NORTH_SOUTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(17, 4)), NORTH_SOUTH_EAST_WEST);
    }

    private void loadForest() {
        TerrainTileLoader loader = TerrainTileLoader.singleton();
        TerrainType terrain = TerrainType.FOREST;

        load(terrain, loader.loadTile(Point.of(14, 1)), NONE);
        load(terrain, loader.loadTile(Point.of(15, 1)), NONE);
        load(terrain, loader.loadTile(Point.of(16, 1)), NORTH);
        load(terrain, loader.loadTile(Point.of(17, 1)), NORTH);
        load(terrain, loader.loadTile(Point.of(18, 1)), EAST);
        load(terrain, loader.loadTile(Point.of(19, 1)), EAST);

        load(terrain, loader.loadTile(Point.of(0, 2)), NORTH_EAST);
        load(terrain, loader.loadTile(Point.of(1, 2)), NORTH_EAST);
        load(terrain, loader.loadTile(Point.of(2, 2)), SOUTH);
        load(terrain, loader.loadTile(Point.of(3, 2)), SOUTH);
        load(terrain, loader.loadTile(Point.of(4, 2)), NORTH_SOUTH);
        load(terrain, loader.loadTile(Point.of(5, 2)), NORTH_SOUTH);
        load(terrain, loader.loadTile(Point.of(6, 2)), SOUTH_EAST);
        load(terrain, loader.loadTile(Point.of(7, 2)), SOUTH_EAST);
        load(terrain, loader.loadTile(Point.of(8, 2)), NORTH_SOUTH_EAST);
        load(terrain, loader.loadTile(Point.of(9, 2)), NORTH_SOUTH_EAST);
        load(terrain, loader.loadTile(Point.of(10, 2)), WEST);
        load(terrain, loader.loadTile(Point.of(11, 2)), WEST);
        load(terrain, loader.loadTile(Point.of(12, 2)), NORTH_WEST);
        load(terrain, loader.loadTile(Point.of(13, 2)), NORTH_WEST);
        load(terrain, loader.loadTile(Point.of(14, 2)), EAST_WEST);
        load(terrain, loader.loadTile(Point.of(15, 2)), EAST_WEST);
        load(terrain, loader.loadTile(Point.of(16, 2)), NORTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(17, 2)), NORTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(18, 2)), SOUTH_WEST);
        load(terrain, loader.loadTile(Point.of(19, 2)), SOUTH_WEST);

        load(terrain, loader.loadTile(Point.of(0, 3)), NORTH_SOUTH_WEST);
        load(terrain, loader.loadTile(Point.of(1, 3)), NORTH_SOUTH_WEST);
        load(terrain, loader.loadTile(Point.of(2, 3)), SOUTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(3, 3)), SOUTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(4, 3)), NORTH_SOUTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(5, 3)), NORTH_SOUTH_EAST_WEST);
    }

    private void createWater() {
        TerrainTileLoader loader = TerrainTileLoader.singleton();
        TerrainType terrain = TerrainType.WATER;

        load(terrain, loader.loadTile(Point.of(2, 0)), NORTH_SOUTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(3, 0)), NORTH_SOUTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(4, 0)), SOUTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(5, 0)), SOUTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(6, 0)), NORTH_SOUTH_WEST);
        load(terrain, loader.loadTile(Point.of(7, 0)), NORTH_SOUTH_WEST);
        load(terrain, loader.loadTile(Point.of(8, 0)), SOUTH_WEST);
        load(terrain, loader.loadTile(Point.of(9, 0)), SOUTH_WEST);
        load(terrain, loader.loadTile(Point.of(10, 0)), NORTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(11, 0)), NORTH_EAST_WEST);
        load(terrain, loader.loadTile(Point.of(12, 0)), EAST_WEST);
        load(terrain, loader.loadTile(Point.of(13, 0)), EAST_WEST);
        load(terrain, loader.loadTile(Point.of(14, 0)), NORTH_WEST);
        load(terrain, loader.loadTile(Point.of(15, 0)), NORTH_WEST);
        load(terrain, loader.loadTile(Point.of(16, 0)), WEST);
        load(terrain, loader.loadTile(Point.of(17, 0)), WEST);
        load(terrain, loader.loadTile(Point.of(18, 0)), NORTH_SOUTH_EAST);
        load(terrain, loader.loadTile(Point.of(19, 0)), NORTH_SOUTH_EAST);

        load(terrain, loader.loadTile(Point.of(0, 1)), SOUTH_EAST);
        load(terrain, loader.loadTile(Point.of(1, 1)), SOUTH_EAST);
        load(terrain, loader.loadTile(Point.of(2, 1)), NORTH_SOUTH);
        load(terrain, loader.loadTile(Point.of(3, 1)), NORTH_SOUTH);
        load(terrain, loader.loadTile(Point.of(4, 1)), SOUTH);
        load(terrain, loader.loadTile(Point.of(5, 1)), SOUTH);
        load(terrain, loader.loadTile(Point.of(6, 1)), NORTH_EAST);
        load(terrain, loader.loadTile(Point.of(7, 1)), NORTH_EAST);
        load(terrain, loader.loadTile(Point.of(8, 1)), EAST);
        load(terrain, loader.loadTile(Point.of(9, 1)), EAST);
        load(terrain, loader.loadTile(Point.of(10, 1)), NORTH);
        load(terrain, loader.loadTile(Point.of(11, 1)), NORTH);
        load(terrain, loader.loadTile(Point.of(12, 1)), NONE);
        load(terrain, loader.loadTile(Point.of(13, 1)), NONE);
    }
}
