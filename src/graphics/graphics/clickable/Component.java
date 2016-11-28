package graphics.graphics.clickable;

import graphics.graphics.Drawable;
import graphics.graphics.details.points.Point;
import graphics.graphics.details.points.Rect;
import graphics.graphics.details.model.ComponentModel;
import lombok.Getter;
import utils.Functional;
import utils.Opt;

import java.util.Optional;

public abstract class Component extends Drawable {

    protected ComponentModel model = ComponentModel.INSTANCE;
    private Opt<Functional> actionOnClick = Opt.empty();

    @Getter
    protected Rect rect;

    /* ========== CONSTRUCTOR ========== */
    public Component(Rect rect) {
        this.rect = rect;
    }

    /* ========== PUBLIC ========== */
    public Component getClickedComponent(Point point) {
        Optional<Component> first = components.stream()
                .filter(c -> c.rect.contains(point))
                .findFirst();

        return first.isPresent() ? first.get().getClickedComponent(point) : this;
    }

    public void click() {
        actionOnClick.ifPresent(Functional::execute);
    }

    public void add(Component component) {
        components.add(component);
    }

    /* ========== PROTECTED ========== */
    protected void registerMouseAction(Functional functional) {
        this.actionOnClick = Opt.ofNullable(functional);
    }
}
