package engine.loader.tile;

import engine.model.settlement.SettlementType;
import lombok.Getter;

import java.awt.image.BufferedImage;

@Getter
public class SettlementTileType extends AbstractTileType {

    private SettlementType type;

    public SettlementTileType(BufferedImage image, SettlementType type) {
        super(image);
        this.type = type;
    }
}
