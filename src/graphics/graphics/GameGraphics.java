package graphics.graphics;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;
import java.awt.image.BufferedImage;

@Getter
@AllArgsConstructor
public class GameGraphics {

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
}
