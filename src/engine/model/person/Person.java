package engine.model.person;

import engine.date.GameDate;
import engine.model.ComponentModel;
import engine.model.building.Building;
import engine.model.building.Buildings;
import engine.model.relation.Relations;
import engine.model.settlement.Settlement;
import lombok.Getter;
import lombok.Setter;
import utils.Bool;
import utils.Opt;

public class Person {

    private final String name;
    private final Gender gender;
    private final GameDate birthDate;
    private final Relations relations = new Relations();
    private final Buildings ownedBuildings = new Buildings();

    private Opt<Pregnancy> pregnancy = Opt.empty();

    @Getter
    private Opt<Building> house = Opt.empty();

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
    }

    public Opt<Person> getSpouse() {
        return relations.getSpouse();
    }

    public void startPregnancy(Opt<Person> spouse) {
        spouse.ifPresent(husband -> isFemale()
                .and(husband.isMale())
                .and(house.isPresent())
                .and(pregnancy.isEmpty())
                .ifTrue(() -> startPregnancy(husband)));
    }

    void parents(Person mother, Person father) {
        relations.parents(mother, father);
    }

    void child(Person child) {
        relations.child(child);
    }

    public Bool eligibleToWed() {
        return Bool.of(birthDate.difference(ComponentModel.INSTANCE.getGameDate()).getTime() > 5475);
    }

    public Bool isPregnant() {
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

    public Bool canJoinSettlement() {
        return settlement.isPresent().negate();
    }

    public void claim(Building building) {
        System.out.println(this + " buys " + building);
        ownedBuildings.add(building);
        building.setOwner(Opt.of(this));
        house.ifNotPresent(() -> moveFamilyToHouse(building));
        moveFamilyToHouse(building);
    }

    private void moveFamilyToHouse(Building newHouse) {
        newHouse.moveIn(this);
        relations.getFamily().getPeople()
                .forEach(newHouse::moveIn);
    }
}