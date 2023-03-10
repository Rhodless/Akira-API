package fr.rhodless.akira.uhc.api.game;

import fr.rhodless.akira.uhc.api.game.config.GameConfiguration;
import fr.rhodless.akira.uhc.api.game.cycle.CycleHandler;
import fr.rhodless.akira.uhc.api.game.episode.EpisodeHandler;
import fr.rhodless.akira.uhc.api.game.scenario.ScenarioHandler;
import fr.rhodless.akira.uhc.api.game.start.StartHandler;
import fr.rhodless.akira.uhc.api.game.state.GameState;
import fr.rhodless.akira.uhc.api.module.win.WinHandler;

import java.util.Queue;
import java.util.UUID;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface GameHandler {
    /**
     * Permet de récupérer la configuration de la partie.
     *
     * @return la configuration de la partie.
     */
    GameConfiguration getGameConfiguration();

    /**
     * Permet de définir la configuration de la partie.
     *
     * @param gameConfiguration la configuration de la partie.
     */
    void setGameConfiguration(GameConfiguration gameConfiguration);

    /**
     * Permet de récupérer le handler de démarrage de la partie.
     *
     * @return le handler de démarrage de la partie.
     */
    StartHandler getStartHandler();

    /**
     * Permet de récupérer le handler des épisodes de la partie.
     *
     * @return le handler des épisodes de la partie.
     */
    EpisodeHandler getEpisodeHandler();

    /**
     * Permet de récupérer le handler des cycles de la partie.
     *
     * @return le handler des cycles de la partie.
     */
    CycleHandler getCycleHandler();

    /**
     * Permet de récupérer le handler des scénarios de la partie.
     *
     * @return le handler des scénarios de la partie.
     */
    ScenarioHandler getScenarioHandler();

    /**
     * Permet de récupérer le handler des victoires de la partie.
     *
     * @return le handler des victoires de la partie.
     */
    WinHandler getWinHandler();

    /**
     * Permet de récupérer le host de la partie.
     *
     * @return le host de la partie.
     */
    UUID getHost();

    /**
     * Permet de définir le host de la partie.
     *
     * @param host le host de la partie.
     */
    void setHost(UUID host);

    /**
     * Permet de récupérer la liste des co-hosts de la partie.
     *
     * @return la liste des co-hosts de la partie.
     */
    Queue<UUID> getCoHosts();

    /**
     * Permet de récupérer la liste des joueurs de la partie.
     *
     * @return la liste des joueurs de la partie.
     */
    Queue<UUID> getPlayers();

    /**
     * Permet de récupérer la liste des whitelistés de la partie.
     *
     * @return la liste des whitelistés de la partie.
     */
    Queue<String> getWhitelistedPlayers();

    /**
     * Permet de récupérer le game state de la partie.
     *
     * @return le game state de la partie.
     */
    GameState getGameState();

    /**
     * Permet de définir le game state de la partie.
     *
     * @param gameState le game state de la partie.
     */
    void setGameState(GameState gameState);

    /**
     * Permet de récupérer si un joueur est whitelisté.
     *
     * @param name le nom du joueur.
     * @return true si le joueur est whitelisté.
     */
    boolean isWhitelisted(String name);

    /**
     * Permet de voir la liste des joueurs qui ont activé le mode Whitelist Setup.
     * Ce mode permet de whitelister un joueur en rentrant son pseudo dans le chat.
     * Ce mode permet également d'ajouter plusieurs joueur en même temps en les séparant par un espace.
     * Exemple : "/whitelist setup", then "Rhodless Rhodless1 Rhodless2"
     *
     * @return la liste des joueurs qui ont activé le mode Whiteliset Setup.
     */
    Queue<UUID> getWhitelistSetup();

    /**
     * Permet de récupérer la durée de la partie.
     *
     * @return la durée de la partie.
     */
    int getDuration();

    /**
     * Permet de définir la durée de la partie.
     *
     * @param duration la durée de la partie.
     */
    void setDuration(int duration);

    /**
     * Permet de récupérer si le chat est activé.
     *
     * @return true si le chat est activé.
     */
    boolean isChat();

    /**
     * Permet de définir si le chat est activé.
     *
     * @param chat true si le chat est activé.
     */
    void setChat(boolean chat);
}
