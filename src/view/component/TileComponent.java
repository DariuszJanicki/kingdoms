package view.component;

import engine.points.Rect;
import utils.Opt;
import view.component.setting.AbstractComponent;
import engine.model.Tickable;

public abstract class TileComponent<T extends Tickable> extends AbstractComponent {

    protected Opt<T> element = Opt.empty();

    public TileComponent(Rect rect) {
        super(rect);
    }

    public TileComponent setElement(T element) {
        this.element = Opt.ofNullable(element);
        return this;
    }


    @Override
    public void draw(GameGraphics g) {
        element.ifPresent(f -> draw(g, f));
    }

    @Override
    public void performTicks() {
        element.ifPresent(Tickable::tick);
    }

    protected abstract void draw(GameGraphics g, T t);

}
