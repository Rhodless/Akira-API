package fr.rhodless.akira.uhc.api.scoreboard;

import org.bukkit.entity.Player;

import java.util.List;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface ScoreboardAdapter {
    /**
     * Retourne le titre du scoreboard
     *
     * @param player le joueur
     * @return le titre du scoreboard
     */
    String getTitle(final Player player);

    /**
     * Retourne les lignes du scoreboard
     *
     * @param player le joueur
     * @return les lignes du scoreboard
     */
    List<String> getLines(final Player player);
}
