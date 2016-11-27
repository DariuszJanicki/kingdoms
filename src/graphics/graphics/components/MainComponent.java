package graphics.graphics.components;

import graphics.graphics.GameGraphics;
import graphics.graphics.Rect;
import graphics.graphics.clickable.Component;
import graphics.graphics.details.Size;
import graphics.graphics.details.generator.BoardGenerator;
import graphics.graphics.details.model.board.Board;
import graphics.graphics.details.model.map.GameMap;
import lombok.Getter;

public class MainComponent extends Component {

    @Getter
    private Board board;

    /* ========== PUBLIC ========== */
    public MainComponent(Rect rect) {
        super(rect);

        createBoard();
        createMenu();
    }

    /* ========== PUBLIC ========== */
    @Override
    public void draw(GameGraphics g) {
    }

    /* ========== PRIVATE ========== */
    private void createBoard() {
        GameMap map = BoardGenerator.INSTANCE.generateMap(new Size(40, 40));
        board = new Board(Rect.of(160, 0, 960, 640), map);
        add(board);
    }

    private void createMenu() {
        GameMenu menu = new GameMenu(Rect.of(0, 32, 192, 640));
        add(menu);
        menu.add(new TextLabelComponent(Rect.of(0, 32, 96, 96)));

        add(new GameMenu(Rect.of(0, 0, 960, 32)));
    }
}
