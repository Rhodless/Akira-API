package fr.rhodless.akira.uhc.api.module.event;

import org.bukkit.inventory.ItemStack;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public abstract class ModuleEvent {
    private final String name;
    private boolean active = true;

    /**
     * Permet de créer un event custom pour le module.
     *
     * @param name le nom du module
     */
    public ModuleEvent(String name) {
        this.name = name;
    }

    /**
     * Permet de récupérer le nom du module.
     *
     * @return le nom du module
     */
    public String getName() {
        return name;
    }

    /**
     * Permet de savoir si le module est actif ou non.
     *
     * @return si le module est actif ou non
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Permet de définir si le module est actif ou non.
     *
     * @param active si le module est actif ou non
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Permet de récupérer l'item qui représente l'event dans le menu de configuration.
     *
     * @return l'item qui représente l'event dans le menu de configuration
     */
    public abstract ItemStack getDisplay();

    public abstract void onEnable();
}
