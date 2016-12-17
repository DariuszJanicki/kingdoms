package view.drawer;

import engine.model.building.Building;
import utils.points.Point;
import utils.points.Rect;
import lombok.Getter;
import lombok.Setter;
import components.components.GameGraphics;
import engine.loader.tile.list.BuildingTileTypeList;

@Setter
@Getter
public class BuildingDrawer extends AbstractDrawer<Building> {

    public static void draw(GameGraphics g, Building building, Rect rect, Point delta) {
        g.draw(BuildingTileTypeList
                .singleton()
                .getTile(building.getType()).getImage(), rect.move(delta));
    }
}
