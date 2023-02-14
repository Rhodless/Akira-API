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
public class GameDeathPlayerEvent extends GamePlayerEvent {
    public static final HandlerList HANDLERS = new HandlerList();

    private final Player killer;
    private final boolean disconnect;

    /**
     * Cet event est appelée quand un joueur meurt.
     *
     * @param player     Le joueur qui meurt
     * @param profileInfo Le profile du joueur
     * @param killer     Le joueur qui a tué le joueur
     * @param disconnect Si le joueur est mort de déconnexion
     */
    public GameDeathPlayerEvent(Player player, ProfileInfo profileInfo, Player killer, boolean disconnect) {
        super(player, profileInfo);
        this.killer = killer;
        this.disconnect = disconnect;
    }

    /**
     * Permet de récupérer le joueur qui a tué le joueur.
     *
     * @return Le joueur qui a tué le joueur
     */
    public Player getKiller() {
        return killer;
    }

    /**
     * Permet de savoir si le joueur est mort de déconnexion.
     *
     * @return Si le joueur est mort de déconnexion
     */
    public boolean isDisconnect() {
        return disconnect;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
