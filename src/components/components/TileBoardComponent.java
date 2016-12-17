package components.components;

import constants.FrameConstants;
import utils.datastructure.GameArray;
import components.components.setting.AbstractComponent;
import utils.points.Coords;
import utils.points.Rect;
import utils.points.Size;
import lombok.Getter;

@Getter
public abstract class TileBoardComponent<T extends TileComponent> extends AbstractComponent {

    private GameArray<T> tiles;
    private Size boardSize;
    protected final BoardScreenMover boardScreenMover = new BoardScreenMover();

    /* ========== PUBLIC ========== */
    public TileBoardComponent(Rect rect) {
        super(rect);
        this.boardSize = rect.toSize().div(FrameConstants.baseTile);
        Size size = boardSize.add(3, 3);
        tiles = new GameArray<>(size, this::tileFactoryMethod);
    }

    @Override
    public void draw(GameGraphics g) {
        for (int i = -1; i <= boardSize.getX(); ++i) {
            for (int j = -1; j <= boardSize.getY(); ++j) {
                draw(g, new Coords(i, j));
            }
        }
    }

    /* ========== PROTECTED ========== */
    protected abstract void draw(GameGraphics g, Coords coords);

    protected abstract T tileFactoryMethod(Coords coords);
}
