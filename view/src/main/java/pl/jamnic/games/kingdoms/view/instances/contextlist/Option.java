package pl.jamnic.games.kingdoms.view.instances.contextlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.jamnic.games.kingdoms.uicomponents.input.mouse.MouseFunctionMapper;

@Getter
@AllArgsConstructor
public final class Option {

    private MouseFunctionMapper click;
    private String text;
}
