package pl.jamnic.games.kingdoms.model.generator;

import pl.jamnic.games.kingdoms.model.model.map.Area;
import pl.jamnic.games.kingdoms.model.model.map.GameMap;
import pl.jamnic.games.kingdoms.model.model.terrain.TerrainType;
import pl.jamnic.games.kingdoms.utils.datastructure.GameArray;
import pl.jamnic.games.kingdoms.utils.points.Coords;
import pl.jamnic.games.kingdoms.utils.points.Size;
import utils.Dice;

public enum AreaGenerator {

    INSTANCE;

    /* ========== PUBLIC ========== */
    public GameMap<Area> generateMap(Size size) {
        return new GameMap<>(size, new GameArray<>(size, this::createField));
    }

    /* ========== PRIVATE ========== */
    private Area createField(Coords coords) {
        TerrainType type = new Dice<TerrainType>().randomElementOf(TerrainType.values());
        return new Area(type, coords);
    }
}
