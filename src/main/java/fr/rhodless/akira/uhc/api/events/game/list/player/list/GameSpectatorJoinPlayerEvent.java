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
 * Cet event est appelée quand un joueur rejoint le mode spectateur.
 */
public class GameSpectatorJoinPlayerEvent extends GamePlayerEvent {
    private static final HandlerList HANDLERS = new HandlerList();

    private Result result = Result.ALLOW;
    private String resultMessage;

    /**
     * Cet event est appelée quand un joueur rejoint le mode spectateur.
     *
     * @param player      Le joueur qui a déclenché l'event
     * @param profileInfo Le profil du joueur
     */
    public GameSpectatorJoinPlayerEvent(Player player, ProfileInfo profileInfo) {
        super(player, profileInfo);
    }

    /**
     * Permet de récupérer le résultat de l'event.
     *
     * @return Le résultat de l'event
     */
    public Result getResult() {
        return result;
    }

    /**
     * Permet de définir le résultat de l'event.
     *
     * @param result Le résultat de l'event
     */
    public void setResult(Result result) {
        this.result = result;
    }

    /**
     * Permet de récupérer le message de résultat de l'event.
     *
     * @return Le message de résultat de l'event
     */
    public String getResultMessage() {
        return resultMessage;
    }

    /**
     * Permet de définir le message de résultat de l'event.
     *
     * @param resultMessage Le message de résultat de l'event
     */
    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    /**
     * Les résultats possibles de l'event.
     */
    public enum Result {
        /**
         * Le joueur est autorisé à rejoindre le mode spectateur.
         */
        ALLOW,
        /**
         * Le joueur est refusé à rejoindre le mode spectateur.
         */
        KICK
    }
}
