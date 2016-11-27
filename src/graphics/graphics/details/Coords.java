package graphics.graphics.details;

import graphics.frame.constants.FrameConstants;
import graphics.graphics.Point;

import java.util.Objects;

public class Coords extends Tuple {

    /* ========== CONSTRUCTOR ========== */
    public Coords(Integer x, Integer y) {
        super(x, y);
    }

    /* ========== PUBLIC ========== */
    public Point toPoint() {
        return new Point(x, y).mul(FrameConstants.baseTile);
    }

    public Coords plus(Coords coords) {
        return plus(coords.x, coords.y);
    }

    public Coords north() {
        return new Coords(x, y - 1);
    }

    public Coords south() {
        return new Coords(x, y + 1);
    }

    public Coords east() {
        return new Coords(x + 1, y);
    }

    public Coords west() {
        return new Coords(x - 1, y);
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    public static Coords toNorth() {
        return new Coords(0, -1);
    }

    public static Coords toSouth() {
        return new Coords(0, 1);
    }

    public static Coords toEast() {
        return new Coords(1, 0);
    }

    public static Coords toWest() {
        return new Coords(-1, 0);
    }

    public boolean notEqual(Coords coords) {
        return (!Objects.equals(x, coords.x)) || (!Objects.equals(y, coords.y));
    }

    public Coords difference(Coords coords) {
        return new Coords(x - coords.x, y - coords.y);
    }

    public int length() {
        return Math.abs(x) + Math.abs(y);
    }

    public int xDifference(Coords coords) {
        return x - coords.x;
    }

    public int yDifference(Coords coords) {
        return y - coords.y;
    }

    public Coords plus(int x, int y) {
        return new Coords(this.x + x, this.y + y);
    }

    public boolean check(Size size, Size size1) {
        return checkX(size, size1) && checkY(size, size1);
    }

    private boolean checkX(Size map, Size size) {
        return x >= 0 && x < map.getX() - size.getX();
    }

    private boolean checkY(Size map, Size size) {
        return y >= 0 && y < map.getY() - size.getY();
    }

    public boolean check(Size size) {
        return checkX(size) && checkY(size);
    }

    public boolean checkX(Size size) {
        return x >= 0 && x < size.getX();
    }

    public boolean checkY(Size size) {
        return y >= 0 && y < size.getY();
    }

}
