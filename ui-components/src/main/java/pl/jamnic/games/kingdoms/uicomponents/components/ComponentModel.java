package pl.jamnic.games.kingdoms.uicomponents.components;

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
    private String fps;

}
