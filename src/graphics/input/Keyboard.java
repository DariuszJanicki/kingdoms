package graphics.input;

import graphics.frame.DrawPanel;
import graphics.graphics.details.model.board.Board;
import utils.Functional;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class Keyboard implements KeyListener {

    private Map<Integer, Functional> keyMapping = new HashMap<>();

    /* ========== CONSTRUCTOR ========== */
    public Keyboard() {
        registerKey(38, this::up);
        registerKey(40, this::down);
        registerKey(39, this::right);
        registerKey(37, this::left);
    }

    /* ========== PUBLIC ========== */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Functional functional = keyMapping.get(e.getKeyCode());

        if (functional != null) {
            functional.execute();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /* ========== PRIVATE ========== */
    private void registerKey(int keyCode, Functional function) {
        keyMapping.put(keyCode, function);
    }

    private void up() {
        Board board = DrawPanel.singleton().getMainComponent().getBoard();
        board.setCurrentLocation(board.getCurrentLocation().north());
    }

    private void down() {
        Board board = DrawPanel.singleton().getMainComponent().getBoard();
        board.setCurrentLocation(board.getCurrentLocation().south());
    }

    private void right() {
        Board board = DrawPanel.singleton().getMainComponent().getBoard();
        board.setCurrentLocation(board.getCurrentLocation().east());
    }

    private void left() {
        Board board = DrawPanel.singleton().getMainComponent().getBoard();
        board.setCurrentLocation(board.getCurrentLocation().west());
    }
}
