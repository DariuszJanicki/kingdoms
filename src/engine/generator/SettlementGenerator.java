package engine.generator;

import engine.loader.tile.list.SettlementTileTypeList;
import engine.model.settlement.Settlement;
import engine.model.settlement.SettlementType;
import engine.model.tile.field.Field;
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
