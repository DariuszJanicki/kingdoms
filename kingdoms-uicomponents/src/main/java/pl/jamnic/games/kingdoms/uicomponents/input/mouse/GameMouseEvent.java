package pl.jamnic.games.kingdoms.uicomponents.input.mouse;

import pl.jamnic.games.kingdoms.utils.points.Point;
import lombok.Getter;
import utils.Opt;

import java.awt.event.MouseEvent;

@Getter
public final class GameMouseEvent {

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
