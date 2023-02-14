package fr.rhodless.akira.uhc.api.events.game.list.player;

import fr.rhodless.akira.uhc.api.events.game.GameEvent;
import fr.rhodless.akira.uhc.api.player.info.ProfileInfo;
import org.bukkit.entity.Player;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */

/**
 * Englobe tous les events qui implique un joueur de la partie.
 */
public abstract class GamePlayerEvent extends GameEvent {
    private final Player player;
    private final ProfileInfo profileInfo;

    /**
     * @param player      Le joueur qui a déclenché l'event
     * @param profileInfo Le profil du joueur
     */
    public GamePlayerEvent(Player player, ProfileInfo profileInfo) {
        this.player = player;
        this.profileInfo = profileInfo;
    }

    /**
     * Permet de récupérer le joueur qui a déclenché l'event.
     *
     * @return Le joueur qui a déclenché l'event
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Permet de récupérer le profil du joueur.
     *
     * @return Le profil du joueur
     */
    public ProfileInfo getProfileInfo() {
        return profileInfo;
    }
}
