package graphics.graphics.details.model.person;

import utils.Dice;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.stream.Collectors;

public class People {

    private final List<Person> people = new ArrayList<>();

    public void tick() {
        try {
            people.forEach(Person::tick);
        } catch(ConcurrentModificationException e) {
            e.printStackTrace();
        }
    }

    public void haveChildren() {
        people.stream()
                .filter(person -> person.isFemale().isTrue())
                .filter(woman -> woman.hasSpouse().isTrue())
                .filter(woman -> woman.isPregnant().isFalse())
                .filter(woman -> Dice.test(100))
                .forEach(woman -> woman.startPregnancy(woman.getSpouse()));
    }

    public void marryCitizens() {
        List<Person> men = people.stream()
                .filter(person -> person.isMale().isTrue())
                .filter(man -> man.eligibleToWed().isTrue())
                .filter(man -> man.hasSpouse().isFalse())
                .collect(Collectors.toList());

        List<Person> women = people.stream()
                .filter(person -> person.isFemale().isTrue())
                .filter(woman -> woman.eligibleToWed().isTrue())
                .filter(woman -> woman.hasSpouse().isFalse())
                .collect(Collectors.toList());

        if (!men.isEmpty() && !women.isEmpty()) {
            men.get(0).marry(women.get(0));
        }
    }

    public void introduceNewPeople(People newPeople) {
        people.addAll(newPeople.people);
        newPeople.clear();
    }

    private void clear() {
        people.clear();
    }

    public void add(Person person) {
        people.add(person);
    }

    public void add(List<Person> newPeople) {
        people.addAll(newPeople);
    }

    public List<String> getVillagersList() {
        return people.stream()
                .map(Person::toString)
                .collect(Collectors.toList());
    }
}
