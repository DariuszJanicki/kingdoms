package graphics.graphics;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public final class OptionList {

    @Getter
    private List<Option> options = new ArrayList<>();

    /* ========== PUBLIC ========== */
    public void add(Integer value, String text) {
        options.add(new Option(value, text));
    }

    public void add(Option option) {
        options.add(option);
    }
}
