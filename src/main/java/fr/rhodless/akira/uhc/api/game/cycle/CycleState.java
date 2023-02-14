package fr.rhodless.akira.uhc.api.game.cycle;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public enum CycleState {
    DAY("Jour"),
    NIGHT("Nuit");

    private final String name;

    /**
     * Permet de créer un cycle.
     *
     * @param name le nom du cycle
     */
    CycleState(String name) {
        this.name = name;
    }

    /**
     * Permet de récupérer le nom du cycle.
     *
     * @return le nom du cycle
     */
    public String getName() {
        return name;
    }
}
