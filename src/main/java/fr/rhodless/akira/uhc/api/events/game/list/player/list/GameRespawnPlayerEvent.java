package fr.rhodless.akira.uhc.api.events.game.list.player.list;

import fr.rhodless.akira.uhc.api.events.game.list.player.GamePlayerEvent;
import fr.rhodless.akira.uhc.api.player.info.ProfileInfo;
import org.bukkit.Location;
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
public class GameRespawnPlayerEvent extends GamePlayerEvent {
    public static final HandlerList HANDLERS = new HandlerList();

    private final Location respawnLocation;

    /**
     * Cet event est appelée quand un joueur respawn.
     *
     * @param player          Le joueur qui respawn
     * @param profile         Le profile du joueur
     * @param respawnLocation La location de respawn
     */
    public GameRespawnPlayerEvent(Player player, ProfileInfo profile, Location respawnLocation) {
        super(player, profile);
        this.respawnLocation = respawnLocation;
    }

    /**
     * Permet de récupérer la location de respawn.
     *
     * @return La location de respawn
     */
    public Location getRespawnLocation() {
        return respawnLocation;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
