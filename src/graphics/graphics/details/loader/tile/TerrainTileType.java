package graphics.graphics.details.loader.tile;

import graphics.graphics.details.model.terrain.Direction;
import graphics.graphics.details.model.terrain.Terrain;
import lombok.Getter;

import java.awt.image.BufferedImage;

@Getter
public class TerrainTileType extends AbstractTileType {

    private Terrain type;
    private Direction direction;

    public TerrainTileType(BufferedImage image, Terrain terrain, Direction direction) {
        super(image);
        this.type = terrain;
        this.direction = direction;
    }
}
