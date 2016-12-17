package pl.jamnic.games.kingdoms.model.model.building;

import lombok.Getter;
import lombok.Setter;
import pl.jamnic.games.kingdoms.model.model.Tickable;
import pl.jamnic.games.kingdoms.model.model.person.People;
import pl.jamnic.games.kingdoms.model.model.person.Person;
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
