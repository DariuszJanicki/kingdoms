package graphics.graphics.details.model.building;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Buildings {

    private List<Building> buildings = new ArrayList<>();

    public void addBuildings(Buildings newBuildings) {
        buildings.addAll(newBuildings.buildings);
        newBuildings.clear();
    }

    private void clear() {
        buildings.clear();
    }

    public void add(Building building) {
        buildings.add(building);
    }

    public List<Building> available() {
        return buildings.stream()
                .filter(building -> building.getOwner().isPresent().isFalse())
                .collect(Collectors.toList());
    }
}
