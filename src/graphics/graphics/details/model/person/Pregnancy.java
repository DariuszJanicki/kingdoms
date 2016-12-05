package graphics.graphics.details.model.person;

import graphics.graphics.details.generator.PersonGenerator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import utils.Bool;
import utils.Dice;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Pregnancy {

    private final Person mother;
    private final Person father;

    private Integer stage = 0;
    @Getter
    private List<Person> children = new ArrayList<>();

    public Bool nextStage() {
        if (stage == 270) {
            int k = Dice.k(20);
            if (k < 16) {
                createChild();
            } if (k < 19) {
                createChild();
                createChild();
            } if (k < 20) {
                createChild();
                createChild();
                createChild();
            }
            return Bool.of(true);
        }
        stage++;
        return Bool.of(false);
    }

    private void createChild() {
        Person child = PersonGenerator.INSTANCE.createPerson();
        child.parents(mother, father);
        mother.child(child);
        children.add(child);
    }
}
