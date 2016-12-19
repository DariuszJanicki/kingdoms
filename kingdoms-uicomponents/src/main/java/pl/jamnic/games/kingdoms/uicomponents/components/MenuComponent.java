package pl.jamnic.games.kingdoms.uicomponents.components;

import pl.jamnic.games.kingdoms.uicomponents.setting.AbstractComponent;
import pl.jamnic.games.kingdoms.utils.points.Rect;

import java.awt.*;

/**
 * Place for any other pl.jamnic.games.kingdoms.uicomponents.components.pl.jamnic.games.kingdoms.uicomponents.components.component.
 *
 * @author Janicki Dariusz
 */
public abstract class MenuComponent extends AbstractComponent {

    /* ========== CONSTRUCTOR ========== */
    public MenuComponent(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    @Override
    public void draw(GameGraphics g) {
        g.setColor(Color.white);
        g.draw(rect);
    }
}
