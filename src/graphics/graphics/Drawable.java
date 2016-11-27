package graphics.graphics;

import graphics.graphics.clickable.Component;

import java.util.ArrayList;
import java.util.List;

public abstract class Drawable {

    protected List<Component> components = new ArrayList<>();

    /* ========== PUBLIC ========== */
    public void preDraw(GameGraphics g) {
        draw(g);
        components.forEach(c -> c.preDraw(g));
    }

    public void preTick() {
        tick();
        components.forEach(Drawable::tick);
    }

    public abstract void draw(GameGraphics g);

    public void tick() {
    }
}
