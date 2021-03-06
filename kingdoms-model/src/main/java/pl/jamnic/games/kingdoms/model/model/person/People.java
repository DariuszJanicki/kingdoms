package pl.jamnic.games.kingdoms.model.model.person;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class People {

    private final Integer maxNumberOfPeople;

    @Getter
    protected final List<Person> people;

    /* ========== PUBLIC ========== */
    public People() {
        this(10000);
    }

    public People(List<Person> people) {
        this.people = new ArrayList<>(people);
        this.maxNumberOfPeople = people.size();
    }

    public People(Integer maxNumberOfPeople) {
        this.people = new ArrayList<>(maxNumberOfPeople);
        this.maxNumberOfPeople = maxNumberOfPeople;
    }

    public void tick() {
        people.forEach(Person::tick);
    }

    public void clear() {
        people.clear();
    }

    public void add(Person person) {
        people.add(person);
    }

    public void add(List<Person> newPeople) {
        people.addAll(newPeople);
    }

    public void merge(People newPeople) {
        people.addAll(newPeople.people);
        newPeople.clear();
    }

    public List<String> list() {
        return people.stream()
                .map(Person::toString)
                .collect(Collectors.toList());
    }

    public void remove(Person person) {
        people.remove(person);
    }

    public void remove(List<Person> persons) {
        people.removeAll(persons);
    }
}