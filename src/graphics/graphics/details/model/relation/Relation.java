package graphics.graphics.details.model.relation;

import graphics.graphics.details.model.person.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Relation {

    private Person target;
    private RelationType type;

}
