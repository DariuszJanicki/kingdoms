package graphics.graphics.details.loader;

import graphics.graphics.Point;
import graphics.graphics.details.model.terrain.Terrain;
import graphics.graphics.details.model.terrain.Direction;
import utils.Dice;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static graphics.graphics.details.model.terrain.Direction.*;

public enum TerrainTileTypeList {

    INSTANCE;

    private List<TerrainTileType> list = new ArrayList<>();

    /* ========== CONSTRUCTOR ========== */
    TerrainTileTypeList() {
        loadTerrainTypes();
    }

    /* ========== PUBLIC ========== */
    public TerrainTileType getTile(Terrain terrain, Direction direction) {
        List<TerrainTileType> collect = list.stream()
                .filter(t -> t.getType() == terrain && t.getDirection() == direction)
                .collect(Collectors.toList());

        if (collect.isEmpty()) {
            return list.get(0);
        }

        return new Dice<TerrainTileType>().randomElementOf(collect);
    }

    /* ========== PRIVATE ========== */
    private void loadTerrainTypes() {
        test(Terrain.GRASS, TerrainTileLoader.LOADER.loadTile(new Point(0, 0)), NONE);
        test(Terrain.GRASS, TerrainTileLoader.LOADER.loadTile(new Point(1, 0)), NONE);

        createWater();

        loadForest();
        loadDesert();
        loadMountain();
        loadRiver();
    }

    private void loadRiver() {
        Terrain terrain = Terrain.RIVER;
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(10, 6)), NONE);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(11, 6)), NONE);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(12, 6)), NORTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(13, 6)), NORTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(14, 6)), EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(15, 6)), EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(16, 6)), NORTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(17, 6)), NORTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(18, 6)), SOUTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(19, 6)), SOUTH);

        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(0, 7)), NORTH_SOUTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(1, 7)), NORTH_SOUTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(2, 7)), SOUTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(3, 7)), SOUTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(4, 7)), NORTH_SOUTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(5, 7)), NORTH_SOUTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(6, 7)), WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(7, 7)), WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(8, 7)), NORTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(9, 7)), NORTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(10, 7)), EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(11, 7)), EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(12, 7)), NORTH_EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(13, 7)), NORTH_EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(14, 7)), SOUTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(15, 7)), SOUTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(16, 7)), NORTH_SOUTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(17, 7)), NORTH_SOUTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(18, 7)), SOUTH_EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(19, 7)), SOUTH_EAST_WEST);

        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(0, 8)), NORTH_SOUTH_EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(1, 8)), NORTH_SOUTH_EAST_WEST);
    }

    private void test(Terrain terrain, BufferedImage image, Direction none) {
        list.add(new TerrainTileType(terrain, image, none));
    }

    private void loadMountain() {
        Terrain terrain = Terrain.MOUNTAIN;
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(18, 4)), NONE);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(19, 4)), NONE);

        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(0, 5)), NORTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(1, 5)), NORTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(2, 5)), EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(3, 5)), EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(4, 5)), NORTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(5, 5)), NORTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(6, 5)), SOUTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(7, 5)), SOUTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(8, 5)), NORTH_SOUTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(9, 5)), NORTH_SOUTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(10, 5)), SOUTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(11, 5)), SOUTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(12, 5)), NORTH_SOUTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(13, 5)), NORTH_SOUTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(14, 5)), WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(15, 5)), WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(16, 5)), NORTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(17, 5)), NORTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(18, 5)), EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(19, 5)), EAST_WEST);

        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(0, 6)), NORTH_EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(1, 6)), NORTH_EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(2, 6)), SOUTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(3, 6)), SOUTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(4, 6)), NORTH_SOUTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(5, 6)), NORTH_SOUTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(6, 6)), SOUTH_EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(7, 6)), SOUTH_EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(8, 6)), NORTH_SOUTH_EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(9, 6)), NORTH_SOUTH_EAST_WEST);
    }

    private void loadDesert() {
        Terrain terrain = Terrain.DESERT;
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(6, 3)), NONE);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(7, 3)), NONE);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(8, 3)), NORTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(9, 3)), NORTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(10, 3)), EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(11, 3)), EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(12, 3)), NORTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(13, 3)), NORTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(14, 3)), SOUTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(15, 3)), SOUTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(16, 3)), NORTH_SOUTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(17, 3)), NORTH_SOUTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(18, 3)), SOUTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(19, 3)), SOUTH_EAST);

        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(0, 4)), NORTH_SOUTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(1, 4)), NORTH_SOUTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(2, 4)), WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(3, 4)), WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(4, 4)), NORTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(5, 4)), NORTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(6, 4)), EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(7, 4)), EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(8, 4)), NORTH_EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(9, 4)), NORTH_EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(10, 4)), SOUTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(11, 4)), SOUTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(12, 4)), NORTH_SOUTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(13, 4)), NORTH_SOUTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(14, 4)), SOUTH_EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(15, 4)), SOUTH_EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(16, 4)), NORTH_SOUTH_EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(17, 4)), NORTH_SOUTH_EAST_WEST);
    }

    private void loadForest() {
        Terrain terrain = Terrain.FOREST;
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(14, 1)), NONE);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(15, 1)), NONE);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(16, 1)), NORTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(17, 1)), NORTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(18, 1)), EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(19, 1)), EAST);

        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(0, 2)), NORTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(1, 2)), NORTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(2, 2)), SOUTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(3, 2)), SOUTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(4, 2)), NORTH_SOUTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(5, 2)), NORTH_SOUTH);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(6, 2)), SOUTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(7, 2)), SOUTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(8, 2)), NORTH_SOUTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(9, 2)), NORTH_SOUTH_EAST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(10, 2)), WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(11, 2)), WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(12, 2)), NORTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(13, 2)), NORTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(14, 2)), EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(15, 2)), EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(16, 2)), NORTH_EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(17, 2)), NORTH_EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(18, 2)), SOUTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(19, 2)), SOUTH_WEST);

        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(0, 3)), NORTH_SOUTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(1, 3)), NORTH_SOUTH_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(2, 3)), SOUTH_EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(3, 3)), SOUTH_EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(4, 3)), NORTH_SOUTH_EAST_WEST);
        test(terrain, TerrainTileLoader.LOADER.loadTile(new Point(5, 3)), NORTH_SOUTH_EAST_WEST);
    }

    private void createWater() {
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(2, 0)), NORTH_SOUTH_EAST_WEST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(3, 0)), NORTH_SOUTH_EAST_WEST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(4, 0)), SOUTH_EAST_WEST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(5, 0)), SOUTH_EAST_WEST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(6, 0)), NORTH_SOUTH_WEST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(7, 0)), NORTH_SOUTH_WEST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(8, 0)), SOUTH_WEST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(9, 0)), SOUTH_WEST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(10, 0)), NORTH_EAST_WEST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(11, 0)), NORTH_EAST_WEST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(12, 0)), EAST_WEST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(13, 0)), EAST_WEST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(14, 0)), NORTH_WEST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(15, 0)), NORTH_WEST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(16, 0)), WEST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(17, 0)), WEST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(18, 0)), NORTH_SOUTH_EAST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(19, 0)), NORTH_SOUTH_EAST);

        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(0, 1)), SOUTH_EAST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(1, 1)), SOUTH_EAST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(2, 1)), NORTH_SOUTH);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(3, 1)), NORTH_SOUTH);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(4, 1)), SOUTH);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(5, 1)), SOUTH);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(6, 1)), NORTH_EAST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(7, 1)), NORTH_EAST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(8, 1)), EAST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(9, 1)), EAST);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(10, 1)), NORTH);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(11, 1)), NORTH);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(12, 1)), NONE);
        test(Terrain.WATER, TerrainTileLoader.LOADER.loadTile(new Point(13, 1)), NONE);
    }
}
