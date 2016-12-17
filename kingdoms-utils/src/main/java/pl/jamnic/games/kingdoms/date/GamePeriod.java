package pl.jamnic.games.kingdoms.date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import utils.Bool;

@RequiredArgsConstructor
final public class GamePeriod {

    @Getter
    private final Long time;

    public Long getYears() {
        return time / 365;
    }

    public Bool greaterThanYears(Long years) {
        return Bool.of(getYears() > years);
    }
}
