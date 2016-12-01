package graphics.graphics.instances;

import graphics.graphics.GameGraphics;
import graphics.graphics.clickable.Component;
import graphics.graphics.details.generator.BoardGenerator;
import graphics.graphics.details.model.board.Board;
import graphics.graphics.details.model.map.GameMap;
import graphics.graphics.details.points.Rect;
import graphics.graphics.details.points.Size;
import graphics.input.GameMouseEvent;
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

    @Override
    public void click(GameMouseEvent e) {
        components.forEach(c -> c.click(e));
    }

    /* ========== PRIVATE ========== */
    private void createBoard() {
        GameMap map = BoardGenerator.INSTANCE.generateMap(Size.of(40, 40));
        board = new Board(Rect.of(160, 0, 960, 640), map);
        add(board);
    }

    private void createMenu() {
        GameMenu menu = new GameMenu(Rect.of(0, 32, 192, 640));
        add(menu);
        menu.add(new TileInfo(Rect.of(0, 32, 96, 96)));

        add(new GameMenu(Rect.of(0, 0, 960, 32)));
    }
}
