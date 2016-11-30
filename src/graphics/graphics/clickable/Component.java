package graphics.graphics.clickable;

import graphics.graphics.Drawable;
import graphics.graphics.details.model.ComponentModel;
import graphics.graphics.details.points.Rect;
import graphics.input.GameMouseEvent;
import lombok.Getter;
import utils.Bool;
import utils.Opt;

import java.util.function.Consumer;

public abstract class Component extends Drawable {

    protected ComponentModel model = ComponentModel.INSTANCE;
    protected Bool isVisible = Bool.TRUE;

    private Opt<Consumer<GameMouseEvent>> leftOnClick = Opt.empty();
    private Opt<Consumer<GameMouseEvent>> rightOnClick = Opt.empty();

    @Getter
    protected Rect rect;

    /* ========== CONSTRUCTOR ========== */
    public Component(Rect rect) {
        this.rect = rect;
    }

    /* ========== PUBLIC ========== */
    public Component getClickedComponent(GameMouseEvent event) {
        Opt<Component> first = Opt.of(components.stream()
                .filter(c -> c.rect.contains(event.getPoint()))
                .findFirst());

        return first.isPresent().isTrue()
                ? first.get().hasClickAction(event).or(first.get().getClickedComponent(event).hasClickAction(event)).isTrue()
                    ? first.get().getClickedComponent(event)
                    : this
                : this;
    }

    public void click(GameMouseEvent e) {
        e.isLeftClicked().ifTrue(() -> leftOnClick.ifPresent(c -> c.accept(e)));
        e.isRightClicked().ifTrue(() -> rightOnClick.ifPresent(c -> c.accept(e)));
    }

    public void add(Component component) {
        components.add(component);
    }

    public void show() {
        this.isVisible = Bool.TRUE;
    }

    public void hide() {
        this.isVisible = Bool.FALSE;
    }

    public void registerLeftMouseAction(Consumer<GameMouseEvent> functional) {
        this.leftOnClick = Opt.ofNullable(functional);
    }

    public void registerRightMouseAction(Consumer<GameMouseEvent> functional) {
        this.rightOnClick = Opt.ofNullable(functional);
    }

    private Bool hasClickAction(GameMouseEvent event) {
        return event.isRightClicked().and(rightOnClick.isPresent()).or(event.isLeftClicked().and(leftOnClick.isPresent()));
    }
}
