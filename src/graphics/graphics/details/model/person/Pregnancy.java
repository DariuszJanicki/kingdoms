package graphics.graphics.details.model.person;

import graphics.graphics.details.generator.PersonGenerator;
import utils.Bool;
import utils.Opt;

public class Pregnancy {

    private Integer stage;
    private Opt<Person> child = Opt.empty();

    public Bool nextStage() {
        if (stage == 9) {
            Person person = PersonGenerator.INSTANCE.createPerson();
            child = Opt.of(person);
            return Bool.of(true);
        }
        stage++;
        return Bool.of(false);
    }
}
