package engine.model.relation;

import engine.model.person.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Relation {

    private Person target;
    private RelationType type;

    public boolean isFamily() {
        return type.isFamily();
    }
}
