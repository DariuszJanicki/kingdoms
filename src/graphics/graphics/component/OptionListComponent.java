package graphics.graphics.component;

import graphics.graphics.GameGraphics;
import graphics.graphics.Option;
import graphics.graphics.OptionList;
import graphics.graphics.component.setting.AbstractComponent;
import graphics.graphics.details.points.Point;
import graphics.graphics.details.points.Rect;
import graphics.graphics.instances.OptionLabel;
import utils.Opt;

import java.awt.*;

/**
 * Option list which appears when mouse-right click is detected. Contains various options.
 *
 * @author Janicki Dariusz
 */
public abstract class OptionListComponent extends AbstractComponent {

    private Opt<OptionList> options = Opt.empty();

    /* ========== CONSTRUCTOR ========== */
    public OptionListComponent(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    @Override
    public void draw(GameGraphics g) {
        Opt<Integer> maxWidth = Opt.of(components.stream()
                .filter(c -> c instanceof OptionLabel)
                .map(c -> (OptionLabel) c)
                .map(c -> g.stringWidth(c.getText().get()))
                .max(Integer::compareTo));

        if (maxWidth.isPresent().isTrue()) {
            rect = rect.setWidth(maxWidth.get());
        }

        components.forEach(c -> c.draw(g));

        g.setColor(Color.white);
        g.draw(rect);
    }

    /* ========== PROTECTED ========== */
    protected void setOptions(OptionList options) {
        this.options = Opt.ofNullable(options);
        tryToAddOptions();
        rect = rect.setHeight(calculateListHeight() + 5);
    }

    /* ========== PRIVATE ========== */
    private void tryToAddOptions() {
        if (options.isPresent().isTrue()) {
            addOptions();
        }
    }

    private void addOptions() {
        Point point = Point.of(-10, 0);
        for (Option option : options.get().getOptions()) {
            OptionLabel component = new OptionLabel(rect.move(point).plus(Point.of(5, 0)), option);
            component.registerLeftMouseAction((event) -> System.out.println(option.getValue()));
            component.registerRightMouseAction((event) -> System.out.println(option.getValue()));
            addComponent(component);
            point = point.add(Point.of(0, LabelComponent.HEIGHT_OFFSET));
        }
    }

    private Integer calculateListHeight() {
        return Integer.valueOf(Long.toString(components.stream()
                .filter(c -> c instanceof OptionLabel)
                .count() * LabelComponent.HEIGHT_OFFSET));
    }
}
