package graphics.graphics.details.loader;

import graphics.graphics.details.loader.resources.FileResource;
import graphics.graphics.Point;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static graphics.graphics.details.model.tile.constants.TileConstants.terrain;

enum TerrainTileLoader {

    LOADER;

    private BufferedImage image;

    /* ========== CONSTRUCTOR ========== */
    TerrainTileLoader() {
        try {
            image = ImageIO.read(FileResource.terrain);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ========== PUBLIC ========== */
    BufferedImage loadTile(Point point) {
        return image.getSubimage(
                point.getX() * terrain,
                point.getY() * terrain,
                terrain,
                terrain);
    }
}
