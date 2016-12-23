package pl.jamnic.games.kingdoms.model.model.schedule.tasks.settlement;

import pl.jamnic.games.kingdoms.model.model.schedule.arguments.settlement.GatherResourcesArguments;
import pl.jamnic.games.kingdoms.model.model.schedule.tasks.Task;

public class GatherResourcesTask extends Task<GatherResourcesArguments> {

    public GatherResourcesTask(GatherResourcesArguments arguments) {
        super(GatherResourcesTask::perform, arguments);
    }

    private static void perform(GatherResourcesArguments arguments) {
//        System.out.println(arguments.getType());
    }
}
