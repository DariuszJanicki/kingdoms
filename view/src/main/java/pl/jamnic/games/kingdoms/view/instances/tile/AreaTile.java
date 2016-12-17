package pl.jamnic.games.kingdoms.view.instances.tile;

import lombok.Setter;
import pl.jamnic.games.kingdoms.model.model.map.Area;
import pl.jamnic.games.kingdoms.model.model.map.GameMap;
import pl.jamnic.games.kingdoms.uicomponents.components.GameGraphics;
import pl.jamnic.games.kingdoms.uicomponents.input.mouse.MouseAction;
import pl.jamnic.games.kingdoms.utils.points.Rect;
import pl.jamnic.games.kingdoms.view.drawer.AreaDrawer;
import utils.Bool;
import utils.Opt;

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