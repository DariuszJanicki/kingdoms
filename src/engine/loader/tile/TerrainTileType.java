package engine.loader.tile;

import engine.loader.Direction;
import engine.model.terrain.TerrainType;
import lombok.Getter;

import java.awt.image.BufferedImage;

@Getter
public class TerrainTileType extends AbstractTileType {

    private TerrainType type;
    private Direction direction;

    public TerrainTileType(BufferedImage image, TerrainType terrain, Direction direction) {
        super(image);
        this.type = terrain;
        this.direction = direction;
    }
}
