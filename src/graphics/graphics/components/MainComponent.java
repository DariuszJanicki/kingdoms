package graphics.graphics.components;

import graphics.frame.constants.FrameConstants;
import graphics.graphics.GameGraphics;
import graphics.graphics.Rect;
import graphics.graphics.clickable.Component;
import graphics.graphics.details.Coords;
import graphics.graphics.details.Size;
import graphics.graphics.details.generator.BoardGenerator;
import graphics.graphics.details.model.board.Board;
import lombok.Getter;

public class MainComponent extends Component {

    @Getter
    private Board board;
    private GameMenu menu;

    /* ========== PUBLIC ========== */
    public MainComponent(Rect rect) {
        super(rect);

        createBoard();
        createMenu();
    }

    /* ========== PUBLIC ========== */
    @Override
    public void draw(GameGraphics g) {
        board.draw(g);
        menu.draw(g);
    }

    /* ========== PRIVATE ========== */
    private void createBoard() {
        int a = FrameConstants.baseTile;

        board = new Board(
                new Rect(a * 5, a * 0, a * 30, a * 20),
                BoardGenerator.INSTANCE.generateMap(new Size(100, 100)),
                new Coords(0, 0));

        registerComponent(board);
    }

    private void createMenu() {
        int a = FrameConstants.baseTile;

        menu = new GameMenu(new Rect(a * 0, a * 0, a * 5, a * 20));

        registerComponent(menu);
    }
}
