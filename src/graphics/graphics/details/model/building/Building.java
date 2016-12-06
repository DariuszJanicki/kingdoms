package graphics.graphics.details.model.building;

import graphics.graphics.details.model.person.Person;

import java.util.ArrayList;
import java.util.List;

public class Building {

    private Person owner;
    private final List<Person> inhabitants = new ArrayList<>();
    private final BuildingType type;

    /* ========== PUBLIC ========== */
    public Building(BuildingType type, Person owner) {
        this.type = type;
        this.owner = owner;
    }
}
