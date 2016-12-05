package graphics.graphics.details.model.settlement;

import graphics.graphics.details.generator.PersonGenerator;
import graphics.graphics.details.loader.tile.SettlementTileType;
import graphics.graphics.details.model.person.Person;
import graphics.graphics.details.model.tile.field.Field;
import lombok.AllArgsConstructor;
import lombok.Getter;
import utils.Dice;
import utils.Opt;

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
    private final List<Person> newPeople = new ArrayList<>();

    /* ========== PUBLIC ========== */
    public Settlement(SettlementType type, Field field, SettlementTileType tile) {
        this.type = type;
        this.field = field;
        this.tile = tile;

        for (int i = 0; i < 5; ++i) {
            addVillager(PersonGenerator.INSTANCE.createPerson());
        }
    }

    public void tick() {
        haveChildren();
        marryCitizens();
        peopleInSettlement.forEach(Person::tick);
        peopleInSettlement.addAll(newPeople);
        newPeople.clear();
    }

    public void addVillager(Person person) {
        this.newPeople.add(person);
        person.setSettlement(Opt.of(this));
    }

    public void addVillagers(List<Person> people) {
        this.newPeople.addAll(people);
        people.forEach(person -> person.setSettlement(Opt.of(this)));
    }

    /* ========== PRIVATE ========== */
    private void haveChildren() {
        peopleInSettlement.stream()
                .filter(person -> person.isFemale().isTrue())
                .filter(woman -> woman.hasSpouse().isTrue())
                .filter(woman -> woman.isPregnant().isFalse())
                .filter(woman -> Dice.test(30))
                .forEach(woman -> woman.startPregnancy(woman.getSpouse()));
    }

    private void marryCitizens() {
        List<Person> men = peopleInSettlement.stream()
                .filter(person -> person.isMale().isTrue())
                .filter(man -> man.eligibleToWed().isTrue())
                .filter(man -> man.hasSpouse().isFalse())
                .collect(Collectors.toList());

        List<Person> women = peopleInSettlement.stream()
                .filter(person -> person.isFemale().isTrue())
                .filter(woman -> woman.eligibleToWed().isTrue())
                .filter(woman -> woman.hasSpouse().isFalse())
                .collect(Collectors.toList());

        if (!men.isEmpty() && !women.isEmpty()) {
            men.get(0).marry(women.get(0));
        }
    }

}
