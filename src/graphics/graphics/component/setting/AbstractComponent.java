package graphics.graphics.component.setting;

import graphics.graphics.GameGraphics;
import graphics.graphics.details.points.Rect;
import graphics.input.GameMouseEvent;
import lombok.val;
import utils.Opt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractComponent extends Hoverable {

    /* ========== CONSTRUCTOR ========== */
    public AbstractComponent(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    public AbstractComponent getClicked(GameMouseEvent event) {
        return getClicked(event, getClickedSubComponent(event));
    }

    public AbstractComponent getHovered(GameMouseEvent event) {
        return getHovered(event, getHoveredSubComponent(event));
    }

    public void addComponent(AbstractComponent component) {
        newComponents.add(0, component);
    }

    public void preDraw(GameGraphics g) {
        components.addAll(newComponents);
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

    /* ========== PRIVATE ========== */
    private Opt<AbstractComponent> getClickedSubComponent(GameMouseEvent event) {
        return Opt.of(components.stream()
                .filter(c -> c.rect.contains(event.getPoint()))
                .findFirst());
    }

    private Opt<AbstractComponent> getHoveredSubComponent(GameMouseEvent event) {
        val reversed = new ArrayList<AbstractComponent>(components);
        Collections.reverse(reversed);

        return Opt.of(reversed.stream()
                .filter(c -> c.rect.contains(event.getPoint()))
                .findFirst());
    }

    private AbstractComponent getClicked(GameMouseEvent event, Opt<AbstractComponent> component) {
        return component.isPresent().isTrue()
                ? getClickedFirst(event, component.get())
                : this;
    }

    private AbstractComponent getHovered(GameMouseEvent event, Opt<AbstractComponent> component) {
        return component.isPresent().isTrue()
                ? getHoveredFirst(event, component.get())
                : this;
    }

    private AbstractComponent getClickedFirst(GameMouseEvent event, AbstractComponent component) {
        return component.hasAction(event).or(component.getClicked(event).hasAction(event)).isTrue()
                ? component.getClicked(event)
                : this;
    }

    private AbstractComponent getHoveredFirst(GameMouseEvent event, AbstractComponent component) {
        return component.hasHover(event).or(component.getHovered(event).hasHover(event)).isTrue()
                ? component.getHovered(event)
                : this;
    }
}
