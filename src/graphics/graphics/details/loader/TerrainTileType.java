package graphics.graphics.details.loader;

import graphics.graphics.details.model.terrain.Terrain;
import graphics.graphics.details.model.terrain.Direction;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.image.BufferedImage;

@Getter
@AllArgsConstructor
public class TerrainTileType {

    private Terrain type;
    private BufferedImage image;
    private Direction direction;

}
