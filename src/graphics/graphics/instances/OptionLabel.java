package graphics.graphics.instances;

import graphics.graphics.Option;
import graphics.graphics.component.LabelComponent;
import graphics.graphics.details.points.Rect;
import utils.Opt;

public class OptionLabel extends LabelComponent {

    public OptionLabel(Rect rect, Option option) {
        super(rect);

        text = Opt.ofNullable(option.getText());
    }
}
