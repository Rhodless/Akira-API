package fr.rhodless.akira.uhc.api.module.win;

import org.bukkit.Location;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface WinHandler {
    /**
     * Permet de savoir si la game a déjà été gagnée
     *
     * @return true si la game a déjà été gagnée
     */
    boolean isWon();

    /**
     * Permet de définir si la game a déjà été gagnée
     *
     * @param won true si la game a déjà été gagnée
     */
    void setWon(boolean won);

    /**
     * Permet de vérifier si la game peut être gagnée
     */
    void attemptWin();

    /**
     * Permet de lancer des feux d'artifices
     *
     * @param location le lieu où les feux d'artifices doivent être lancés
     * @param amount   le nombre de feux d'artifices à lancer
     */
    void spawnFireworks(Location location, int amount);
}
