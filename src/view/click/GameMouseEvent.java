package view.click;

import engine.points.Point;
import lombok.Getter;
import utils.Opt;

import java.awt.event.MouseEvent;

@Getter
public class GameMouseEvent {

    private MouseEvent event;
    private Opt<MouseAction> action = Opt.empty();

    /* ========== PUBLIC ========== */
    public GameMouseEvent(MouseEvent event) {
        event.getID();
        this.event = event;
        this.action = MouseAction.of(event);
    }

    public Point getPoint() {
        return Point.of(event.getPoint());
    }
}
