package graphics.frame;

class FpsTimer implements Runnable {

    private final long TPS = 10;
    private final long SECOND = 1000000000;
    private final long TICK = SECOND / TPS;

    private int frames = 0;
    private int ticks = 0;
    private long fpsTime = System.nanoTime();
    private long tpsTime = System.nanoTime();

    @Override
    public void run() {
        while (true) {
            long currentTime = System.nanoTime();

            draw();
            check(currentTime);
        }
    }

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
