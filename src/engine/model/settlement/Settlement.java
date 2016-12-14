package engine.model.settlement;

import engine.model.building.Building;
import engine.model.building.Buildings;
import engine.model.field.Field;
import engine.model.person.People;
import engine.model.person.Person;
import lombok.Getter;
import utils.Bool;
import utils.Opt;
import view.interfaces.Tickable;

import java.util.List;

public class Settlement implements Tickable {

    @Getter
    private final String name;
    @Getter
    private final Field field;
    @Getter
    private final SettlementType type;

    @Getter
    private final SettlementPeople inhabitants = new SettlementPeople();
    private final People newPeople = new People();
    private final Buildings buildings = new Buildings();
    private final Buildings newBuildings = new Buildings();

    /* ========== PUBLIC ========== */
    public Settlement(SettlementType type, String name, Field field) {
        this.type = type;
        this.name = name;
        this.field = field;
    }

    public void addVillagers(List<Person> people) {
        people.forEach(this::addVillager);
    }

    public void tick() {
        inhabitants.tick();
        inhabitants.marryCitizens();
        inhabitants.haveChildren();
        inhabitants.introduceNewPeople(newPeople);
        inhabitants.buyEstates(buildings);
        buildings.addBuildings(newBuildings);
    }

    /* ========== PRIVATE ========== */
    private void addVillager(Person person) {
        person.canJoinSettlement().and(canAddPersonToSettlement()).ifTrue(() -> {
            newPeople.add(person);
            person.setSettlement(Opt.of(this));
        });
    }

    private void addBuilding(Building building) {
        building.canBeBuiltInSettlement().and(canAddBuildingToSettlement()).ifTrue(() -> {
            newBuildings.add(building);
            building.setSettlement(Opt.of(this));
        });
    }

    private Bool canAddBuildingToSettlement() {
        return Bool.TRUE;
    }

    private Bool canAddPersonToSettlement() {
        return Bool.TRUE;
    }
}
