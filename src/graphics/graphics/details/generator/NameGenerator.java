package graphics.graphics.details.generator;

import graphics.graphics.details.model.person.Gender;
import utils.Dice;

public enum NameGenerator {

    INSTANCE;

    /* ========== STATIC ========== */
    private static String[] maleEndings = {"ek", "nus", "usz", "woj", "mir", "diusz", "ol"};
    private static String[] femaleEndings = {"la", "cja", "mira", "woja", "usza", "nusa", "eka"};
    private static String[] commonBeginnings = {"Ali", "Dar", "Mat", "Kub", "Sła", "Eli", "Iza"};

    public static String generateName(Gender gender) {
        return gender.isMale().isTrue() ? generateMaleName() : generateFemaleName();
    }

    /* ========== PRIVATE ========== */
    private static String generateFemaleName() {
        return getString(femaleEndings);
    }

    private static String generateMaleName() {
        return getString(maleEndings);
    }

    private static String getString(String[] endings) {
        return new Dice<String>().randomElementOf(commonBeginnings) + new Dice<String>().randomElementOf(endings);
    }
}
