package pl.jamnic.games.kingdoms.model.generator;

import pl.jamnic.games.kingdoms.date.GameDate;
import pl.jamnic.games.kingdoms.model.model.person.Gender;
import pl.jamnic.games.kingdoms.model.model.person.Person;
import utils.Dice;

public enum PersonGenerator {

    INSTANCE;

    /* ========== PUBLIC ========== */
    public Person createBaby() {
        Gender gender = Gender.random();
        return new Person(
                NameGenerator.INSTANCE.generateName(gender),
                gender,
                GameDate.of(10)); // TODO djanicki
    }

    public Person createRandomPerson() {
        Gender gender = Gender.random();
        return new Person(
                NameGenerator.INSTANCE.generateName(gender),
                gender,
                GameDate.of(-Dice.k(5000) - 5000));
    }
}
