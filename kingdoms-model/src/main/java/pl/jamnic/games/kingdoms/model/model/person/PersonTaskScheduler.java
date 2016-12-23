package pl.jamnic.games.kingdoms.model.model.person;

import lombok.AllArgsConstructor;
import pl.jamnic.games.kingdoms.model.model.schedule.TaskScheduler;
import pl.jamnic.games.kingdoms.model.model.schedule.arguments.person.FindSpouseArguments;
import pl.jamnic.games.kingdoms.model.model.schedule.tasks.person.FindSpouseTask;

@AllArgsConstructor
class PersonTaskScheduler extends TaskScheduler {

    private final Person person;

    @Override
    public void prepareTasks() {
        person.getSpouse()
                .isPresent()
                .or(haveTask(FindSpouseTask.class))
                .ifFalse(this::addTask);

        person.getSpouse()


                .ifPresent(() -> removeTasks(FindSpouseTask.class));
    }

    private void addTask() {
        addTask(new FindSpouseTask(new FindSpouseArguments(person)));
    }
}
