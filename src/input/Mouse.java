package input;

import view.interfaces.ClickFunction;
import view.interfaces.HoverFunction;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public final class Mouse implements MouseListener {

    private ClickFunction click = new ClickFunction();
    private HoverFunction hover = new HoverFunction();

    /* ========== PUBLIC ========== */
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        click.click(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        hover.hover(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        hover.hoverOff(e);
    }

    public void setClickFunction(ClickFunction click) {
        this.click = click;
    }

    public void setHoverFunction(HoverFunction hover) {
        this.hover = hover;
    }
}
