package fr.rhodless.akira.uhc.api.game.scenario;

import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface Scenario extends Listener {
    /**
     * Permet de récupérer le nom du scénario.
     *
     * @return le nom du scénario
     */
    String getName();

    /**
     * Permet de récupérer la description du scénario.
     *
     * @return la description du scénario
     */
    List<String> getDescription();

    /**
     * Permet de récupérer l'item qui représente le scénario.
     * Cet item est affiché dans le menu des scénarios.
     *
     * @return l'item qui représente le scénario
     */
    ItemStack getIcon();

    /**
     * Permet de récupérer le type du scénario.
     *
     * @return le type du scénario
     */
    ScenarioType getCategory();

    /**
     * Permet de récupérer si le scénario est activé après le pvp.
     *
     * @return true si le scénario reste activé après le pvp
     */
    boolean afterPvP();

    /**
     * Cette méthode est appelée lors du début de la partie.
     */
    default void onGameStart() {

    }
}
