package graphics.graphics.details.model.building;

import graphics.graphics.details.model.person.People;
import graphics.graphics.details.model.person.Person;
import graphics.graphics.details.model.settlement.Settlement;
import lombok.Getter;
import lombok.Setter;
import utils.Bool;
import utils.Opt;

public class Building {

    @Setter
    @Getter
    private Opt<Person> owner = Opt.empty();
    private final People inhabitants = new People(10);
    private final BuildingType type;

    @Setter
    private Opt<Settlement> settlement = Opt.empty();

    /* ========== PUBLIC ========== */
    public Building(BuildingType type) {
        this.type = type;
    }

    public Bool canBeBuiltInSettlement() {
        return Bool.TRUE;
    }

    public void moveOut(Person person) {
        inhabitants.remove(person);
    }

    public void moveIn(Person person) {
        person.getHouse().ifPresent(home -> home.moveOut(person));
        inhabitants.add(person);
    }

    @Override
    public String toString() {
        return type + " in " + settlement.get().getName();
    }
}
