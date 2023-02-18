package fr.rhodless.akira.uhc.api.player.info.death;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface ProfileDeathProcess {
    /**
     * @return le tueur du joueur
     */
    Player getKiller();

    /**
     * Permet de commencer le processus de mort.
     */
    void start();

    /**
     * Permet de respawn le joueur. Si la location est null, le joueur sera respawn dans un endroit aléatoire.
     *
     * @param toRespawn la location de respawn
     */
    void respawn(@Nullable Location toRespawn);

    /**
     * Permet de terminer le processus de mort. Le joueur sera donc définitivement mort.
     */
    void end();

    /**
     * Permet de définir combien de temps après la mort l'annonce de mort est envoyée
     *
     * @param seconds combien de temps après la mort l'annonce de mort est envoyée
     */
    void setAnnounceAfter(int seconds);

    /**
     * Permet de récupérer combien de temps après la mort l'annonce de mort est envoyée
     *
     * @return combien de temps après la mort l'annonce de mort est envoyée
     */
    int getAnnounceAfter();
}
