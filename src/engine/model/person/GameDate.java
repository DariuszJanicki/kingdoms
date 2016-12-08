package engine.model.person;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GameDate {

    private Integer time;

    /* ========== STATIC ========== */
    public static GameDate of(GameDate gameDate) {
        return new GameDate(gameDate.time);
    }

    public static GameDate of(Integer time) {
        return new GameDate(time);
    }

    public static GameDate init() {
        return new GameDate(0);
    }

    /* ========== PUBLIC ========== */
    public void dayPassed() {
        time += 1;
    }

    @Override
    public String toString() {
        return time % 365 + " dzień " + Season.of(time % 365) + ", roku " + time / 365;
    }

    public Integer getYear() {
        return time / 365;
    }

    public GamePeriod difference(GameDate gameDate) {
        return new GamePeriod(gameDate.time - time);
    }
}
