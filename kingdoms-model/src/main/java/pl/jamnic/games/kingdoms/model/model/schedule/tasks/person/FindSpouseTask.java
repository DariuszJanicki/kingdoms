package pl.jamnic.games.kingdoms.model.model.schedule.tasks.person;

import pl.jamnic.games.kingdoms.model.model.person.Person;
import pl.jamnic.games.kingdoms.model.model.schedule.arguments.person.FindSpouseArguments;
import pl.jamnic.games.kingdoms.model.model.schedule.tasks.Task;
import pl.jamnic.games.kingdoms.model.model.settlement.Settlement;
import utils.Opt;

public class FindSpouseTask extends Task<FindSpouseArguments> {

    public FindSpouseTask(FindSpouseArguments arguments) {
        super(FindSpouseTask::perform, arguments);
    }

    private static void perform(FindSpouseArguments arguments) {
        getPotentialSpouse(arguments)
                .ifPresent(spouse -> spouse.marry(arguments.getPerson()));
    }

    private static Opt<Person> getPotentialSpouse(FindSpouseArguments arguments) {
        return arguments
                .getPerson()
                .getSettlement()
                .map(settlement -> getFirst(arguments, settlement));
    }

    private static Opt<Person> getFirst(FindSpouseArguments arguments, Settlement settlement) {
        return Opt.of(settlement
                .getSettlementPeople()
                .getPeople()
                .stream()
                .filter(person -> !person.getGender().equals(arguments.getPerson().getGender()))
                .filter(person -> person.hasSpouse().isFalse())
                .filter(person -> person.isEligibleToWed().isTrue())
                .findFirst());
    }
}
