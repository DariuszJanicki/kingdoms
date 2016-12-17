package pl.jamnic.games.kingdoms.model.loader.tile.list;

import pl.jamnic.games.kingdoms.model.loader.tile.AbstractTileType;
import lombok.val;
import utils.Dice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractTileTypeList<T extends AbstractTileType> {

    protected List<T> list = new ArrayList<>();

    /* ========== PUBLIC ========== */
    public T getTile(Enum type) {
        val collect = list.stream()
                .filter(t -> t.getType() == type)
                .collect(Collectors.toList());

        return getTile(collect);
    }

    /* ========== PRIVATE ========== */
    private T getTile(List<T> collect) {
        return collect.isEmpty() ? list.get(0) : new Dice<T>().randomElementOf(collect);
    }
}
