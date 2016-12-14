package view.generator;

import engine.model.building.Building;
import engine.model.building.BuildingType;
import utils.Dice;
import view.loader.tile.list.BuildingTileTypeList;
import view.drawer.BuildingDrawer;

public enum BuildingGenerator {

    INSTANCE;

    /* ========== PUBLIC ========== */
    public Building createRandom() {
        BuildingType type = new Dice<BuildingType>().randomElementOf(BuildingType.values());
        Building wrapper = new Building(type);
        return wrapper;
    }
}
