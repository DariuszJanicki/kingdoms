package graphics.graphics.instances;

import graphics.graphics.GameGraphics;
import graphics.graphics.component.InfoComponent;
import graphics.graphics.component.InfoListComponent;
import graphics.graphics.component.setting.AbstractComponent;
import graphics.graphics.details.generator.BoardGenerator;
import graphics.graphics.details.model.map.GameMap;
import graphics.graphics.details.points.Rect;
import graphics.graphics.details.points.Size;
import graphics.input.GameMouseEvent;
import lombok.Getter;

public class MainComponent extends AbstractComponent {

    @Getter
    private BoardOfTiles board;

    /* ========== PUBLIC ========== */
    public MainComponent(Rect rect) {
        super(rect);

        upMenu();
        leftMenu();
        createBoard();
    }

    /* ========== PUBLIC ========== */
    @Override
    public void draw(GameGraphics g) {
    }

    @Override
    public void click(GameMouseEvent e) {
        components.forEach(c -> c.click(e));
    }

    /* ========== PRIVATE ========== */
    private void createBoard() {
        GameMap map = BoardGenerator.INSTANCE.generateMap(Size.of(40, 40));
        board = new BoardOfTiles(Rect.of(160, 0, 960, 640), map);
        addComponent(board);
    }

    private void leftMenu() {
        GameMenu menu = new GameMenu(Rect.of(0, 32, 192, 640));
        addComponent(menu);
        menu.addComponent(new InfoComponent(Rect.of(0, 32, 96, 96), model::getCurrentTileInfo));
        menu.addComponent(new InfoListComponent(Rect.of(0, 64, 96, 180), model::getVillagers));
    }

    private void upMenu() {
        GameMenu menu = new GameMenu(Rect.of(0, 0, 960, 32));
        addComponent(menu);
        menu.addComponent(new InfoComponent(Rect.of(440, 0, 960, 32), () -> model.getGameDate().toString()));
        menu.addComponent(new InfoComponent(Rect.of(760, 0, 960, 32), model::getFps));
    }
}
