package pl.jamnic.games.kingdoms.model.loader.tile;

import pl.jamnic.games.kingdoms.model.model.settlement.SettlementType;
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
