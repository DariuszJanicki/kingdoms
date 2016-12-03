package graphics.graphics.instances;

import graphics.graphics.ClickFunction;
import graphics.graphics.Option;
import graphics.graphics.OptionList;
import graphics.graphics.component.OptionListComponent;
import graphics.graphics.details.points.Rect;

public class BoardOptionList extends OptionListComponent {

    /* ========== CONSTRUCTOR ========== */
    public BoardOptionList(Rect rect) {
        super(rect);

        OptionList list = new OptionList();
        list.add(new Option(new ClickFunction().registerLeft(event -> System.out.println("Zbuduj zamek")), "Zbuduj zamek"));
        list.add(new Option(new ClickFunction().registerLeft(event -> System.out.println("Test2")), "Zbuduj wioskę"));
        setOptions(list);
    }
}
