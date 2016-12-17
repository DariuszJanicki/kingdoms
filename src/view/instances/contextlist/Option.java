package view.instances.contextlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import components.input.mouse.MouseFunctionMapper;

@Getter
@AllArgsConstructor
public final class Option {

    private MouseFunctionMapper click;
    private String text;
}
