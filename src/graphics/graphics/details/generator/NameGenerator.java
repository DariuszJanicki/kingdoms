package graphics.graphics.details.generator;

import graphics.graphics.details.model.person.Gender;
import utils.Dice;

public enum NameGenerator {

    INSTANCE;

    /* ========== STATIC ========== */
    private static String[] maleEndings = {"ek", "nus", "usz", "woj", "mir", "diusz", "ol"};
    private static String[] femaleEndings = {"la", "icja", "mira", "woja", "usza", "ena", "ka"};
    private static String[] commonBeginnings = {"Al", "Dar", "Mar", "Kub", "Sol", "El", "Iz"};

    /* ========== PUBLIC ========== */
    public String generateName(Gender gender) {
        return gender.isMale().isTrue() ? generateMaleName() : generateFemaleName();
    }

    /* ========== PRIVATE ========== */
    private String generateFemaleName() {
        return getString(femaleEndings);
    }

    private String generateMaleName() {
        return getString(maleEndings);
    }

    private String getString(String[] endings) {
        return new Dice<String>().randomElementOf(commonBeginnings) + new Dice<String>().randomElementOf(endings);
    }
}
