package fr.rhodless.akira.uhc.api.game.config.list;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface ConfigurationBorder {
    /**
     * Permet de récupérer la taille de la bordure au début de la partie.
     *
     * @return La taille de la bordure au début de la partie
     */
    int getInitialBorder();

    /**
     * Permet de définir la taille de la bordure au début de la partie.
     *
     * @param initialBorder La taille de la bordure au début de la partie
     */
    void setInitialBorder(int initialBorder);

    /**
     * Permet de récupérer jusqu'à quelle taille la bordure doit rétrécir.
     *
     * @return Jusqu'à quelle taille la bordure doit rétrécir
     */
    int getFinalBorder();

    /**
     * Permet de définir jusqu'à quelle taille la bordure doit rétrécir.
     *
     * @param finalBorder Jusqu'à quelle taille la bordure doit rétrécir
     */
    void setFinalBorder(int finalBorder);

    /**
     * Permet de récupérer le nombre de blocs par seconde que la bordure doit rétrécir.
     *
     * @return Le nombre de blocs par seconde que la bordure doit rétrécir
     */
    double getBorderBlockPerSecond();

    /**
     * Permet de définir le nombre de blocs par seconde que la bordure doit rétrécir.
     *
     * @param borderBlockPerSecond Le nombre de blocs par seconde que la bordure doit rétrécir
     */
    void setBorderBlockPerSecond(double borderBlockPerSecond);
}
