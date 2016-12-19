package pl.jamnic.games.kingdoms.model.model.settlement;

import lombok.Getter;
import pl.jamnic.games.kingdoms.model.generator.AreaGenerator;
import pl.jamnic.games.kingdoms.model.generator.BuildingGenerator;
import pl.jamnic.games.kingdoms.model.generator.PersonGenerator;
import pl.jamnic.games.kingdoms.model.model.Tickable;
import pl.jamnic.games.kingdoms.model.model.map.Area;
import pl.jamnic.games.kingdoms.model.model.map.Field;
import pl.jamnic.games.kingdoms.model.model.map.GameMap;
import pl.jamnic.games.kingdoms.model.model.person.People;
import pl.jamnic.games.kingdoms.model.model.person.Person;
import pl.jamnic.games.kingdoms.utils.points.Coords;
import pl.jamnic.games.kingdoms.utils.points.Size;
import utils.Bool;
import utils.Dice;
import utils.Opt;

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
        removeVillagers(settlementPeople.checkDeaths());
    }

    private void removeVillagers(List<Person> persons) {
        settlementPeople.remove(persons);
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
