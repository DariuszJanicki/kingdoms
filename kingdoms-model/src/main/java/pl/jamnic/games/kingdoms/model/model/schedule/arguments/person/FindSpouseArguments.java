package pl.jamnic.games.kingdoms.model.model.schedule.arguments.person;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.jamnic.games.kingdoms.model.model.person.Person;
import pl.jamnic.games.kingdoms.model.model.schedule.arguments.Arguments;

@Getter
@RequiredArgsConstructor
public final class FindSpouseArguments extends Arguments {

    private final Person person;
}
