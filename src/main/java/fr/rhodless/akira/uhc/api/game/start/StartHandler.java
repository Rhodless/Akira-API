package fr.rhodless.akira.uhc.api.game.start;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface StartHandler {
    /**
     * Permet de commencer le processus de démarrage de la partie.
     * Cette fonction commence la génération des points de spawn de tous les joueurs.
     */
    void startProcess();

    /**
     * Permet de commencer la partie.
     */
    void startGame();

    /**
     * @return true si le processus de démarrage est en cours.
     */
    boolean isStarting();

    /**
     * Permet de définir si le processus de démarrage est en cours.
     *
     * @param starting true si le processus de démarrage est en cours.
     */
    void setStarting(boolean starting);
}
