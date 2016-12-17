package pl.jamnic.games.kingdoms.uicomponents.components;

import pl.jamnic.games.kingdoms.date.GameDate;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public enum ComponentModel {

    INSTANCE;

    /* ========== PRIVATE ========== */

    @Getter
    @Setter
    private String currentTileInfo;

    @Getter
    @Setter
    private List<String> villagers;

    @Getter
    @Setter
    private GameDate gameDate = GameDate.init();

    @Getter
    @Setter
    private String fps;

}
