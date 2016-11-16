package graphics;

import graphics.frame.MainFrame;

import java.awt.*;

/**
 * Kingdoms game runner.
 */
public class GameRunner {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> MainFrame.singleton().setVisible(true));
    }
}
