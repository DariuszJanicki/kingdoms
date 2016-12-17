package pl.jamnic.games.kingdoms.view.drawer;

import lombok.Getter;
import lombok.Setter;
import pl.jamnic.games.kingdoms.model.loader.Direction;
import pl.jamnic.games.kingdoms.model.loader.tile.TerrainTileType;
import pl.jamnic.games.kingdoms.model.loader.tile.list.TerrainTileTypeList;
import pl.jamnic.games.kingdoms.model.model.map.Area;
import pl.jamnic.games.kingdoms.model.model.map.GameMap;
import pl.jamnic.games.kingdoms.model.model.terrain.TerrainType;
import pl.jamnic.games.kingdoms.uicomponents.components.GameGraphics;
import pl.jamnic.games.kingdoms.utils.points.Coords;
import pl.jamnic.games.kingdoms.utils.points.Point;
import pl.jamnic.games.kingdoms.utils.points.Rect;
import utils.Opt;

@Setter
@Getter
public class AreaDrawer extends AbstractDrawer<Area> {

    public static void draw(GameGraphics g, Area area, GameMap<Area> map, Rect rect, Point delta) {
        g.draw(setTerrainTile(map, area).getImage(), rect.move(delta));
        area.getBuilding().ifPresent(building -> BuildingDrawer.draw(g, building, rect, delta));
    }

    private static TerrainTileType setTerrainTile(GameMap<Area> map, Area area) {
        TerrainType terrain = area.getTerrain();
        Coords coords = area.getCoords();

        Direction direction = Direction.getDirection(
                equals(terrain, map.get(coords.north())),
                equals(terrain, map.get(coords.south())),
                equals(terrain, map.get(coords.east())),
                equals(terrain, map.get(coords.west())));

        return TerrainTileTypeList.singleton().getTile(terrain, direction);
    }

    private static boolean equals(TerrainType terrain, Opt<Area> area) {
        return area.isPresent().isTrue() && area.get().getTerrain() == terrain;
    }
}
