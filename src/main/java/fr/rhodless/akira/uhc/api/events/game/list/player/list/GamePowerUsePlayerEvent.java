package fr.rhodless.akira.uhc.api.events.game.list.player.list;

import fr.rhodless.akira.uhc.api.events.game.list.player.GamePlayerEvent;
import fr.rhodless.akira.uhc.api.module.power.Power;
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
 * Event appelé quand un joueur utilise un pouvoir.
 */
public class GamePowerUsePlayerEvent extends GamePlayerEvent {
    public static final HandlerList HANDLERS = new HandlerList();

    private final Power power;

    /**
     * Cet event est appelée quand un joueur utilise un pouvoir.
     *
     * @param player      Le joueur qui utilise le pouvoir
     * @param profileInfo Le profile du joueur
     * @param power       Le pouvoir utilisé
     */
    public GamePowerUsePlayerEvent(Player player, ProfileInfo profileInfo, Power power) {
        super(player, profileInfo);
        this.power = power;
    }

    /**
     * Permet de récupérer le pouvoir utilisé.
     *
     * @return Le pouvoir utilisé
     */
    public Power getPower() {
        return power;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
