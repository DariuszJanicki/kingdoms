package graphics.graphics.details.loader.tile.list;

import graphics.graphics.details.loader.loader.SettlementTileLoader;
import graphics.graphics.details.loader.tile.SettlementTileType;
import graphics.graphics.details.model.settlement.SettlementType;
import graphics.graphics.details.points.Point;

import java.awt.image.BufferedImage;

public final class SettlementTileTypeList extends AbstractTileTypeList<SettlementTileType> {

    private static SettlementTileTypeList singleton;

    /* ========== SINGLETON ========== */
    public static SettlementTileTypeList singleton() {
        return singleton == null ? singleton = new SettlementTileTypeList() : singleton;
    }

    /* ========== CONSTRUCTOR ========== */
    private SettlementTileTypeList() {
        loadTerrainTypes();
    }

    /* ========== PUBLIC ========== */


    /* ========== PRIVATE ========== */
    private void load(SettlementType type, BufferedImage image) {
        list.add(new SettlementTileType(image, type));
    }

    private void loadTerrainTypes() {
        load(SettlementType.VILLAGE, SettlementTileLoader.singleton().loadTile(Point.of(0, 8)));
        load(SettlementType.CASTLE, SettlementTileLoader.singleton().loadTile(Point.of(6, 7)));
        load(SettlementType.MILL, SettlementTileLoader.singleton().loadTile(Point.of(0, 9)));
    }
}
