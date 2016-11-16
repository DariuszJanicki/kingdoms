package graphics.input;

import graphics.frame.DrawPanel;
import graphics.graphics.Point;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {

    /* ========== PUBLIC ========== */
    @Override
    public void mouseClicked(MouseEvent e) {
        click(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    /* ========== PRIVATE ========== */
    private void click(MouseEvent e) {
        DrawPanel.singleton()
                .getMainComponent()
                .getClickedComponent(new Point(e.getX(), e.getY())).click();
    }
}
