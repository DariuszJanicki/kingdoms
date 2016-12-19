package pl.jamnic.games.kingdoms.uicomponents.setting;

import lombok.Getter;
import lombok.Setter;
import pl.jamnic.games.kingdoms.uicomponents.components.ComponentModel;
import pl.jamnic.games.kingdoms.utils.points.Point;
import pl.jamnic.games.kingdoms.utils.points.Rect;

import java.awt.*;

@Setter
@Getter
abstract class Rectangular extends Container {

    /* ========== STATIC ========== */
    protected final static ComponentModel model = ComponentModel.INSTANCE;

    /* ========== PROTECTED ========== */
    protected Rect rect;

    Rectangular(Rect rect) {
        this.rect = rect;
        setBounds(rect.move(Point.of(-4, -16)).toRectangle());
        setVisible(true);
    }
}
