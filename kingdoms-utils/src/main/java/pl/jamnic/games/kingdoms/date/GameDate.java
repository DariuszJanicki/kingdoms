package pl.jamnic.games.kingdoms.date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class GameDate {

    private Long time;

    /* ========== STATIC ========== */
    public static GameDate of(GameDate gameDate) {
        return new GameDate(gameDate.time);
    }

    public static GameDate of(Long time) {
        return new GameDate(time);
    }

    /* ========== PUBLIC ========== */
    @Override
    public String toString() {
        return time % 365 + " dzień " + Season.of(time % 365) + ", roku " + time / 365;
    }

    public Long getYear() {
        return time / 365;
    }

    public GamePeriod difference(GameDate gameDate) {
        return new GamePeriod(gameDate.time - time);
    }
}
