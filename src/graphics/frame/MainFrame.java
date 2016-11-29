package graphics.frame;

import graphics.frame.constants.FrameConstants;
import utils.Opt;

import javax.swing.*;

public final class MainFrame extends JFrame {

    private static Opt<MainFrame> instance = Opt.empty();

    /* ========== SINGLETON FACTORY ========== */
    public static MainFrame singleton() {
        instance.ifNotPresent(() -> instance = Opt.of(new MainFrame()));
        return instance.get();
    }

    /* ========== CONSTRUCTOR ========== */
    private MainFrame() {
        initUI();
        initDrawPanel();
    }

    /* ========== PRIVATE ========== */
    private void initUI() {
        setTitle(FrameConstants.title);
        setSize(FrameConstants.frameWidth, FrameConstants.frameHeight);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    private void initDrawPanel() {
        add(DrawPanel.singleton());
        new Thread(FpsTimer.singleton()).start();
    }
}
