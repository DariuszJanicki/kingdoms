package components.input.listener;

import lombok.Getter;
import components.input.mouse.MouseFunctionMapper;
import components.input.mouse.GameMouseEvent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public final class Mouse implements MouseListener {

    @Getter
    private MouseFunctionMapper mouseMapping = MouseFunctionMapper.of();

    /* ========== PUBLIC ========== */
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseMapping.click(new GameMouseEvent(e));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseMapping.click(new GameMouseEvent(e));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseMapping.click(new GameMouseEvent(e));
    }
}
