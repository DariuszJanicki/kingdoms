package view.instances.contextlist;

import engine.points.Rect;
import utils.Bool;
import view.click.ClickFunctionMapper;
import view.click.MouseAction;
import view.component.ContextListComponent;

public final class TileContextList extends ContextListComponent {

    /* ========== PUBLIC ========== */
    public TileContextList(Rect rect) {
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

    @Override
    public Bool isTemporary() {
        return Bool.TRUE;
    }
}
