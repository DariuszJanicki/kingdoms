package graphics.graphics.details.model.relation;

public enum RelationType {

    ACQUAINTANCE,
    FRIEND,
    LOVER,
    EX_LOVER,
    SPOUSE,
    CHILD,
    MOTHER,
    FATHER;

    public boolean isFamily() {
        return this == SPOUSE || this == CHILD;
    }
}
