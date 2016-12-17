package pl.jamnic.games.kingdoms.date;

import lombok.AllArgsConstructor;

@AllArgsConstructor
enum Season {

    SPRING(91, "Wiosny"),
    SUMMER(182, "Lata"),
    FALL(274, "Jesieni"),
    WINTER(365, "Zimy");

    private Integer time;
    private String name;

    /* ========== STATIC ========== */
    public static String of(int time) {
        for (Season season : values()) {
            if (season.time >= time) {
                return season.name;
            }
        }

        return SPRING.name;
    }
}