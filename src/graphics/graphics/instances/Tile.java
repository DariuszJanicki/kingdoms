package graphics.graphics.instances;

import graphics.graphics.GameGraphics;
import graphics.graphics.component.setting.AbstractComponent;
import graphics.graphics.details.model.settlement.Settlement;
import graphics.graphics.details.model.tile.field.Field;
import graphics.graphics.details.points.Point;
import graphics.graphics.details.points.Rect;
import graphics.input.GameMouseEvent;
import lombok.Setter;
import utils.Opt;

import java.awt.*;

class Tile extends AbstractComponent {

    private Opt<Field> field = Opt.empty();
    @Setter
    private Point delta;

    /* ========== CONSTRUCTOR ========== */
    Tile(Rect rect) {
        super(rect);
        getClickFunction().registerLeft(this::leftMouse);
    }

    /* ========== PUBLIC ========== */
    Tile setField(Field field) {
        this.field = Opt.ofNullable(field);
        return this;
    }

    @Override
    public void draw(GameGraphics g) {
        field.ifPresent(f -> {
            g.draw(f.getTile().getImage(), rect.move(this.delta));
            f.getSettlement().ifPresent(s -> drawSettlement(g, s));
        });
    }


    @Override
    public void tick() {
        field.ifPresent(Field::tick);
    }

    /* ========== PRIVATE ========== */
    private void leftMouse(GameMouseEvent e) {
        field.ifPresent(f -> {
            model.setCurrentTileInfo(f.getTerrain() + " " + f.getCoords());
            f.getSettlement()
                    .ifPresent(settlement -> model.setVillagers(settlement.getInhabitants().list()));
        });
    }

    private void drawSettlement(GameGraphics g, Settlement settlement) {
        String size = String.valueOf(settlement.getInhabitants().list().size());
        g.draw(settlement.getTile().getImage(), rect.move(delta));
        drawText(g, size);
    }

    private void drawText(GameGraphics g, String size) {
        Point add = rect.getStartPoint().add(0, 12);
        g.setColor(new Color(255, 255, 255, 200));
        g.draw(Rect.of(rect.getStartPoint(), rect.getStartPoint().add(g.stringWidth(size), 15)).move(delta));
        g.setColor(Color.BLACK);
        g.drawString(size, add.add(delta));
    }
}
