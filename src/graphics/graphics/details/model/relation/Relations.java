package graphics.graphics.details.model.relation;

import graphics.graphics.details.model.person.Person;
import utils.Bool;

import java.util.ArrayList;
import java.util.List;

import static graphics.graphics.details.model.relation.RelationType.SPOUSE;

public class Relations {

    private List<Relation> relation = new ArrayList<>();

    /* ========== PUBLIC ========== */
    public Bool hasSpouse() {
        return Bool.of(relation.stream().filter(r -> r.getType() == SPOUSE).findFirst().isPresent());
    }

    public void addSpouse(Person person) {
        relation.add(new Relation(person, SPOUSE));
    }
}
