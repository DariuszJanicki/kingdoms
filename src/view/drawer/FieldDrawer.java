package view.drawer;

import engine.model.map.MapArea;
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
public class FieldDrawer extends AbstractDrawer<MapArea> {

    public static void draw(GameGraphics g, MapArea wrapper, GameMap<MapArea> map, Rect rect, Point delta) {
        g.draw(setTerrainTile(map, wrapper).getImage(), rect.move(delta));
        wrapper.getSettlement().ifPresent(s -> SettlementDrawer.draw(g, s, rect, delta));
    }

    private static TerrainTileType setTerrainTile(GameMap<MapArea> map, MapArea mapArea) {
        TerrainType terrain = mapArea.getTerrain();
        Coords coords = mapArea.getCoords();

        Direction direction = Direction.getDirection(
                equals(terrain, map.get(coords.north())),
                equals(terrain, map.get(coords.south())),
                equals(terrain, map.get(coords.east())),
                equals(terrain, map.get(coords.west())));

        return TerrainTileTypeList.singleton().getTile(terrain, direction);
    }

    private static boolean equals(TerrainType terrain, Opt<MapArea> field) {
        return field.isPresent().isTrue() && field.get().getTerrain() == terrain;
    }
}
