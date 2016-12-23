package pl.jamnic.games.kingdoms.model.model.schedule;

import lombok.Getter;
import pl.jamnic.games.kingdoms.model.model.schedule.tasks.Task;
import utils.Bool;
import utils.Opt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public final class Tasks {

    @Getter
    private Queue<Task> tasks = new LinkedList<>();

    /* ========== PUBLIC ========== */
    public Tasks(Task... tasks) {
        this.tasks.addAll(new ArrayList<>(Arrays.asList(tasks)));
    }

    public Opt<Task> getFirstUnfinishedTask() {
        return Opt.ofNullable(tasks.poll());
    }

    /* ========== DEFAULT ========== */
    Bool isEmpty() {
        return Bool.of(tasks.isEmpty());
    }

    void addTask(Task task) {
        tasks.add(task);
    }
}
