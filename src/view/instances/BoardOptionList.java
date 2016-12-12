package view.instances;

import view.click.ClickFunctionMapper;
import view.click.MouseAction;
import view.interfaces.Option;
import view.interfaces.OptionList;
import view.component.OptionListComponent;
import engine.points.Rect;

final class BoardOptionList extends OptionListComponent {

    /* ========== CONSTRUCTOR ========== */
    BoardOptionList(Rect rect) {
        super(rect);

        OptionList list = new OptionList();
        list.add(new Option(ClickFunctionMapper.of()
                .register(MouseAction.LEFT_CLICK, event -> System.out.println("Zbuduj zamek")), "Zbuduj zamek"));
        list.add(new Option(ClickFunctionMapper.of()
                .register(MouseAction.LEFT_CLICK, event -> System.out.println("Test2")), "Zbuduj wioskę"));
        setOptions(list);
    }
}
