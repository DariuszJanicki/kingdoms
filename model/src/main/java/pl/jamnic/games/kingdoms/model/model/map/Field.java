package pl.jamnic.games.kingdoms.model.model.map;

import lombok.Getter;
import lombok.Setter;
import pl.jamnic.games.kingdoms.model.model.settlement.Settlement;
import pl.jamnic.games.kingdoms.model.model.terrain.TerrainType;
import pl.jamnic.games.kingdoms.utils.points.Coords;
import utils.Opt;

@Getter
public final class Field extends AbstractArea {

    @Setter
    private Opt<Settlement> settlement = Opt.empty();

    /* ========== PUBLIC ========== */
    public Field(TerrainType terrain, Coords coords) {
        super(terrain, coords);
    }

    @Override
    public void tick() {
        settlement.ifPresent(Settlement::tick);
    }
}
