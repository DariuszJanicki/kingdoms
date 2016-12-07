package graphics.graphics.details.generator;

import graphics.graphics.details.model.building.Building;
import graphics.graphics.details.model.building.BuildingType;
import utils.Dice;

public enum BuildingGenerator {

    INSTANCE;

    /* ========== PUBLIC ========== */
    public Building createRandom() {
        return new Building(new Dice<BuildingType>().randomElementOf(BuildingType.values()));
    }
}
