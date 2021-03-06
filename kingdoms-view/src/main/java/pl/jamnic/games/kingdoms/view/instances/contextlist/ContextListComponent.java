package pl.jamnic.games.kingdoms.view.instances.contextlist;

import pl.jamnic.games.kingdoms.uicomponents.components.GameGraphics;
import pl.jamnic.games.kingdoms.uicomponents.components.LabelComponent;
import pl.jamnic.games.kingdoms.uicomponents.setting.AbstractComponent;
import pl.jamnic.games.kingdoms.utils.points.Point;
import pl.jamnic.games.kingdoms.utils.points.Rect;
import utils.Opt;

import java.awt.*;

/**
 * Option list which appears when mouse-right mouse is detected. Contains various options.
 *
 * @author Janicki Dariusz
 */
public abstract class ContextListComponent extends AbstractComponent {

    private Opt<OptionList> options = Opt.empty();

    /* ========== CONSTRUCTOR ========== */
    public ContextListComponent(Rect rect) {
        super(rect);
    }

    /* ========== PUBLIC ========== */
    @Override
    public void draw(GameGraphics g) {
        updateRect(g);

        gameComponents.forEach(c -> c.draw(g));

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
            component.createClickMapper().copy(option.getClick());
            addComponent(component);
            point = point.add(Point.of(0, LabelComponent.HEIGHT_OFFSET));
        }
    }

    private void updateRect(GameGraphics g) {
        calculateMaxWidth(g);
        calculateMaxHeight();
    }

    private void calculateMaxWidth(GameGraphics g) {
        Opt.of(gameComponents.stream()
                .filter(c -> c instanceof OptionLabel)
                .map(c -> (OptionLabel) c)
                .map(c -> g.stringWidth(c.getText().get()))
                .max(Integer::compareTo))
                .ifPresent(w -> rect = rect.setWidth(w + 5));
    }

    private void calculateMaxHeight() {
        rect = rect.setHeight(Integer.valueOf(Long.toString(gameComponents.stream()
                .filter(c -> c instanceof OptionLabel)
                .count() * LabelComponent.HEIGHT_OFFSET)) + 5);
    }
}
