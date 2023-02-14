package fr.rhodless.akira.uhc.api.module.camp;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public abstract class Camp {
    private final String name;
    private final ChatColor color;
    private final ItemStack display;
    private final boolean solo;

    /**
     * @param name    le nom du camp
     * @param color   la couleur du camp
     * @param display l'item de présentation du camp
     * @param solo    si le camp est solo ou non
     */
    public Camp(String name, ChatColor color, ItemStack display, boolean solo) {
        this.name = name;
        this.color = color;
        this.display = display;
        this.solo = solo;
    }

    /**
     * Permet de récupérer le nom du camp.
     *
     * @return le nom du camp
     */
    public String getName() {
        return name;
    }

    /**
     * Permet de récupérer la couleur du camp.
     *
     * @return la couleur du camp
     */
    public ChatColor getColor() {
        return color;
    }

    /**
     * Permet de récupérer l'item de présentation du camp.
     *
     * @return l'item de présentation du camp
     */
    public ItemStack getDisplay() {
        return display;
    }

    /**
     * Permet de savoir si le camp est solo ou non.
     *
     * @return si le camp est solo ou non
     */
    public boolean isSolo() {
        return solo;
    }
}
