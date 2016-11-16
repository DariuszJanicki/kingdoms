package graphics.graphics.clickable;

import graphics.graphics.Drawable;
import graphics.graphics.Point;
import graphics.graphics.Rect;
import utils.Functional;
import utils.Opt;

import java.util.Optional;

public abstract class Component extends Drawable {

    private Opt<Functional> actionOnClick = Opt.empty();
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

    public void registerComponent(Component component) {
        components.add(component);
    }

    public void registerMouseAction(Functional functional) {
        this.actionOnClick = Opt.ofNullable(functional);
    }

    public void click() {
        System.out.println(this);
        actionOnClick.ifPresent(Functional::execute);
    }

    /* ========== PRIVATE ========== */
}
