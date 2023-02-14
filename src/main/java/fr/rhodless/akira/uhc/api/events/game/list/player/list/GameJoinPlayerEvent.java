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
 * Cet event est appelée quand un joueur rejoint une partie lorsqu'elle est en cours.
 * L'event n'est pas appelé si le joueur rejoint la partie en tant que spectateur
 *
 * @see GameSpectatorJoinPlayerEvent
 * @see ProfileInfo#isAlive()
 */
public class GameJoinPlayerEvent extends GamePlayerEvent {
    public static final HandlerList HANDLERS = new HandlerList();

    /**
     * @param player      Le joueur qui a déclenché l'event
     * @param profileInfo Le profil du joueur
     */
    public GameJoinPlayerEvent(Player player, ProfileInfo profileInfo) {
        super(player, profileInfo);
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
