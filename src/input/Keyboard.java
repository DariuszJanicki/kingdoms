package input;

import base.frame.MainFrame;
import engine.points.Coords;
import utils.Functional;
import view.instances.MapInTileBoard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public final class Keyboard implements KeyListener {

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
        MapInTileBoard board = MainFrame.singleton().getMainComponent().getBoard();
        board.setDestinationView(Coords.toNorth());
    }

    private void down() {
        MapInTileBoard board = MainFrame.singleton().getMainComponent().getBoard();
        board.setDestinationView(Coords.toSouth());
    }

    private void right() {
        MapInTileBoard board = MainFrame.singleton().getMainComponent().getBoard();
        board.setDestinationView(Coords.toEast());
    }

    private void left() {
        MapInTileBoard board = MainFrame.singleton().getMainComponent().getBoard();
        board.setDestinationView(Coords.toWest());
    }
}
