package graphics.graphics.details.model.person;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GamePeriod {

    @Getter
    private final Integer time;

    public Integer getYears() {
        return time / 365;
    }

}
