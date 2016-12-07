package graphics.input;

import graphics.frame.DrawPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {

    /* ========== PUBLIC ========== */
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        click(GameMouseEvent.of(e));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        hover(GameMouseEvent.of(e));
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    /* ========== PRIVATE ========== */
    private void click(GameMouseEvent e) {
        DrawPanel.singleton()
                .getMainComponent()
                .getClicked(e)
                .click(e);
    }

    private void hover(GameMouseEvent e) {
        DrawPanel.singleton()
                .getMainComponent()
                .getHovered(e)
                .hover(e);
    }
}
