package pl.jamnic.games.kingdoms.view.drawer;

import lombok.Getter;
import lombok.Setter;
import pl.jamnic.games.kingdoms.model.loader.tile.list.BuildingTileTypeList;
import pl.jamnic.games.kingdoms.model.model.building.Building;
import pl.jamnic.games.kingdoms.uicomponents.components.GameGraphics;
import pl.jamnic.games.kingdoms.utils.points.Point;
import pl.jamnic.games.kingdoms.utils.points.Rect;

@Setter
@Getter
public class BuildingDrawer extends AbstractDrawer<Building> {

    public static void draw(GameGraphics g, Building building, Rect rect, Point delta) {
        g.draw(BuildingTileTypeList
                .singleton()
                .getTile(building.getType()).getImage(), rect.move(delta));
    }
}
