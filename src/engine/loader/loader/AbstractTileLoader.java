package engine.loader.loader;

import engine.points.Point;
import engine.model.tile.constants.TileConstants;

import java.awt.image.BufferedImage;

public abstract class AbstractTileLoader {

    protected BufferedImage image;

    /* ========== PUBLIC ========== */
    public BufferedImage loadTile(Point point) {
        return image.getSubimage(
                point.getX() * TileConstants.terrain,
                point.getY() * TileConstants.terrain,
                TileConstants.terrain,
                TileConstants.terrain);
    }

}
