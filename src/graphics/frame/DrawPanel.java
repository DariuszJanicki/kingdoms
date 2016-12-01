package graphics.frame;


import graphics.graphics.GameGraphics;
import graphics.graphics.details.points.Rect;
import graphics.graphics.instances.MainComponent;
import graphics.input.Keyboard;
import graphics.input.Mouse;
import lombok.Getter;
import utils.Opt;

import java.awt.*;
import java.awt.image.BufferStrategy;

import static graphics.frame.constants.FrameConstants.frameHeight;
import static graphics.frame.constants.FrameConstants.frameWidth;

public final class DrawPanel extends Canvas {

    @Getter
    private MainComponent mainComponent;
    private static Opt<DrawPanel> instance = Opt.empty();

    /* ========== SINGLETON FACTORY ========== */
    public static DrawPanel singleton() {
        instance.ifNotPresent(() -> instance = Opt.of(new DrawPanel()));
        return instance.get();
    }

    /* ========== CONSTRUCTOR ========== */
    private DrawPanel() {
        addMouseListener(new Mouse());
        addKeyListener(new Keyboard());

        mainComponent = new MainComponent(Rect.of(0, 0, frameWidth, frameHeight));
        setVisible(true);
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
