package fr.rhodless.akira.uhc.api.events.game.list.player.list;

import fr.rhodless.akira.uhc.api.events.game.list.player.GamePlayerEvent;
import fr.rhodless.akira.uhc.api.player.info.ProfileInfo;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */

/**
 * Cet event est appelée quand un joueur quitte une partie lorsqu'elle est en cours.
 * L'event n'est pas appelé si le joueur quitte la partie en tant que spectateur
 *
 * @see GameSpectatorJoinPlayerEvent
 * @see ProfileInfo#isAlive()
 * @see ProfileInfo#getRemainingTime()
 */
public class GameLeavePlayerEvent extends GamePlayerEvent {
    public static final HandlerList HANDLERS = new HandlerList();

    private final int timeRemaining;

    /**
     * @param player        Le joueur qui a déclenché l'event
     * @param profileInfo   Le profil du joueur
     * @param timeRemaining Le temps restant avant que le joueur meure de déconnexion
     */
    public GameLeavePlayerEvent(Player player, ProfileInfo profileInfo, int timeRemaining) {
        super(player, profileInfo);
        this.timeRemaining = timeRemaining;
    }

    /**
     * Permet de récupérer le temps restant avant que le joueur meure de déconnexion
     *
     * @return Le temps restant avant que le joueur meure de déconnexion
     */
    public int getTimeRemaining() {
        return timeRemaining;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
