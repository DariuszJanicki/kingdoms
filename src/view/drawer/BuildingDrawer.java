package view.drawer;

import engine.model.building.Building;
import engine.points.Point;
import engine.points.Rect;
import lombok.Getter;
import lombok.Setter;
import view.component.GameGraphics;
import view.loader.tile.list.BuildingTileTypeList;

@Setter
@Getter
public class BuildingDrawer extends AbstractDrawer<Building> {

    public static void draw(GameGraphics g, Building building, Rect rect, Point delta) {
        g.draw(BuildingTileTypeList
                .singleton()
                .getTile(building.getType()).getImage(), rect.move(delta));
    }
}
