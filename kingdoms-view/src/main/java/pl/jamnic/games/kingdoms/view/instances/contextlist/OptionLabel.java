package pl.jamnic.games.kingdoms.view.instances.contextlist;

import pl.jamnic.games.kingdoms.uicomponents.components.LabelComponent;
import pl.jamnic.games.kingdoms.utils.points.Rect;

public final class OptionLabel extends LabelComponent {

    /* ========== PUBLIC ========== */
    public OptionLabel(Rect rect, Option option) {
        super(rect);
        setText(option.getText());
    }
}
