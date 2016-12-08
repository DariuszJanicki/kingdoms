package engine.model.settlement;

import engine.model.building.Buildings;
import engine.model.person.People;
import engine.model.person.Person;
import lombok.val;
import utils.Dice;

import java.util.stream.Collectors;

public final class SettlementPeople extends People {

    public void haveChildren() {
        people.stream()
                .filter(person -> person.isFemale().isTrue())
                .filter(woman -> woman.hasSpouse().isTrue())
                .filter(woman -> woman.isPregnant().isFalse())
                .filter(woman -> Dice.test(100))
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

    public void buyEstates(Buildings buildings) {
        buildings.available()
                .forEach(building -> new Dice<Person>().randomElementOf(people).claim(building));
    }

}
