package pl.jamnic.games.kingdoms.model.model.settlement;

import lombok.RequiredArgsConstructor;
import pl.jamnic.games.kingdoms.model.model.schedule.TaskScheduler;
import pl.jamnic.games.kingdoms.model.model.schedule.arguments.settlement.GatherResourcesArguments;
import pl.jamnic.games.kingdoms.model.model.schedule.tasks.settlement.GatherResourcesTask;
import pl.jamnic.games.kingdoms.model.model.terrain.TerrainType;

@RequiredArgsConstructor
class SettlementTaskScheduler extends TaskScheduler {

    private final Settlement settlement;

    @Override
    public void prepareTasks() {
        addTask(new GatherResourcesTask(new GatherResourcesArguments(TerrainType.DESERT)));
        addTask(new GatherResourcesTask(new GatherResourcesArguments(TerrainType.DESERT)));
    }
}
