package base;

import base.frame.MainFrame;

import java.awt.*;

/**
 * Kingdoms game runner.
 */
public class GameRunner {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> MainFrame.singleton().setVisible(true));
    }
}
