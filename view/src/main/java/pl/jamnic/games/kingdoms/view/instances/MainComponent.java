package pl.jamnic.games.kingdoms.view.instances;

import lombok.Getter;
import pl.jamnic.games.kingdoms.date.Timer;
import pl.jamnic.games.kingdoms.model.generator.BoardGenerator;
import pl.jamnic.games.kingdoms.model.model.map.Field;
import pl.jamnic.games.kingdoms.model.model.map.GameMap;
import pl.jamnic.games.kingdoms.uicomponents.components.GameGraphics;
import pl.jamnic.games.kingdoms.uicomponents.components.InfoComponent;
import pl.jamnic.games.kingdoms.uicomponents.components.InfoListComponent;
import pl.jamnic.games.kingdoms.uicomponents.setting.AbstractComponent;
import pl.jamnic.games.kingdoms.utils.points.Rect;
import pl.jamnic.games.kingdoms.utils.points.Size;
import pl.jamnic.games.kingdoms.view.instances.tile.FieldTileBoard;

public final class MainComponent extends AbstractComponent {

    @Getter
    private FieldTileBoard board;

    /* ========== PUBLIC ========== */
    public MainComponent(Rect rect) {
        super(rect);
        createBoard();
        rightMenu();
        bottomMenu();
        leftMenu();
    }

    @Override
    public void draw(GameGraphics g) {
    }

    /* ========== PRIVATE ========== */
    private void createBoard() {
        GameMap<Field> map = BoardGenerator.INSTANCE.generateMap(Size.of(40, 40));
        board = new FieldTileBoard(Rect.of(0, 0, 800, 640), map);
        addComponent(board);
    }

    private void rightMenu() {
        GameMenu menu = new GameMenu(Rect.of(800, 32, 960, 640));
        addComponent(menu);
        menu.addComponent(new InfoComponent(Rect.of(800, 32, 960, 96), model::getCurrentTileInfo));
        menu.addComponent(new InfoListComponent(Rect.of(800, 64, 960, 180), model::getVillagers));
    }

    private void bottomMenu() {
        GameMenu menu = new GameMenu(Rect.of(0, 600, 960, 640));
        addComponent(menu);
        menu.addComponent(new InfoComponent(Rect.of(440, 600, 960, 640), () -> Timer.getSingleton().getTime().toString()));
        menu.addComponent(new InfoComponent(Rect.of(760, 600, 960, 640), model::getFps));
    }

    private void leftMenu() {
        GameMenu menu = new GameMenu(Rect.of(0, 0, 32, 640));
        addComponent(menu);
    }
}
