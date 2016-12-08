package view.instances;

import view.interfaces.Option;
import view.component.LabelComponent;
import engine.points.Rect;

public class OptionLabel extends LabelComponent {

    public OptionLabel(Rect rect, Option option) {
        super(rect);

        setText(option.getText());
    }
}
