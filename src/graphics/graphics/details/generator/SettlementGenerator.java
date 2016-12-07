package graphics.graphics.details.generator;

import graphics.graphics.details.loader.tile.list.SettlementTileTypeList;
import graphics.graphics.details.model.settlement.Settlement;
import graphics.graphics.details.model.settlement.SettlementType;
import graphics.graphics.details.model.tile.field.Field;
import utils.Dice;

enum SettlementGenerator {

    INSTANCE;

    /* ========== PUBLIC ========== */
    public Settlement createRandom(Field field) {
        SettlementType type = new Dice<SettlementType>().randomElementOf(SettlementType.values());
        return new Settlement(type, NameGenerator.INSTANCE.generateSettlementName(), field,
                SettlementTileTypeList.singleton().getTile(type));
    }
}
