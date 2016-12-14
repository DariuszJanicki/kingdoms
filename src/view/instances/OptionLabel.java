package view.instances;

import view.component.LabelComponent;
import engine.points.Rect;

public final class OptionLabel extends LabelComponent {

    /* ========== PUBLIC ========== */
    public OptionLabel(Rect rect, Option option) {
        super(rect);
        setText(option.getText());
    }
}
