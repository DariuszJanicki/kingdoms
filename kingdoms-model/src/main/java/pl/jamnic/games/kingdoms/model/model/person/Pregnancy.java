package pl.jamnic.games.kingdoms.model.model.person;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.jamnic.games.kingdoms.model.generator.PersonGenerator;
import utils.Bool;
import utils.Dice;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
final class Pregnancy {

    private final Person mother;
    private final Person father;

    private Integer stage = 0;
    @Getter
    private List<Person> children = new ArrayList<>();

    Bool nextStage() {
        if (stage == 270) {
            int k = Dice.k(20);
            if (k < 19) {
                createChild();
            }
            if (k < 20) {
                createChild();
                createChild();
            }
            return Bool.TRUE;
        }
        stage++;
        return Bool.FALSE;
    }

    private void createChild() {
        Person child = PersonGenerator.INSTANCE.createBaby();
        child.parents(mother, father);
        mother.child(child);
        children.add(child);
    }
}