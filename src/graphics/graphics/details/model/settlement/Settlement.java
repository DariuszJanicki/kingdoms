package graphics.graphics.details.model.settlement;

import graphics.graphics.details.generator.PersonGenerator;
import graphics.graphics.details.loader.tile.SettlementTileType;
import graphics.graphics.details.model.person.People;
import graphics.graphics.details.model.person.Person;
import graphics.graphics.details.model.tile.field.Field;
import lombok.Getter;
import utils.Opt;

import java.util.List;

public class Settlement {

    @Getter
    private final Field field;
    @Getter
    private final SettlementType type;
    @Getter
    private final SettlementTileType tile;

    private final People people = new People();
    private final People newPeople = new People();

    /* ========== PUBLIC ========== */
    public Settlement(SettlementType type, Field field, SettlementTileType tile) {
        this.type = type;
        this.field = field;
        this.tile = tile;

        for (int i = 0; i < 5; ++i) {
            addVillager(PersonGenerator.INSTANCE.createRandomPerson());
        }
    }

    public void addVillager(Person person) {
        newPeople.add(person);
        person.setSettlement(Opt.of(this));
    }

    public void addVillagers(List<Person> people) {
        newPeople.add(people);
        people.forEach(person -> person.setSettlement(Opt.of(this)));
    }

    public void tick() {
        people.tick();
        people.marryCitizens();
        people.haveChildren();
        people.introduceNewPeople(newPeople);
    }

    public List<String> getVillagersList() {
        return people.getVillagersList();
    }
}
