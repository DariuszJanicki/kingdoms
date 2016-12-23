package pl.jamnic.games.kingdoms.model.model.schedule.arguments.settlement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.jamnic.games.kingdoms.model.model.schedule.arguments.Arguments;
import pl.jamnic.games.kingdoms.model.model.terrain.TerrainType;

@Getter
@AllArgsConstructor
public final class GatherResourcesArguments extends Arguments {
    private TerrainType type;
}
