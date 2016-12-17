package engine.generator;

import engine.model.building.Building;
import engine.model.building.BuildingType;
import utils.Dice;

public enum BuildingGenerator {

    INSTANCE;

    /* ========== PUBLIC ========== */
    public Building createRandom() {
        BuildingType type = new Dice<BuildingType>().randomElementOf(BuildingType.values());
        return new Building(type);
    }
}
