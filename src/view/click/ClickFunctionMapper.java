package view.click;

import base.utils.GameMap;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Consumer;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ClickFunctionMapper {

    private GameMap<MouseAction, Consumer<GameMouseEvent>> mouseActionMapping = new GameMap<>();

    /* ========== STATIC ========== */
    public static ClickFunctionMapper of() {
        return new ClickFunctionMapper();
    }

    /* ========== PUBLIC ========== */
    public void click(GameMouseEvent e) {
        mouseActionMapping.get(e.getAction()).ifPresent((f) -> f.accept(e));
    }

    public ClickFunctionMapper register(MouseAction action, Consumer<GameMouseEvent> function) {
        mouseActionMapping.putAll(action, function);
        return this;
    }

    public void copy(ClickFunctionMapper click) {
        mouseActionMapping.putAll(click.mouseActionMapping);
    }
}
