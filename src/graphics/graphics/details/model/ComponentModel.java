package graphics.graphics.details.model;

import graphics.graphics.details.model.person.GameDate;
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
