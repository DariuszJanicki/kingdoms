package pl.jamnic.games.kingdoms.view.drawer;

import lombok.Getter;
import lombok.Setter;
import pl.jamnic.games.kingdoms.model.loader.Direction;
import pl.jamnic.games.kingdoms.model.loader.tile.TerrainTileType;
import pl.jamnic.games.kingdoms.model.loader.tile.list.TerrainTileTypeList;
import pl.jamnic.games.kingdoms.model.model.map.Field;
import pl.jamnic.games.kingdoms.model.model.map.GameMap;
import pl.jamnic.games.kingdoms.model.model.terrain.TerrainType;
import pl.jamnic.games.kingdoms.uicomponents.components.GameGraphics;
import pl.jamnic.games.kingdoms.utils.points.Coords;
import pl.jamnic.games.kingdoms.utils.points.Point;
import pl.jamnic.games.kingdoms.utils.points.Rect;
import utils.Opt;

@Setter
@Getter
public class FieldDrawer extends AbstractDrawer<Field> {

    public static void draw(GameGraphics g, Field wrapper, GameMap<Field> map, Rect rect, Point delta) {
        g.draw(setTerrainTile(map, wrapper).getImage(), rect.move(delta));
        wrapper.getSettlement().ifPresent(s -> SettlementDrawer.draw(g, s, rect, delta));
    }

    private static TerrainTileType setTerrainTile(GameMap<Field> map, Field field) {
        TerrainType terrain = field.getTerrain();
        Coords coords = field.getCoords();

        Direction direction = Direction.getDirection(
                equals(terrain, map.get(coords.north())),
                equals(terrain, map.get(coords.south())),
                equals(terrain, map.get(coords.east())),
                equals(terrain, map.get(coords.west())));

        return TerrainTileTypeList.singleton().getTile(terrain, direction);
    }

    private static boolean equals(TerrainType terrain, Opt<Field> field) {
        return field.isPresent().isTrue() && field.get().getTerrain() == terrain;
    }
}
