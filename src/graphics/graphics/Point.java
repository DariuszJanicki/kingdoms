package graphics.graphics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Point {

    private Integer x;
    private Integer y;

    public Point mul(int mul) {
        return new Point(x * mul, y * mul);
    }

    public Point plus(Point point) {
        return new Point(x + point.x, y + point.y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public Point add(Integer x, Integer y) {
        return new Point(this.x + x, this.y + y);
    }
}
