package engine.loader.tile.list;

import engine.loader.loader.SettlementTileLoader;
import engine.loader.tile.BuildingTileType;
import engine.model.building.BuildingType;
import utils.points.Point;

import java.awt.image.BufferedImage;

public final class BuildingTileTypeList extends AbstractTileTypeList<BuildingTileType> {

    private static BuildingTileTypeList singleton;

    /* ========== SINGLETON ========== */
    public static BuildingTileTypeList singleton() {
        return singleton == null ? singleton = new BuildingTileTypeList() : singleton;
    }

    /* ========== CONSTRUCTOR ========== */
    private BuildingTileTypeList() {
        loadTerrainTypes();
    }

    /* ========== PUBLIC ========== */


    /* ========== PRIVATE ========== */
    private void load(BuildingType type, BufferedImage image) {
        list.add(new BuildingTileType(image, type));
    }

    private void loadTerrainTypes() {
        load(BuildingType.SHOP, SettlementTileLoader.singleton().loadTile(Point.of(0, 7)));
        load(BuildingType.HOUSE, SettlementTileLoader.singleton().loadTile(Point.of(1, 7)));
        load(BuildingType.BIG_HOUSE, SettlementTileLoader.singleton().loadTile(Point.of(2, 7)));
    }
}
