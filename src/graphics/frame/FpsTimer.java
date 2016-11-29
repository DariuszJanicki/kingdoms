package graphics.frame;

import graphics.graphics.details.model.person.GameDate;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FpsTimer implements Runnable {

    private static FpsTimer singleton;

    /* ========== SINGLETON ========== */
    public static FpsTimer singleton() {
        return singleton == null ? singleton = new FpsTimer() : singleton;
    }

    private final long TPS = 30;
    private final long SECOND = 1000000000;
    private final long TICK = SECOND / TPS;

    private int frames = 0;
    private int ticks = 0;
    private long fpsTime = System.nanoTime();
    private long tpsTime = System.nanoTime();

    private GameDate gameDate = GameDate.init();

    /* ========== PUBLIC ========== */
    public GameDate getCurrentDate() {
        return GameDate.of(gameDate);
    }

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
        DrawPanel.singleton().draw();
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
        DrawPanel.singleton().tick();
        gameDate.dayPassed();
    }

    private void reset(long currentTime) {
        if (currentTime >= fpsTime + SECOND) {
            System.out.println("FPS: " + frames + " - TPS: " + ticks);
            fpsTime = currentTime;
            frames = 0;
            ticks = 0;
        }
    }
}
