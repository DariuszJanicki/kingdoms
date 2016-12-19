package pl.jamnic.games.kingdoms.model.generator;

import pl.jamnic.games.kingdoms.model.model.building.Building;
import pl.jamnic.games.kingdoms.model.model.building.BuildingType;
import utils.Dice;

public enum BuildingGenerator {

    INSTANCE;

    /* ========== PUBLIC ========== */
    public Building createRandom() {
        BuildingType type = new Dice<BuildingType>().randomElementOf(BuildingType.values());
        return new Building(type);
    }
}
