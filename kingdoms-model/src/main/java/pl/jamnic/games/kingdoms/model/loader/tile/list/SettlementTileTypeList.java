package pl.jamnic.games.kingdoms.model.loader.tile.list;

import pl.jamnic.games.kingdoms.model.loader.loader.SettlementTileLoader;
import pl.jamnic.games.kingdoms.model.loader.tile.SettlementTileType;
import pl.jamnic.games.kingdoms.model.model.settlement.SettlementType;
import pl.jamnic.games.kingdoms.utils.points.Point;

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
