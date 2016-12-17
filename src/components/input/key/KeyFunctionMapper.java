package components.input.key;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import utils.datastructure.MapOpt;

import java.util.function.Consumer;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class KeyFunctionMapper {

    private MapOpt<KeyAction, Consumer<GameKeyEvent>> mapping = new MapOpt<>();

    /* ========== STATIC ========== */
    public static KeyFunctionMapper of() {
        return new KeyFunctionMapper();
    }

    /* ========== PUBLIC ========== */
    public void press(GameKeyEvent e) {
        mapping.get(e.getAction())
                .ifPresent(f -> f.accept(e));
    }

    public KeyFunctionMapper register(KeyAction action, Consumer<GameKeyEvent> function) {
        mapping.putAll(action, function);
        return this;
    }
}
