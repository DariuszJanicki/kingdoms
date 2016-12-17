package pl.jamnic.games.kingdoms.base;

import lombok.Getter;
import pl.jamnic.games.kingdoms.constants.FrameConstants;
import pl.jamnic.games.kingdoms.uicomponents.components.GameGraphics;
import pl.jamnic.games.kingdoms.utils.points.Rect;
import pl.jamnic.games.kingdoms.view.instances.MainComponent;
import utils.Opt;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

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
        setSize(FrameConstants.frameWidth, FrameConstants.frameHeight);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    private void initDrawPanel() {
        add(mainComponent = new MainComponent(Rect.of(0, 0, FrameConstants.frameWidth, FrameConstants.frameHeight)));
        new Thread(FpsTimer.singleton()).start();
    }

    private void drawGraphics(Graphics graphics) {
        GameGraphics g = new GameGraphics(graphics);
        mainComponent.preDraw(g);
        g.dispose();
    }
}
