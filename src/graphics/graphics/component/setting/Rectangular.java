package graphics.graphics.component.setting;

import graphics.graphics.details.model.ComponentModel;
import graphics.graphics.details.points.Rect;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
abstract class Rectangular {

    /* ========== STATIC ========== */
    protected final static ComponentModel model = ComponentModel.INSTANCE;

    /* ========== PROTECTED ========== */
    protected Rect rect;
}
