package pl.jamnic.games.kingdoms.model.loader.loader;

import pl.jamnic.games.kingdoms.constants.FrameConstants;
import pl.jamnic.games.kingdoms.utils.points.Point;

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
