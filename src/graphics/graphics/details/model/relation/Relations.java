package graphics.graphics.details.model.relation;

import graphics.graphics.details.model.person.People;
import graphics.graphics.details.model.person.Person;
import lombok.val;
import utils.Bool;
import utils.Opt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static graphics.graphics.details.model.relation.RelationType.*;

public class Relations {

    private List<Relation> relations = new ArrayList<>();

    /* ========== PUBLIC ========== */
    public Bool hasSpouse() {
        return getSpouseRelation().isPresent();
    }

    public void addSpouse(Person person) {
        relations.add(new Relation(person, SPOUSE));
    }

    public Opt<Person> getSpouse() {
        val spouse = getSpouseRelation();
        return spouse.isPresent().isTrue() ? Opt.ofNullable(spouse.get().getTarget()) : Opt.empty();
    }

    public void parents(Person mother, Person father) {
        relations.add(new Relation(mother, MOTHER));
        relations.add(new Relation(father, FATHER));
    }

    public void child(Person child) {
        relations.add(new Relation(child, CHILD));
    }

    /* ========== PRIVATE ========== */
    private Opt<Relation> getSpouseRelation() {
        return Opt.of(relations.stream()
                    .filter(relation -> relation.getType() == SPOUSE)
                    .findFirst());
    }

    public People getFamily() {
        return new People(relations.stream()
                .filter(Relation::isFamily)
                .map(Relation::getTarget)
                .collect(Collectors.toList()));
    }
}
