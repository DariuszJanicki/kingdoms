package graphics.graphics.component.setting;

import graphics.graphics.GameGraphics;
import graphics.graphics.details.points.Rect;
import graphics.input.GameMouseEvent;
import utils.Opt;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractComponent extends Clickable {

    /* ========== CONSTRUCTOR ========== */
    public AbstractComponent(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    public AbstractComponent getClicked(GameMouseEvent event) {
        return getClicked(event, getClickedSubComponent(event));
    }

    public void addComponent(AbstractComponent component) {
        components.add(0, component);
    }

    public void preDraw(GameGraphics g) {
        draw(g);
        components.forEach(c -> c.preDraw(g));
    }

    public void preTick() {
        tick();
        components.forEach(Clickable::tick);
    }

    /* ========== PROTECTED ========== */
    protected List<AbstractComponent> components = new ArrayList<>();

    /* ========== PRIVATE ========== */
    private Opt<AbstractComponent> getClickedSubComponent(GameMouseEvent event) {
        return Opt.of(components.stream()
                .filter(c -> c.rect.contains(event.getPoint()))
                .findFirst());
    }

    private AbstractComponent getClicked(GameMouseEvent event, Opt<AbstractComponent> component) {
        return component.isPresent().isTrue()
                ? getClickedFirst(event, component.get())
                : this;
    }

    private AbstractComponent getClickedFirst(GameMouseEvent event, AbstractComponent component) {
        return component.hasAction(event).or(component.getClicked(event).hasAction(event)).isTrue()
                ? component.getClicked(event)
                : this;
    }
}
