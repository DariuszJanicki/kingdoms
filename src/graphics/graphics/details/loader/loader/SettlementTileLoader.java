package graphics.graphics.details.loader.loader;

import graphics.graphics.details.loader.resources.FileResource;

import javax.imageio.ImageIO;
import java.io.IOException;

public final class SettlementTileLoader extends AbstractTileLoader{

    private static SettlementTileLoader singleton;

    /* ========== STATIC ========== */
    public static SettlementTileLoader singleton() {
        return singleton == null ? singleton = new SettlementTileLoader() : singleton;
    }

    /* ========== CONSTRUCTOR ========== */
    private SettlementTileLoader() {
        try {
            image = ImageIO.read(FileResource.settlement);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
