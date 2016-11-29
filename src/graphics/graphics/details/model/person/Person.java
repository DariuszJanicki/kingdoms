package graphics.graphics.details.model.person;

import graphics.graphics.details.model.relation.Relations;
import utils.Bool;

public class Person {

    private final String name;
    private final Gender gender;
    private final GameDate birthDate;
    private final Relations relations = new Relations();
    private Pregnancy pregnancy;

    /* ========== CONSTRUCTOR ========== */
    public Person(String name, Gender gender, GameDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return gender + " " + name + " born in " + birthDate;
    }

    public Bool isMale() {
        return gender.isMale();
    }

    public Bool hasSpouse() {
        return relations.hasSpouse();
    }

    public void marry(Person person) {
        relations.addSpouse(person);
        person.relations.addSpouse(this);

        System.out.println(this + " żeni się z " + person);
    }

    public Bool isPregnant() {
        return Bool.of(true);
    }
}