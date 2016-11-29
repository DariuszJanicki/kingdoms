package graphics.graphics.details.generator;

import graphics.frame.FpsTimer;
import graphics.graphics.details.model.person.Gender;
import graphics.graphics.details.model.person.Person;

public enum PersonGenerator {

    INSTANCE;

    /* ========== PUBLIC ========== */
    public Person createPerson() {
        Gender gender = Gender.random();
        Person person = new Person(NameGenerator.generateName(gender), gender, FpsTimer.singleton().getCurrentDate());

        System.out.println("Nowy człowiek: " + person);

        return person;
    }
}
