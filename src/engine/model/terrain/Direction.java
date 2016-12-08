package engine.model.terrain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Direction {

    NONE(false, false, false, false),
    NORTH(true, false, false, false),
    NORTH_SOUTH(true, true, false, false),
    NORTH_SOUTH_EAST(true, true, true, false),
    NORTH_SOUTH_EAST_WEST(true, true, true, true),
    NORTH_SOUTH_WEST(true, true, false, true),
    NORTH_EAST(true, false, true, false),
    NORTH_EAST_WEST(true, false, true, true),
    NORTH_WEST(true, false, false, true),
    SOUTH(false, true, false, false),
    SOUTH_EAST(false, true, true, false),
    SOUTH_EAST_WEST(false, true, true, true),
    SOUTH_WEST(false, true, false, true),
    EAST(false, false, true, false),
    EAST_WEST(false, false, true, true),
    WEST(false, false, false, true);

    private boolean north;
    private boolean south;
    private boolean east;
    private boolean west;

    /* ========== STATIC ========== */
    public static Direction getDirection(boolean north, boolean south, boolean east, boolean west) {
        for (Direction direction : values()) {
            if (direction.north == north && direction.south == south && direction.east == east && direction.west == west) {
                return direction;
            }
        }

        return NONE;
    }
}
