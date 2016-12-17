package view.instances.tile;

import engine.model.map.Area;
import engine.model.map.GameMap;
import utils.points.Rect;
import lombok.Setter;
import utils.Bool;
import utils.Opt;
import components.input.mouse.MouseAction;
import components.components.GameGraphics;
import components.components.TileComponent;
import view.drawer.AreaDrawer;

final class AreaTile extends TileComponent<Area> {

    @Setter
    private Opt<GameMap<Area>> map = Opt.empty();

    /* ========== PUBLIC ========== */
    public AreaTile(Rect rect) {
        super(rect);
        createClickMapper()
                .register(MouseAction.LEFT_CLICK, g -> System.out.println("LEFT"))
                .register(MouseAction.RIGHT_CLICK, g -> System.out.println("RIGHT"))
                .register(MouseAction.HOVER, g -> highlight = Bool.TRUE)
                .register(MouseAction.HOVER_EXIT, g -> highlight = Bool.FALSE);
    }

    public void draw(GameGraphics g) {
        map.isPresent()
                .and(element.isPresent())
                .ifTrue(() -> AreaDrawer.draw(g, element.get(), map.get(), rect, delta));
        highlight(g);
    }
}