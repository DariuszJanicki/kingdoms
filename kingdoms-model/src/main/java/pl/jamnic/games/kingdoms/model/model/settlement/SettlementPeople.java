package pl.jamnic.games.kingdoms.model.model.settlement;

import pl.jamnic.games.kingdoms.model.model.building.Building;
import pl.jamnic.games.kingdoms.model.model.person.People;
import pl.jamnic.games.kingdoms.model.model.person.Person;
import utils.Dice;

import java.util.List;
import java.util.stream.Collectors;

public final class SettlementPeople extends People {

    void haveChildren() {
        people.stream()
                .filter(person -> person.isFemale().isTrue())
                .filter(woman -> woman.hasSpouse().isTrue())
                .filter(woman -> woman.canHaveChildren().isTrue())
                .filter(woman -> woman.isPregnant().isFalse())
                .filter(woman -> Dice.test(5))
                .forEach(woman -> woman.startPregnancy(woman.getSpouse()));
    }

    void buyEstates(List<Building> buildings) {
        buildings.stream()
                .filter(building -> building.getOwner().isPresent().isFalse())
                .collect(Collectors.toList())
                .forEach(building -> new Dice<Person>().randomElementOf(people).claim(building));
    }

    List<Person> checkDeaths() {
        return people.stream()
                .filter(person -> person.deadTest().isTrue())
                .collect(Collectors.toList());
    }

    void assignTasks(SettlementTaskScheduler scheduler) {
        people.forEach(person -> scheduler
                .isEmpty()
                .ifFalse(() -> person.addTask(scheduler.getTask().get())));
    }
}
