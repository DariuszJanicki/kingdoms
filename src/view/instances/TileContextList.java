package view.instances;

import view.click.ClickFunctionMapper;
import view.click.MouseAction;
import view.component.ContextListComponent;
import engine.points.Rect;

final class TileContextList extends ContextListComponent {

    /* ========== DEFAULT ========== */
    TileContextList(Rect rect) {
        super(rect);

        OptionList list = new OptionList();
        list.add(new Option(ClickFunctionMapper
                .of()
                .register(MouseAction.LEFT_CLICK, event -> System.out.println("Zbuduj zamek")), "Zbuduj zamek"));
        list.add(new Option(ClickFunctionMapper
                .of()
                .register(MouseAction.LEFT_CLICK, event -> System.out.println("Test2")), "Zbuduj wioskę"));
        setOptions(list);
    }
}
