package pl.jamnic.games.kingdoms.view.drawer;

import lombok.Getter;
import lombok.Setter;
import pl.jamnic.games.kingdoms.model.loader.tile.list.SettlementTileTypeList;
import pl.jamnic.games.kingdoms.model.model.settlement.Settlement;
import pl.jamnic.games.kingdoms.uicomponents.components.GameGraphics;
import pl.jamnic.games.kingdoms.utils.points.Point;
import pl.jamnic.games.kingdoms.utils.points.Rect;

import java.awt.*;

@Setter
@Getter
public class SettlementDrawer extends AbstractDrawer<Settlement> {

    public static void draw(GameGraphics g, Settlement settlement, Rect rect, Point delta) {
        String size = String.valueOf(settlement.getSettlementPeople().list().size());
        g.draw(SettlementTileTypeList.singleton().getTile(settlement.getType()).getImage(), rect.move(delta));
        drawText(g, size, rect, delta);
    }

    private static void drawText(GameGraphics g, String size, Rect rect, Point delta) {
        Point add = rect.getStartPoint().add(0, 12);
        g.setColor(new Color(255, 255, 255, 200));
        g.draw(Rect.of(rect.getStartPoint(), rect.getStartPoint().add(g.stringWidth(size), 15)).move(delta));
        g.setColor(Color.BLACK);
        g.drawString(size, add.add(delta));
    }
}
