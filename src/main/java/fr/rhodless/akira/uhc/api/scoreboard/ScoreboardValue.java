package fr.rhodless.akira.uhc.api.scoreboard;

import fr.rhodless.akira.uhc.api.game.state.GameState;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public class ScoreboardValue {
    private final Integer position;
    private final String value;
    private final GameState gameState;

    public ScoreboardValue(Integer position, String value, GameState gameState) {
        this.position = position;
        this.value = value;
        this.gameState = gameState;
    }

    public Integer getPosition() {
        return position;
    }

    public String getValue() {
        return value;
    }

    public GameState getGameState() {
        return gameState;
    }
}
