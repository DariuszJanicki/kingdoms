package pl.jamnic.games.kingdoms.base;

import pl.jamnic.games.kingdoms.uicomponents.components.ComponentModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FpsTimer implements Runnable {

    private static FpsTimer singleton;

    /* ========== SINGLETON ========== */
    public static FpsTimer singleton() {
        return singleton == null ? singleton = new FpsTimer() : singleton;
    }

    private final long TPS = 20;
    private final long SECOND = 1000000000;
    private final long TICK = SECOND / TPS;

    private int frames = 0;
    private int ticks = 0;
    private long fpsTime = System.nanoTime();
    private long tpsTime = System.nanoTime();

    /* ========== PUBLIC ========== */
    @Override
    public void run() {
        while (true) {
            long currentTime = System.nanoTime();

            draw();
            check(currentTime);
        }
    }

    /* ========== PRIVATE ========== */
    private void draw() {
        frames++;
        MainFrame.singleton().draw();
    }

    private void check(long currentTime) {
        if (currentTime >= tpsTime + TICK) {
            tick();
            tpsTime = currentTime;
            reset(currentTime);
        }
    }

    private void tick() {
        ticks++;
        MainFrame.singleton().tick();
        ComponentModel.INSTANCE.getGameDate().dayPassed();
    }

    private void reset(long currentTime) {
        if (currentTime >= fpsTime + SECOND) {
            ComponentModel.INSTANCE.setFps("FPS: " + frames + " - TPS: " + ticks);
            fpsTime = currentTime;
            frames = 0;
            ticks = 0;
        }
    }
}
