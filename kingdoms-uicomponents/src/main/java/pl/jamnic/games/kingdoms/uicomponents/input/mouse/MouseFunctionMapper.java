package pl.jamnic.games.kingdoms.uicomponents.input.mouse;

import pl.jamnic.games.kingdoms.utils.datastructure.MapOpt;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Consumer;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MouseFunctionMapper {

    private MapOpt<MouseAction, Consumer<GameMouseEvent>> mouseActionMapping = new MapOpt<>();

    /* ========== STATIC ========== */
    public static MouseFunctionMapper of() {
        return new MouseFunctionMapper();
    }

    /* ========== PUBLIC ========== */
    public void click(GameMouseEvent e) {
        mouseActionMapping.get(e.getAction()).ifPresent((f) -> f.accept(e));
    }

    public MouseFunctionMapper register(MouseAction action, Consumer<GameMouseEvent> function) {
        mouseActionMapping.putAll(action, function);
        return this;
    }

    public void copy(MouseFunctionMapper click) {
        mouseActionMapping.putAll(click.mouseActionMapping);
    }
}
