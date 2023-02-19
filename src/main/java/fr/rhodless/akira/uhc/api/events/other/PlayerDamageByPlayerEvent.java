package fr.rhodless.akira.uhc.api.events.other;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public class PlayerDamageByPlayerEvent extends Event {
    public static final HandlerList HANDLERS = new HandlerList();

    private final EntityDamageByEntityEvent entityEvent;
    private final Player player;
    private final Player damager;

    /**
     * Cet event est appelée quand un joueur est touché par un autre joueur.
     *
     * @param entityEvent L'EntityDamageByEntityEvent de Bukkit
     * @param player Le joueur attaqué
     * @param damager Le joueur qui a attaqué
     */
    public PlayerDamageByPlayerEvent(EntityDamageByEntityEvent entityEvent, Player player, Player damager) {
        this.entityEvent = entityEvent;
        this.player = player;
        this.damager = damager;
    }

    /**
     * Permet de récupérer l'EntityDamageByEntityEvent de Bukkit.
     * Pour annuler l'event, il faut utiliser {@link EntityDamageByEntityEvent#setCancelled(boolean)}
     * @return L'EntityDamageByEntityEvent de Bukkit
     */
    public EntityDamageByEntityEvent getEntityEvent() {
        return entityEvent;
    }

    /**
     * Permet de récupérer le joueur attaqué.
     * @return Le joueur attaqué
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Permet de récupérer le joueur qui a attaqué.
     * @return Le joueur qui a attaqué
     */
    public Player getDamager() {
        return damager;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
