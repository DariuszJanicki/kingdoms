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
        if (pregnancy.isPresent().isTrue()) {
            if (pregnancy.get().nextStage().isTrue()) {
                if (settlement.isPresent().isTrue()) {
                    settlement.get().addVillagers(pregnancy.get().getChildren());
                }
                pregnancy = Opt.empty();
            }
        }
        pregnancy.ifPresent(p -> p.nextStage());
    }

    @Override
    public String toString() {
        return gender + " " + name + " born in " + birthDate;
    }

    public Bool isMale() {
        return gender.isMale();
    }

    public Bool isFemale() {
        return gender.isFemale();
    }

    public Bool hasSpouse() {
        return relations.hasSpouse();
    }

    public void marry(Person person) {
        relations.addSpouse(person);
        person.relations.addSpouse(this);

        System.out.println(this + " żeni się z " + person);
    }

    public Opt<Person> getSpouse() {
        return relations.getSpouse();
    }

    public void startPregnancy(Opt<Person> spouse) {
        isFemale()
                .and(spouse.isPresent())
                .and(spouse.get().isMale())
                .and(pregnancy.isEmpty())
                .ifTrue(() -> this.startPregnancy(spouse.get()));
    }

    /* ========== PRIVATE ========== */
    private void startPregnancy(Person male) {
        System.out.println(this + " is pregnant with " + male);
        this.pregnancy = Opt.of(new Pregnancy(this, male));
    }

    public void parents(Person mother, Person father) {
        relations.parents(mother, father);
    }

    public void child(Person child) {
        relations.child(child);
    }

    public Bool eligibleToWed() {
        return Bool.of(birthDate.difference(ComponentModel.INSTANCE.getGameDate()).getTime() > 5475);
    }

    public Bool isPregnant() {
        return pregnancy.isPresent();
    }
}