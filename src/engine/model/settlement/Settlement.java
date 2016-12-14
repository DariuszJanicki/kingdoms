package engine.model.settlement;

import engine.model.Tickable;
import engine.model.building.Building;
import engine.model.building.Buildings;
import engine.model.map.GameMap;
import engine.model.map.MapArea;
import engine.model.map.SettlementArea;
import engine.model.person.People;
import engine.model.person.Person;
import engine.points.Size;
import lombok.Getter;
import utils.Bool;
import utils.Opt;
import view.generator.AreaGenerator;
import view.generator.BuildingGenerator;
import view.generator.PersonGenerator;

import java.util.List;

public final class Settlement implements Tickable {

    @Getter
    private final String name;
    @Getter
    private final MapArea mapArea;
    @Getter
    private final SettlementType type;

    @Getter
    private final SettlementPeople settlementPeople = new SettlementPeople();
    private final People newPeople = new People();
    private final Buildings buildings = new Buildings();
    private final Buildings newBuildings = new Buildings();
    @Getter
    private GameMap<SettlementArea> settlementAreaMap = AreaGenerator.INSTANCE.generateMap(Size.of(10, 10));

    /* ========== PUBLIC ========== */
    public Settlement(SettlementType type, String name, MapArea mapArea) {
        this.type = type;
        this.name = name;
        this.mapArea = mapArea;

        for (int i = 0; i < 10; ++i) {
            addBuilding(BuildingGenerator.INSTANCE.createRandom());
        }

        for (int i = 0; i < 5; ++i) {
            addVillager(PersonGenerator.INSTANCE.createRandomPerson());
        }
    }

    public void addVillagers(List<Person> people) {
        people.forEach(this::addVillager);
    }

    public void tick() {
        settlementPeople.tick();
        settlementPeople.marryCitizens();
        settlementPeople.haveChildren();
        settlementPeople.merge(newPeople);
        settlementPeople.buyEstates(buildings);
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
