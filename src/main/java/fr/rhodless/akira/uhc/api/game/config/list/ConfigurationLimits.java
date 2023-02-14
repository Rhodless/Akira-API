package fr.rhodless.akira.uhc.api.game.config.list;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface ConfigurationLimits {
    /**
     * Permet de récupérer la limite de diamant que chaque joueur peut miner.
     *
     * @return la limite de diamant
     */
    int getDiamondLimit();

    /**
     * Permet de définir la limite de diamant que chaque joueur peut miner.
     *
     * @param diamondLimit la limite de diamant
     */
    void setDiamondLimit(int diamondLimit);

    /**
     * Permet de récupérer la limite de gold que chaque joueur peut miner.
     *
     * @return la limite de gold que chaque joueur peut miner.
     */
    int getGoldLimit();

    /**
     * Permet de définir la limite de gold que chaque joueur peut miner.
     *
     * @param goldLimit la limite de gold que chaque joueur peut miner.
     */
    void setGoldLimit(int goldLimit);

    /**
     * Permet de récupérer la limite de fer que chaque joueur peut miner.
     *
     * @return la limite de fer que chaque joueur peut miner.
     */
    int getIronLimit();

    /**
     * Permet de définir la limite de fer que chaque joueur peut miner.
     *
     * @param ironLimit la limite de fer que chaque joueur peut miner.
     */
    void setIronLimit(int ironLimit);
}
