package view.instances;

import lombok.AllArgsConstructor;
import lombok.Getter;
import view.click.ClickFunctionMapper;

@Getter
@AllArgsConstructor
public final class Option {

    private ClickFunctionMapper click;
    private String text;
}
