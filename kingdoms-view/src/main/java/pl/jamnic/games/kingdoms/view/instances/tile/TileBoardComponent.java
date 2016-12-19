package pl.jamnic.games.kingdoms.view.instances.tile;

import lombok.Getter;
import pl.jamnic.games.kingdoms.constants.FrameConstants;
import pl.jamnic.games.kingdoms.uicomponents.components.BoardScreenMover;
import pl.jamnic.games.kingdoms.uicomponents.components.GameGraphics;
import pl.jamnic.games.kingdoms.uicomponents.setting.AbstractComponent;
import pl.jamnic.games.kingdoms.utils.datastructure.GameArray;
import pl.jamnic.games.kingdoms.utils.points.Coords;
import pl.jamnic.games.kingdoms.utils.points.Rect;
import pl.jamnic.games.kingdoms.utils.points.Size;

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
