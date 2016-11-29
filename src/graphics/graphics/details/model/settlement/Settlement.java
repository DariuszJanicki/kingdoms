package graphics.graphics.details.model.settlement;

import graphics.graphics.details.generator.PersonGenerator;
import graphics.graphics.details.loader.tile.SettlementTileType;
import graphics.graphics.details.model.person.Person;
import graphics.graphics.details.model.tile.field.Field;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class Settlement {

    private final Field field;
    private final SettlementType type;
    private final SettlementTileType tile;

    private final List<Person> peopleInSettlement = new ArrayList<>();

    /* ========== CONSTRUCTOR ========== */
    public Settlement(SettlementType type, Field field, SettlementTileType tile) {
        this.type = type;
        this.field = field;
        this.tile = tile;

        for (int i = 0; i < 5; ++i) {
            peopleInSettlement.add(PersonGenerator.INSTANCE.createPerson());
        }
    }

    /* ========== PUBLIC ========== */
    public void tick() {
        haveChildren();
        marryCitizens();
    }

    private void haveChildren() {
        List<Person> women = peopleInSettlement.stream()
                .filter(s -> s.isMale().isFalse())
                .filter(s -> s.hasSpouse().isTrue())
                .filter(s -> !s.isPregnant().isTrue())
                .collect(Collectors.toList());
    }

    private void marryCitizens() {
        List<Person> men = peopleInSettlement.stream()
                .filter(s -> s.isMale().isTrue())
                .filter(s -> s.hasSpouse().isFalse())
                .collect(Collectors.toList());

        List<Person> women = peopleInSettlement.stream()
                .filter(s -> s.isMale().isFalse())
                .filter(s -> s.hasSpouse().isFalse())
                .collect(Collectors.toList());

        if (!men.isEmpty() && !women.isEmpty()) {
            men.get(0).marry(women.get(0));
        }
    }

}
