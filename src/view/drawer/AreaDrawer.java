package view.drawer;

import engine.model.map.Area;
import engine.model.map.GameMap;
import view.loader.Direction;
import engine.model.terrain.TerrainType;
import engine.points.Coords;
import engine.points.Point;
import engine.points.Rect;
import lombok.Getter;
import lombok.Setter;
import utils.Opt;
import view.component.GameGraphics;
import view.loader.tile.TerrainTileType;
import view.loader.tile.list.TerrainTileTypeList;

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
