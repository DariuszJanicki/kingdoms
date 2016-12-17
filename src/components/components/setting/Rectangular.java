package components.components.setting;

import engine.ComponentModel;
import utils.points.Rect;
import utils.points.Point;
import lombok.Getter;
import lombok.Setter;

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
