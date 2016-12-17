package components.input.listener;

import components.input.key.GameKeyEvent;
import components.input.key.KeyFunctionMapper;
import lombok.Getter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Keyboard implements KeyListener {

    @Getter
    private KeyFunctionMapper keyMapping = KeyFunctionMapper.of();

    /* ========== PUBLIC ========== */
    @Override
    public void keyTyped(KeyEvent e) {
        keyMapping.press(new GameKeyEvent(e));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyMapping.press(new GameKeyEvent(e));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyMapping.press(new GameKeyEvent(e));
    }
}
