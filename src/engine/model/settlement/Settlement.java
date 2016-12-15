package engine.model.settlement;

import engine.model.Tickable;
import engine.model.map.Area;
import engine.model.map.Field;
import engine.model.map.GameMap;
import engine.model.person.People;
import engine.model.person.Person;
import engine.points.Coords;
import engine.points.Size;
import lombok.Getter;
import utils.Bool;
import utils.Dice;
import utils.Opt;
import view.generator.AreaGenerator;
import view.generator.BuildingGenerator;
import view.generator.PersonGenerator;

import java.util.List;
import java.util.stream.Collectors;

public final class Settlement implements Tickable {

    @Getter
    private final String name;
    @Getter
    private final Field field;
    @Getter
    private final SettlementType type;

    @Getter
    private final SettlementPeople settlementPeople = new SettlementPeople();
    private final People newPeople = new People();

    @Getter
    private GameMap<Area> settlementAreaMap = AreaGenerator.INSTANCE.generateMap(Size.of(10, 10));

    /* ========== PUBLIC ========== */
    public Settlement(SettlementType type, String name, Field field) {
        this.type = type;
        this.name = name;
        this.field = field;

        for (int i = 0; i < 10; ++i) {
            settlementAreaMap
                    .get(new Coords(Dice.k(10), Dice.k(10)))
                    .ifPresent(area -> area.getBuilding()
                            .ifNotPresent(() -> area
                                    .setBuilding(Opt.ofNullable(BuildingGenerator.INSTANCE.createRandom()))));
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
        settlementPeople.buyEstates(settlementAreaMap.getArray().stream()
                .filter(area -> area.getBuilding().isPresent().isTrue())
                .map(area -> area.getBuilding().get())
                .collect(Collectors.toList()));
    }

    /* ========== PRIVATE ========== */
    private void addVillager(Person person) {
        person.canJoinSettlement().and(canAddPersonToSettlement()).ifTrue(() -> {
            newPeople.add(person);
            person.setSettlement(Opt.of(this));
        });
    }

    private Bool canAddPersonToSettlement() {
        return Bool.TRUE;
    }
}
