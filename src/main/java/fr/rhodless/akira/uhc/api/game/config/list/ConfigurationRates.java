package fr.rhodless.akira.uhc.api.game.config.list;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface ConfigurationRates {
    /**
     * Permet de récupérer le taux d'apple de la partie.
     *
     * @return l'apple rate de la partie
     */
    int getAppleRate();

    /**
     * Permet de définir le taux d'apple de la partie.
     *
     * @param appleRate l'apple rate de la partie
     */
    void setAppleRate(int appleRate);

    /**
     * Permet de récupérer le taux de flint de la partie.
     *
     * @return le taux de flint de la partie
     */
    int getFlintRate();

    /**
     * Permet de définir le taux de flint de la partie.
     *
     * @param flintRate le taux de flint de la partie
     */
    void setFlintRate(int flintRate);

    /**
     * Permet de récupérer le taux de gold de la partie.
     *
     * @return le taux d'ender pearl de la partie
     */
    int getEnderPearlRate();

    /**
     * Permet de définir le taux de gold de la partie.
     *
     * @param enderPearlRate le taux d'ender pearl de la partie
     */
    void setEnderPearlRate(int enderPearlRate);
}
