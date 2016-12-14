package view.instances;

import engine.model.field.Area;
import engine.model.map.GameMap;
import engine.points.Point;
import engine.points.Rect;
import lombok.Setter;
import utils.Bool;
import view.click.MouseAction;
import view.component.TileComponent;
import view.drawer.AreaDrawer;
import view.interfaces.GameGraphics;

import java.awt.*;

final class AreaTile extends TileComponent<Area> {

    @Setter
    private Point delta;
    private Bool highlight = Bool.FALSE;
    @Setter
    private GameMap<Area> map;

    /* ========== DEFAULT ========== */
    AreaTile(Rect rect) {
        super(rect);
        getClickFunctionMapper()
                .register(MouseAction.HOVER, g -> highlight = Bool.TRUE)
                .register(MouseAction.HOVER_EXIT, g -> highlight = Bool.FALSE);
    }

    /* ========== PUBLIC ========== */
    public void draw(GameGraphics g, Area area) {
        AreaDrawer.draw(g, area, map, rect, delta);

        highlight.ifTrue(() -> {
            g.setColor(new Color(255, 255, 255, 200));
            g.draw(rect.move(this.delta));
        });
    }
}