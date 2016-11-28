package graphics.graphics.details.loader.tile;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.image.BufferedImage;

@Getter
@AllArgsConstructor
public abstract class AbstractTileType {

    private BufferedImage image;

    public abstract Enum getType();
}
