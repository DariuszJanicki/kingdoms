package pl.jamnic.games.kingdoms.model.generator;

import pl.jamnic.games.kingdoms.model.model.map.Field;
import pl.jamnic.games.kingdoms.model.model.settlement.Settlement;
import pl.jamnic.games.kingdoms.model.model.settlement.SettlementType;
import utils.Dice;

enum SettlementGenerator {

    INSTANCE;

    /* ========== PUBLIC ========== */
    public Settlement createRandom(Field field) {
        SettlementType type = new Dice<SettlementType>().randomElementOf(SettlementType.values());
        return new Settlement(type, NameGenerator.INSTANCE.generateSettlementName(), field);
    }
}
