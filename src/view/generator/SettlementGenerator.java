package view.generator;

import engine.model.map.MapArea;
import engine.model.settlement.Settlement;
import engine.model.settlement.SettlementType;
import utils.Dice;

enum SettlementGenerator {

    INSTANCE;

    /* ========== PUBLIC ========== */
    public Settlement createRandom(MapArea mapArea) {
        SettlementType type = new Dice<SettlementType>().randomElementOf(SettlementType.values());
        return new Settlement(type, NameGenerator.INSTANCE.generateSettlementName(), mapArea);
    }
}
