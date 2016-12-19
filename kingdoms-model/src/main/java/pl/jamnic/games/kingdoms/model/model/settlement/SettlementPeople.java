package pl.jamnic.games.kingdoms.model.model.settlement;

import lombok.val;
import pl.jamnic.games.kingdoms.model.model.building.Building;
import pl.jamnic.games.kingdoms.model.model.person.People;
import pl.jamnic.games.kingdoms.model.model.person.Person;
import utils.Dice;

import java.util.List;
import java.util.stream.Collectors;

public final class SettlementPeople extends People {

    public void haveChildren() {
        people.stream()
                .filter(person -> person.isFemale().isTrue())
                .filter(woman -> woman.hasSpouse().isTrue())
                .filter(woman -> woman.canHaveChildren().isTrue())
                .filter(woman -> woman.isPregnant().isFalse())
                .filter(woman -> Dice.test(5))
                .forEach(woman -> woman.startPregnancy(woman.getSpouse()));
    }

    public void marryCitizens() {
        val men = people.stream()
                .filter(person -> person.isMale().isTrue())
                .filter(man -> man.eligibleToWed().isTrue())
                .filter(man -> man.hasSpouse().isFalse())
                .collect(Collectors.toList());

        val women = people.stream()
                .filter(person -> person.isFemale().isTrue())
                .filter(woman -> woman.eligibleToWed().isTrue())
                .filter(woman -> woman.hasSpouse().isFalse())
                .collect(Collectors.toList());

        if (!men.isEmpty() && !women.isEmpty()) {
            men.get(0).marry(women.get(0));
        }
    }

    public void buyEstates(List<Building> buildings) {
        buildings.stream()
                .filter(building -> building.getOwner().isPresent().isFalse())
                .collect(Collectors.toList())
                .forEach(building -> new Dice<Person>().randomElementOf(people).claim(building));
    }

    public List<Person> checkDeaths() {
        return people.stream()
                .filter(person -> person.deadTest().isTrue())
                .collect(Collectors.toList());
    }
}
