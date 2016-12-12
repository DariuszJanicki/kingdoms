package view.interfaces;

import engine.points.Rect;
import engine.points.Point;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;
import java.awt.image.BufferedImage;

@Getter
@AllArgsConstructor
public final class GameGraphics {

    private Graphics graphics;

    public void draw(Rect rect) {
        draw(rect.getStartPoint(), rect.getEndPoint());
    }

    public void draw(Point startPoint, Point endPoint) {
        graphics.fillRect(
                startPoint.getX(),
                startPoint.getY(),
                endPoint.getX() - startPoint.getX(),
                endPoint.getY() - startPoint.getY());
    }

    public void draw(BufferedImage image, Rect rect) {
        draw(image, rect.getStartPoint(), rect.getEndPoint());
    }

    public void draw(BufferedImage image, Point startPoint, Point endPoint) {
        graphics.drawImage(
                image,
                startPoint.getX(),
                startPoint.getY(),
                endPoint.getX() - startPoint.getX(),
                endPoint.getY() - startPoint.getY(),
                null);
    }

    public void dispose() {
        graphics.dispose();
    }

    public void setColor(Color color) {
        graphics.setColor(color);
    }

    public FontMetrics getFontMetrics() {
        return graphics.getFontMetrics();
    }

    public int stringWidth(String string) {
        return getFontMetrics().stringWidth(string);
    }

    public void drawString(String string, Point point) {
        graphics.drawString(string, point.getX(), point.getY());
    }

}
