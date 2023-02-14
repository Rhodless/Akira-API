package fr.rhodless.akira.uhc.api.module.timer;

import org.bukkit.inventory.ItemStack;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public abstract class ModuleTimer {
    private int timer = 0;
    private final String name;
    private int initialDuration;

    /**
     * Lorsque la partie sera lancée, le timer sera initialisé avec cette valeur.
     * Une fois que le timer atteindra 0, la méthode {@link #onEnable()} sera appelée.
     *
     * @param name            le nom du timer
     * @param initialDuration la durée initiale du timer
     */
    public ModuleTimer(String name, int initialDuration) {
        this.name = name;
        this.initialDuration = initialDuration;
    }

    /**
     * Permet de récupérer l'item qui représente le timer
     *
     * @return l'item qui représente le timer
     */
    public abstract ItemStack getDisplay();

    /**
     * Cette méthode est appelée lorsque le timer est activé
     */
    public abstract void onEnable();

    /**
     * Permet de récupérer le nom du timer
     *
     * @return le nom du timer
     */
    public int getTimer() {
        return timer;
    }

    /**
     * Permet de définir le timer
     *
     * @param timer le timer
     */
    public void setTimer(int timer) {
        this.timer = timer;
    }

    /**
     * Permet de récupérer le nom du timer
     *
     * @return le nom du timer
     */
    public String getName() {
        return name;
    }

    /**
     * Permet de récupérer la durée initiale du timer
     *
     * @return la durée initiale du timer
     */
    public int getInitialDuration() {
        return initialDuration;
    }

    /**
     * Permet de définir la durée initiale du timer
     *
     * @param initialDuration la durée initiale du timer
     */
    public void setInitialDuration(int initialDuration) {
        this.initialDuration = initialDuration;
    }
}
