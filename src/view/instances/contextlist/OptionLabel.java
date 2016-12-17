package view.instances.contextlist;

import components.components.LabelComponent;
import utils.points.Rect;

public final class OptionLabel extends LabelComponent {

    /* ========== PUBLIC ========== */
    public OptionLabel(Rect rect, Option option) {
        super(rect);
        setText(option.getText());
    }
}
