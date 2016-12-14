package base.frame;

import base.frame.constants.FrameConstants;
import engine.points.Rect;
import input.Keyboard;
import lombok.Getter;
import utils.Opt;
import view.instances.MainComponent;
import view.component.GameGraphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

import static base.frame.constants.FrameConstants.frameHeight;
import static base.frame.constants.FrameConstants.frameWidth;

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

    /* ========== PRIVATE ========== */
    private void initUI() {
        setTitle(FrameConstants.title);
        setSize(frameWidth, frameHeight);

        addKeyListener(new Keyboard());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    private void initDrawPanel() {
        add(mainComponent = new MainComponent(Rect.of(0, 0, frameWidth, frameHeight)));
        new Thread(FpsTimer.singleton()).start();
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
    private void drawGraphics(Graphics graphics) {
        GameGraphics g = new GameGraphics(graphics);
        mainComponent.preDraw(g);
        g.dispose();
    }
}
