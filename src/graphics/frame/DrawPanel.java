package graphics.frame;


import graphics.frame.constants.FrameConstants;
import graphics.graphics.GameGraphics;
import graphics.graphics.Point;
import graphics.graphics.Rect;
import graphics.graphics.components.MainComponent;
import graphics.input.Keyboard;
import graphics.input.Mouse;
import lombok.Getter;
import utils.Opt;

import java.awt.*;
import java.awt.image.BufferStrategy;

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

        Rect rect = new Rect(
                new Point(0, 0),
                new Point(FrameConstants.width, FrameConstants.height)
        );

        mainComponent = new MainComponent(rect);
        setVisible(true);
    }

    /* ========== PROTECTED ========== */
    void draw() {
        BufferStrategy bs = getBufferStrategy();

        if (bs == null) {
            createBufferStrategy(2);
            return;
        }

        drawGraphics(bs);
        bs.show();
    }

    void tick() {
    }

    /* ========== PRIVATE ========== */
    private void drawGraphics(BufferStrategy bs) {
        GameGraphics g = new GameGraphics(bs.getDrawGraphics());
        mainComponent.preDraw(g);
        g.dispose();
    }
}
