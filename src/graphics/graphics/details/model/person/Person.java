package graphics.graphics.details.model.person;

import graphics.graphics.details.model.ComponentModel;
import graphics.graphics.details.model.relation.Relations;
import graphics.graphics.details.model.settlement.Settlement;
import lombok.Setter;
import utils.Bool;
import utils.Opt;

public class Person {

    private final String name;
    private final Gender gender;
    private final GameDate birthDate;
    private final Relations relations = new Relations();
    private Opt<Pregnancy> pregnancy = Opt.empty();

    @Setter
    private Opt<Settlement> settlement = Opt.empty();

    /* ========== PUBLIC ========== */
    public Person(String name, Gender gender, GameDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public void tick() {
        pregnancy.ifPresent(p -> p.nextStage().ifTrue(this::childbirth));
    }

    @Override
    public String toString() {
        return name + ", " + ComponentModel.INSTANCE.getGameDate().difference(birthDate).getYears() + " lat.";
    }

    /* ========== DEFAULT ========== */
    Bool isMale() {
        return gender.isMale();
    }

    Bool isFemale() {
        return gender.isFemale();
    }

    Bool hasSpouse() {
        return relations.hasSpouse();
    }

    void marry(Person person) {
        relations.addSpouse(person);
        person.relations.addSpouse(this);
    }

    Opt<Person> getSpouse() {
        return relations.getSpouse();
    }

    void startPregnancy(Opt<Person> spouse) {
        spouse.ifPresent(husband -> isFemale()
                .and(husband.isMale())
                .and(pregnancy.isEmpty())
                .ifTrue(() -> startPregnancy(husband)));
    }

    void parents(Person mother, Person father) {
        relations.parents(mother, father);
    }

    void child(Person child) {
        relations.child(child);
    }

    Bool eligibleToWed() {
        return Bool.of(birthDate.difference(ComponentModel.INSTANCE.getGameDate()).getTime() > 5475);
    }

    Bool isPregnant() {
        return pregnancy.isPresent();
    }

    /* ========== PRIVATE ========== */
    private void startPregnancy(Person male) {
        this.pregnancy = Opt.of(new Pregnancy(this, male));
    }

    private void childbirth() {
        settlement.ifPresent(() -> settlement.get().addVillagers(pregnancy.get().getChildren()));
        pregnancy = Opt.empty();
    }
}