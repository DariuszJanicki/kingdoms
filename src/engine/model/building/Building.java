package engine.model.building;

import engine.model.Tickable;
import engine.model.person.People;
import engine.model.person.Person;
import lombok.Getter;
import lombok.Setter;
import utils.Opt;

public final class Building implements Tickable {

    @Setter
    @Getter
    private Opt<Person> owner = Opt.empty();
    private final People inhabitants = new People(10);
    @Getter
    private final BuildingType type;

    /* ========== PUBLIC ========== */
    public Building(BuildingType type) {
        this.type = type;
    }

    public void moveOut(Person person) {
        inhabitants.remove(person);
    }

    public void moveIn(Person person) {
        person.getHouse().ifPresent(home -> home.moveOut(person));
        inhabitants.add(person);
    }

    @Override
    public void tick() {

    }
}
