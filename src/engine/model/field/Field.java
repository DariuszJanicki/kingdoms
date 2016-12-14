package engine.model.field;

import engine.model.settlement.Settlement;
import engine.model.terrain.Terrain;
import engine.points.Coords;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import utils.Opt;
import view.interfaces.Tickable;

@Getter
@RequiredArgsConstructor
public class Field implements Tickable {

    @Setter
    private Opt<Settlement> settlement = Opt.empty();
    private final Terrain terrain;
    private final Coords coords;

    /* ========== CONSTRUCTOR ========== */
    @Override
    public void tick() {
        settlement.ifPresent(Settlement::tick);
    }
}
