package fr.rhodless.akira.uhc.api.saves;

import fr.rhodless.akira.uhc.api.game.config.GameConfiguration;

import java.util.List;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface SavedConfigurationHandler {
    /**
     * Permet de récupérer la liste des configurations sauvegardées.
     *
     * @return la liste des configurations sauvegardées
     */
    List<GameConfiguration> getSavedConfigurations();

    /**
     * Permet de sauvegarder une configuration.
     *
     * @param configuration la configuration à sauvegarder
     */
    void saveConfiguration(GameConfiguration configuration);

    /**
     * Permet de supprimer une configuration.
     *
     * @param configuration la configuration à supprimer
     */
    void deleteConfiguration(GameConfiguration configuration);

    /**
     * Permet de charger une configuration.
     *
     * @param configuration la configuration à charger
     */
    void loadConfiguration(GameConfiguration configuration);

    /**
     * Permet de vérifier si une configuration existe.
     * Cette méthode vérifie sur l'uuid de la configuration est déjà utilisée.
     *
     * @param configuration la configuration à vérifier
     * @return true si la configuration existe
     */
    boolean exists(GameConfiguration configuration);
}
