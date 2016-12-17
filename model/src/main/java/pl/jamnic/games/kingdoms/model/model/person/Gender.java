package pl.jamnic.games.kingdoms.model.model.person;

import lombok.AllArgsConstructor;
import utils.Bool;
import utils.Dice;

@AllArgsConstructor
public enum Gender {

    MALE("Mężczyzna"), FEMALE("Kobieta");

    private String name;

    /* ========== STATIC ========== */
    public static Gender random() {
        return new Dice<Gender>().randomElementOf(values());
    }

    /* ========== PUBLIC ========== */
    public Bool isMale() {
        return Bool.of(this == MALE);
    }

    public Bool isFemale() {
        return Bool.of(this == FEMALE);
    }

    @Override
    public String toString() {
        return name;
    }
}
