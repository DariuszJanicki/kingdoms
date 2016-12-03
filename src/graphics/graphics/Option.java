package graphics.graphics;

import lombok.Getter;

@Getter
public final class Option {

    private ClickFunction click;
    private String text;

    /* ========== PUBLIC ========== */
    public Option(ClickFunction click, String text) {
        this.click = click;
        this.text = text;
    }



}
