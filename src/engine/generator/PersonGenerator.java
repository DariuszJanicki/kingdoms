package engine.generator;

import engine.model.ComponentModel;
import engine.date.GameDate;
import engine.model.person.Gender;
import engine.model.person.Person;
import utils.Dice;

public enum PersonGenerator {

    INSTANCE;

    /* ========== PUBLIC ========== */
    public Person createBaby() {
        Gender gender = Gender.random();
        return new Person(
                NameGenerator.INSTANCE.generateName(gender),
                gender,
                GameDate.of(ComponentModel.INSTANCE.getGameDate()));
    }

    public Person createRandomPerson() {
        Gender gender = Gender.random();
        return new Person(
                NameGenerator.INSTANCE.generateName(gender),
                gender,
                GameDate.of(-Dice.k(5000) - 5000));
    }
}
