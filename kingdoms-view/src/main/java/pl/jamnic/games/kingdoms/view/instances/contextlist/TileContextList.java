package pl.jamnic.games.kingdoms.view.instances.contextlist;

import pl.jamnic.games.kingdoms.uicomponents.input.mouse.MouseAction;
import pl.jamnic.games.kingdoms.uicomponents.input.mouse.MouseFunctionMapper;
import pl.jamnic.games.kingdoms.utils.points.Rect;
import utils.Bool;

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
