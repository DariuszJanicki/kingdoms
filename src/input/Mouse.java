package input;

import lombok.Getter;
import view.click.ClickFunctionMapper;
import view.click.GameMouseEvent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public final class Mouse implements MouseListener {

    @Getter
    private ClickFunctionMapper clickFunctionMapper = ClickFunctionMapper.of();

    /* ========== PUBLIC ========== */
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        clickFunctionMapper.click(new GameMouseEvent(e));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        clickFunctionMapper.click(new GameMouseEvent(e));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        clickFunctionMapper.click(new GameMouseEvent(e));
    }
}
