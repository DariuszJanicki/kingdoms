package view.component.setting;

import engine.model.ComponentModel;
import engine.points.Rect;
import engine.points.Point;
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
        setBounds(rect.move(Point.of(-8, -16)).toRectangle());
        setVisible(true);
    }
}
