package fr.rhodless.akira.uhc.api.game.episode;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface EpisodeHandler {
    /**
     * Permet de récupérer le numéro de l'épisode actuel.
     * La partie commence avec l'épisode 0. Chaque épisode dure 20 minutes.
     *
     * @return le numéro de l'épisode actuel
     */
    int getEpisode();

    /**
     * Permet de définir le numéro de l'épisode actuel.
     *
     * @param episode le numéro de l'épisode actuel
     */
    void setEpisode(int episode);

    /**
     * Cette méthode est appelée lors du début de la partie.
     */
    void onStart();

    /**
     * Permet de récupérer le temps avant le prochain épisode en secondes.
     * Par exemple, si l'épisode est à 19 minutes et 30 secondes, cette méthode retournera 30 secondes.
     *
     * @return le temps avant le prochain épisode en secondes
     */
    int getTimeBeforeNextEpisode();
}
