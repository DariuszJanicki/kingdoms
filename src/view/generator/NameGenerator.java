package view.generator;

import engine.model.person.Gender;
import utils.Dice;

public enum NameGenerator {

    INSTANCE;

    /* ========== STATIC ========== */
    private static String[] maleEndings = {"ek", "nus", "usz", "woj", "mir", "diusz", "ol"};
    private static String[] femaleEndings = {"la", "icja", "mira", "woja", "usza", "ena", "ka"};
    private static String[] commonBeginnings = {"Al", "Dar", "Mar", "Kub", "Sol", "El", "Iz"};
    private static String[] settlementBeginnings = {"Mur", "Raven", "War", "Crow", "Boar", "Riven", "Worm"};
    private static String[] settlementEndings = {"dell", "string", "dale", "claw", "hill", "stock", "pool"};

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

    public String generateSettlementName() {
        return new Dice<String>().randomElementOf(settlementBeginnings)
                + new Dice<String>().randomElementOf(settlementEndings);
    }
}
