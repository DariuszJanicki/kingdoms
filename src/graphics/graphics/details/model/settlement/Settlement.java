package graphics.graphics.details.model.settlement;

import graphics.graphics.details.loader.tile.SettlementTileType;
import graphics.graphics.details.model.tile.field.Field;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Settlement {

    private final Field field;
    private final SettlementType type;
    private final SettlementTileType tile;

    /* ========== CONSTRUCTOR ========== */
    public Settlement(SettlementType type, Field field, SettlementTileType tile) {
        this.type = type;
        this.field = field;
        this.tile = tile;
    }

}
