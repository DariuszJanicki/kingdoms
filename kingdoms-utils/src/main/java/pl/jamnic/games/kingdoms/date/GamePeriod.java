package pl.jamnic.games.kingdoms.date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final public class GamePeriod {

    @Getter
    private final Integer time;

    public Integer getYears() {
        return time / 365;
    }
}
