package view.instances;

import engine.generator.BoardGenerator;
import engine.model.map.GameMap;
import engine.points.Rect;
import engine.points.Size;
import lombok.Getter;
import view.component.InfoComponent;
import view.component.InfoListComponent;
import view.component.setting.AbstractComponent;
import view.interfaces.GameGraphics;

public class MainComponent extends AbstractComponent {

    @Getter
    private BoardOfTiles board;

    /* ========== PUBLIC ========== */
    public MainComponent(Rect rect) {
        super(rect);

        leftMenu();
        bottomMenu();
        rightMenu();
        createBoard();
    }

    /* ========== PUBLIC ========== */
    @Override
    public void draw(GameGraphics g) {
    }

    /* ========== PRIVATE ========== */
    private void createBoard() {
        GameMap map = BoardGenerator.INSTANCE.generateMap(Size.of(40, 40));
        board = new BoardOfTiles(Rect.of(0, 0, 800, 640), map);
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
        menu.addComponent(new InfoComponent(Rect.of(440, 600, 960, 640), () -> model.getGameDate().toString()));
        menu.addComponent(new InfoComponent(Rect.of(760, 600, 960, 640), model::getFps));
    }

    private void leftMenu() {
        GameMenu menu = new GameMenu(Rect.of(0, 0, 32, 640));
        addComponent(menu);
    }
}
