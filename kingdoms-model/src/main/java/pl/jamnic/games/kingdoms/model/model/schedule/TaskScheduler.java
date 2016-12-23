package pl.jamnic.games.kingdoms.model.model.schedule;

import pl.jamnic.games.kingdoms.model.model.schedule.tasks.Task;
import pl.jamnic.games.kingdoms.model.model.schedule.tasks.person.FindSpouseTask;
import utils.Bool;
import utils.Opt;

import java.util.List;
import java.util.stream.Collectors;

public abstract class TaskScheduler {

    private final Tasks tasks = new Tasks();

    /* ========== PUBLIC ========== */
    public Opt<Task> getTask() {
        return tasks.getFirstUnfinishedTask();
    }

    public Bool isEmpty() {
        return tasks.isEmpty();
    }

    public abstract void prepareTasks();

    public void addTask(Task task) {
        tasks.addTask(task);
    }

    /* ========== PROTECTED ========== */
    protected Bool haveTask(Class<FindSpouseTask> clazz) {
        return Bool.of(tasks
                .getTasks()
                .stream()
                .anyMatch(clazz::isInstance));
    }

    protected void removeTasks(Class<FindSpouseTask> clazz) {
        List<Task> collect = tasks
                .getTasks()
                .stream()
                .filter(clazz::isInstance)
                .collect(Collectors.toList());

        tasks.getTasks().removeAll(collect);
    }
}
