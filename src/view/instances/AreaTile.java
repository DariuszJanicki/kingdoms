package view.instances;

import engine.model.map.GameMap;
import engine.model.map.Area;
import engine.points.Rect;
import lombok.Setter;
import utils.Bool;
import utils.Opt;
import view.click.MouseAction;
import view.component.GameGraphics;
import view.component.TileComponent;
import view.drawer.AreaDrawer;

final class AreaTile extends TileComponent<Area> {

    @Setter
    private Opt<GameMap<Area>> map = Opt.empty();

    /* ========== PUBLIC ========== */
    public AreaTile(Rect rect) {
        super(rect);
        getClickFunctionMapper()
                .register(MouseAction.HOVER, g -> highlight = Bool.TRUE)
                .register(MouseAction.HOVER_EXIT, g -> highlight = Bool.FALSE);
    }

    public void draw(GameGraphics g, Area area) {
        map.ifPresent(map -> AreaDrawer.draw(g, area, map, rect, delta));
        highlight(g);
    }
}