package view.component.setting;

import engine.points.Rect;
import utils.Bool;
import view.component.GameGraphics;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractComponent extends Clickable {

    /* ========== CONSTRUCTOR ========== */
    public AbstractComponent(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    public void preDraw(GameGraphics g) {
        gameComponents.addAll(newComponents);

        newComponents.forEach(this::add);

        newComponents.clear();
        gameComponents.removeAll(componentsToRemove);
        componentsToRemove.clear();
        draw(g);
        gameComponents.forEach(c -> c.preDraw(g));
    }

    public void preTick() {
        performTicks();
        gameComponents.forEach(Clickable::performTicks);
    }

    public void addComponent(AbstractComponent component) {
        newComponents.add(component);
    }

    public Bool isTemporary() {
        return Bool.FALSE;
    }

    /* ========== PROTECTED ========== */
    protected List<AbstractComponent> gameComponents = new ArrayList<>();
    protected List<AbstractComponent> componentsToRemove = new ArrayList<>();

    /* ========== PRIVATE ========== */
    private List<AbstractComponent> newComponents = new ArrayList<>();
}