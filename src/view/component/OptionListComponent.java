package view.component;

import view.interfaces.GameGraphics;
import view.interfaces.Option;
import view.interfaces.OptionList;
import view.component.setting.AbstractComponent;
import engine.points.Point;
import engine.points.Rect;
import view.instances.OptionLabel;
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
        updateRect(g);

        components.forEach(c -> c.draw(g));

        g.setColor(Color.white);
        g.draw(rect);
    }

    /* ========== PROTECTED ========== */
    protected void setOptions(OptionList options) {
        this.options = Opt.ofNullable(options);
        tryToAddOptions();
    }

    /* ========== PRIVATE ========== */
    private void tryToAddOptions() {
        if (options.isPresent().isTrue()) {
            addOptions();
        }
    }

    private void addOptions() {
        Point point = Point.of(0, 0);
        for (Option option : options.get().getOptions()) {
            OptionLabel component = new OptionLabel(rect.move(point).plus(Point.of(5, 0)), option);
            component.getClickFunctionMapper().copy(option.getClick());
            addComponent(component);
            point = point.add(Point.of(0, LabelComponent.HEIGHT_OFFSET));
        }
    }

    private void updateRect(GameGraphics g) {
        calculateMaxWidth(g);
        calculateMaxHeight();
    }

    private void calculateMaxWidth(GameGraphics g) {
        Opt.of(components.stream()
                .filter(c -> c instanceof OptionLabel)
                .map(c -> (OptionLabel) c)
                .map(c -> g.stringWidth(c.getText().get()))
                .max(Integer::compareTo))
                .ifPresent(w -> rect = rect.setWidth(w + 5));
    }

    private void calculateMaxHeight() {
        rect = rect.setHeight(Integer.valueOf(Long.toString(components.stream()
                .filter(c -> c instanceof OptionLabel)
                .count() * LabelComponent.HEIGHT_OFFSET)) + 5);
    }
}