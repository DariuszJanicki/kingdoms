package graphics.graphics.details.model.relation;

import graphics.graphics.details.model.person.Person;
import lombok.val;
import utils.Bool;
import utils.Opt;

import java.util.ArrayList;
import java.util.List;

import static graphics.graphics.details.model.relation.RelationType.*;

public class Relations {

    private List<Relation> relation = new ArrayList<>();

    /* ========== PUBLIC ========== */
    public Bool hasSpouse() {
        return getSpouseRelation().isPresent();
    }

    public void addSpouse(Person person) {
        relation.add(new Relation(person, SPOUSE));
    }

    public Opt<Person> getSpouse() {
        val spouse = getSpouseRelation();
        return spouse.isPresent().isTrue() ? Opt.ofNullable(spouse.get().getTarget()) : Opt.empty();
    }

    public void parents(Person mother, Person father) {
        relation.add(new Relation(mother, MOTHER));
        relation.add(new Relation(father, FATHER));
    }

    public void child(Person child) {
        relation.add(new Relation(child, CHILD));
    }

    /* ========== PRIVATE ========== */
    private Opt<Relation> getSpouseRelation() {
        return Opt.of(relation.stream()
                    .filter(relation -> relation.getType() == SPOUSE)
                    .findFirst());
    }
}
