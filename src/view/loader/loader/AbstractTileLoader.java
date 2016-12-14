package view.loader.loader;

import base.frame.constants.FrameConstants;
import engine.points.Point;

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
