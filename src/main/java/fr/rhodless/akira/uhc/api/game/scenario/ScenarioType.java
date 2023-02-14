package fr.rhodless.akira.uhc.api.game.scenario;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public enum ScenarioType {
    MINING("&aMinage"),
    COMBAT("&cCombat"),
    GAMEPLAY("&6Gameplay"),
    OTHER("&7Autre");

    private final String name;

    /**
     * Permet de créer un type de scénario.
     *
     * @param name le nom du type de scénario
     */
    ScenarioType(String name) {
        this.name = name;
    }

    /**
     * Permet de récupérer le nom du type de scénario.
     *
     * @return le nom du type de scénario
     */
    public String getName() {
        return name;
    }
}
