package pl.jamnic.games.kingdoms.model.loader.loader;

import pl.jamnic.games.kingdoms.model.loader.resources.FileResource;

import javax.imageio.ImageIO;
import java.io.IOException;

public final class TerrainTileLoader extends AbstractTileLoader {

    private static TerrainTileLoader singleton;

    /* ========== STATIC ========== */
    public static TerrainTileLoader singleton() {
        return singleton == null ? singleton = new TerrainTileLoader() : singleton;
    }

    /* ========== CONSTRUCTOR ========== */
    private TerrainTileLoader() {
        try {
            image = ImageIO.read(FileResource.terrain);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
