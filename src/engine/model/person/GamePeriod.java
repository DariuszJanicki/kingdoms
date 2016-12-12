package engine.model.person;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
final class GamePeriod {

    @Getter
    private final Integer time;

    Integer getYears() {
        return time / 365;
    }
}
