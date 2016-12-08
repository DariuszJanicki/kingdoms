package view.component.setting;

import engine.points.Rect;
import view.interfaces.GameGraphics;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractComponent extends Clickable {

    /* ========== CONSTRUCTOR ========== */
    public AbstractComponent(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    public void addComponent(AbstractComponent component) {
        newComponents.add(0, component);
    }

    public void preDraw(GameGraphics g) {
        components.addAll(newComponents);

        newComponents.forEach(this::add);

        newComponents.clear();
        components.removeAll(componentsToRemove);
        componentsToRemove.clear();
        draw(g);
        components.forEach(c -> c.preDraw(g));
    }

    public void preTick() {
        tick();
        components.forEach(Clickable::tick);
    }

    /* ========== PROTECTED ========== */
    protected List<AbstractComponent> components = new ArrayList<>();
    protected List<AbstractComponent> newComponents = new ArrayList<>();
    protected List<AbstractComponent> componentsToRemove = new ArrayList<>();
}
