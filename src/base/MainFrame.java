package base;

import constants.FrameConstants;
import utils.points.Rect;
import lombok.Getter;
import utils.Opt;
import view.instances.MainComponent;
import components.components.GameGraphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

import static constants.FrameConstants.frameHeight;
import static constants.FrameConstants.frameWidth;

public final class MainFrame extends JFrame {

    @Getter
    private MainComponent mainComponent;
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

    /* ========== PROTECTED ========== */
    void draw() {
        BufferStrategy strategy = getBufferStrategy();

        if (strategy == null) {
            createBufferStrategy(2);
            return;
        }

        drawGraphics(strategy.getDrawGraphics());
        strategy.show();
    }

    void tick() {
        mainComponent.preTick();
    }

    /* ========== PRIVATE ========== */
    private void initUI() {
        setTitle(FrameConstants.title);
        setSize(frameWidth, frameHeight);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    private void initDrawPanel() {
        add(mainComponent = new MainComponent(Rect.of(0, 0, frameWidth, frameHeight)));
        new Thread(FpsTimer.singleton()).start();
    }

    private void drawGraphics(Graphics graphics) {
        GameGraphics g = new GameGraphics(graphics);
        mainComponent.preDraw(g);
        g.dispose();
    }
}
