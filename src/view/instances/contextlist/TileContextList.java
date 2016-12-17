package view.instances.contextlist;

import utils.points.Rect;
import utils.Bool;
import components.input.mouse.MouseFunctionMapper;
import components.input.mouse.MouseAction;
import components.components.ContextListComponent;

public final class TileContextList extends ContextListComponent {

    /* ========== PUBLIC ========== */
    public TileContextList(Rect rect) {
        super(rect);

        OptionList list = new OptionList();
        list.add(new Option(MouseFunctionMapper
                .of()
                .register(MouseAction.LEFT_CLICK, event -> System.out.println("Zbuduj zamek")), "Zbuduj zamek"));
        list.add(new Option(MouseFunctionMapper
                .of()
                .register(MouseAction.LEFT_CLICK, event -> System.out.println("Test2")), "Zbuduj wioskę"));
        setOptions(list);
    }

    @Override
    public Bool isTemporary() {
        return Bool.TRUE;
    }
}
