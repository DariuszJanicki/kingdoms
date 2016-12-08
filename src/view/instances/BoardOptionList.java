package view.instances;

import view.interfaces.ClickFunction;
import view.interfaces.Option;
import view.interfaces.OptionList;
import view.component.OptionListComponent;
import engine.points.Rect;

public class BoardOptionList extends OptionListComponent {

    /* ========== CONSTRUCTOR ========== */
    public BoardOptionList(Rect rect) {
        super(rect);

        OptionList list = new OptionList();
        list.add(new Option(ClickFunction.of().registerLeft(event -> System.out.println("Zbuduj zamek")), "Zbuduj zamek"));
        list.add(new Option(ClickFunction.of().registerLeft(event -> System.out.println("Test2")), "Zbuduj wioskę"));
        setOptions(list);
    }
}
