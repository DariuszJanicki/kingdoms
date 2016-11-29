package graphics.graphics.details.model.person;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Season {

    SPRING(3, "Wiosna"),
    SUMMER(6, "Lato"),
    FALL(9, "Jesień"),
    WINTER(12, "Zima");

    private Integer time;
    private String name;

    /* ========== PUBLIC STATIC ========== */
    public static String of(int time) {
        for (Season season : values()) {
            if (season.time >= time) {
                return season.name;
            }
        }

        return SPRING.name;
    }
}
