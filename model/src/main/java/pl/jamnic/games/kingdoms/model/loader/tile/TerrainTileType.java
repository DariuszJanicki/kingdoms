package pl.jamnic.games.kingdoms.model.loader.tile;

import pl.jamnic.games.kingdoms.model.loader.Direction;
import pl.jamnic.games.kingdoms.model.model.terrain.TerrainType;
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
