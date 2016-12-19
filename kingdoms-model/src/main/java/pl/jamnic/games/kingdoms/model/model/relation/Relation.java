package pl.jamnic.games.kingdoms.model.model.relation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.jamnic.games.kingdoms.model.model.person.Person;

@Getter
@AllArgsConstructor
public class Relation {

    private Person target;
    private RelationType type;

    public boolean isFamily() {
        return type.isFamily();
    }
}
