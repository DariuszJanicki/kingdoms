package view.component;

import base.frame.constants.FrameConstants;
import engine.points.Coords;
import engine.points.Rect;
import engine.points.Size;
import lombok.Getter;
import view.component.setting.AbstractComponent;
import view.instances.TileArray;
import view.interfaces.GameGraphics;

@Getter
public abstract class TileBoardComponent extends AbstractComponent {

    private TileArray tiles;
    private Size boardSize;

    /* ========== PUBLIC ========== */
    public TileBoardComponent(Rect rect) {
        super(rect);
        this.boardSize = rect.toSize().div(FrameConstants.baseTile);
        tiles = new TileArray(boardSize.add(3, 3), this);
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
}
