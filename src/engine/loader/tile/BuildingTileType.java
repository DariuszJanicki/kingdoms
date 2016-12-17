package engine.loader.tile;

import engine.model.building.BuildingType;
import lombok.Getter;

import java.awt.image.BufferedImage;

@Getter
public class BuildingTileType extends AbstractTileType {

    private BuildingType type;

    public BuildingTileType(BufferedImage image, BuildingType type) {
        super(image);
        this.type = type;
    }
}
