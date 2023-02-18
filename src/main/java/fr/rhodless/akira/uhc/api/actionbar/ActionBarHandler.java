package fr.rhodless.akira.uhc.api.actionbar;

import org.bukkit.entity.Player;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface ActionBarHandler {
    /**
     * Permet d'ajouter une valeur à l'actionbar du joueur.
     *
     * @param player      le joueur
     * @param actionBarValue la valeur à ajouter
     */
    void addActionBarValue(Player player, ActionBarValue actionBarValue);

    /**
     * Permet de supprimer une valeur de l'actionbar du joueur.
     *
     * @param player le joueur
     * @param id     l'id de la valeur
     */
    void removeActionBarValue(Player player, String id);

    /**
     * Permet de récupérer la valeur finale de l'actionbar du joueur.
     *
     * @param player le joueur
     * @return la valeur de la hotbar du joueur
     */
    String getFinalRender(Player player);
}
