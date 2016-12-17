package engine.loader.loader;

import constants.FrameConstants;
import utils.points.Point;

import java.awt.image.BufferedImage;

public abstract class AbstractTileLoader {

    protected BufferedImage image;

    /* ========== PUBLIC ========== */
    public BufferedImage loadTile(Point point) {
        return image.getSubimage(
                point.getX() * FrameConstants.baseTile,
                point.getY() * FrameConstants.baseTile,
                FrameConstants.baseTile,
                FrameConstants.baseTile);
    }

}
