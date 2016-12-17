package pl.jamnic.games.kingdoms.date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Timer {

    private Long time;

    @Getter
    private static Timer singleton = new Timer(10000L);

    /* ========== PUBLIC ========== */
    public void addTime() {
        time += 1;
    }

    public GameDate getTime() {
        return GameDate.of(time);
    }
}
