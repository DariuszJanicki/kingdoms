package graphics.graphics.instances;

import graphics.graphics.Option;
import graphics.graphics.OptionList;
import graphics.graphics.component.OptionListComponent;
import graphics.graphics.details.points.Rect;

public class BoardOptionList extends OptionListComponent {

    /* ========== CONSTRUCTOR ========== */
    public BoardOptionList(Rect rect) {
        super(rect);

        OptionList list = new OptionList();
        list.add(new Option(0, "Test"));
        list.add(new Option(1, "Test1"));
        list.add(new Option(2, "Test2"));
        list.add(new Option(3, "Test3"));
        setOptions(list);
    }
}
