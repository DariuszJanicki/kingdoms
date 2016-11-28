package graphics.graphics.details.loader.loader;

import graphics.graphics.details.points.Point;

import java.awt.image.BufferedImage;

import static graphics.graphics.details.model.tile.constants.TileConstants.terrain;

public abstract class AbstractTileLoader {

    protected BufferedImage image;

    /* ========== PUBLIC ========== */
    public BufferedImage loadTile(Point point) {
        return image.getSubimage(
                point.getX() * terrain,
                point.getY() * terrain,
                terrain,
                terrain);
    }

}
