package pl.jamnic.games.kingdoms.model.model.schedule.tasks;

import lombok.RequiredArgsConstructor;
import pl.jamnic.games.kingdoms.model.model.schedule.TaskStatus;
import pl.jamnic.games.kingdoms.model.model.schedule.Tasks;
import pl.jamnic.games.kingdoms.model.model.schedule.arguments.Arguments;

import java.util.function.Consumer;

@RequiredArgsConstructor
public abstract class Task<T extends Arguments> {

    private final Tasks subtasks = new Tasks();
    private final Consumer<T> function;
    private final T arguments;
    private TaskStatus status = TaskStatus.PENDING;

    public void executeTask() {
        subtasks.getFirstUnfinishedTask()
                .ifPresent(Task::execute)
                .ifNotPresent(this::execute);
    }

    private void execute() {
        function.accept(arguments);
        status = TaskStatus.FINISHED;
    }
}
