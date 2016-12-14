package view.drawer;

import engine.model.field.Field;
import engine.model.map.GameMap;
import engine.model.terrain.Direction;
import engine.model.terrain.Terrain;
import engine.points.Coords;
import engine.points.Point;
import engine.points.Rect;
import lombok.Getter;
import lombok.Setter;
import utils.Opt;
import view.interfaces.GameGraphics;
import view.loader.tile.TerrainTileType;
import view.loader.tile.list.TerrainTileTypeList;

@Setter
@Getter
public class FieldDrawer extends AbstractDrawer<Field> {

    public static void draw(GameGraphics g, Field wrapper, GameMap<Field> map, Rect rect, Point delta) {
        g.draw(setTerrainTile(map, wrapper).getImage(), rect.move(delta));
        wrapper.getSettlement().ifPresent(s -> SettlementDrawer.draw(g, s, rect, delta));
    }

    private static TerrainTileType setTerrainTile(GameMap<Field> map, Field field) {
        Terrain terrain = field.getTerrain();
        Coords coords = field.getCoords();

        Direction direction = Direction.getDirection(
                equals(terrain, map.get(coords.north())),
                equals(terrain, map.get(coords.south())),
                equals(terrain, map.get(coords.east())),
                equals(terrain, map.get(coords.west())));

        return TerrainTileTypeList.singleton().getTile(terrain, direction);
    }

    private static boolean equals(Terrain terrain, Opt<Field> field) {
        return field.isPresent().isTrue() && field.get().getTerrain() == terrain;
    }
}
