package graphics.graphics.details.generator;

import graphics.graphics.details.model.ComponentModel;
import graphics.graphics.details.model.person.GameDate;
import graphics.graphics.details.model.person.Gender;
import graphics.graphics.details.model.person.Person;

public enum PersonGenerator {

    INSTANCE;

    /* ========== PUBLIC ========== */
    public Person createPerson() {
        Gender gender = Gender.random();
        Person person = new Person(NameGenerator.INSTANCE.generateName(gender), gender, GameDate.of(ComponentModel.INSTANCE.getGameDate()));

        System.out.println("Nowy człowiek: " + person);

        return person;
    }
}
