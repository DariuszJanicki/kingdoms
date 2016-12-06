package graphics.graphics.details.generator;

import graphics.graphics.details.model.ComponentModel;
import graphics.graphics.details.model.person.GameDate;
import graphics.graphics.details.model.person.Gender;
import graphics.graphics.details.model.person.Person;
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
