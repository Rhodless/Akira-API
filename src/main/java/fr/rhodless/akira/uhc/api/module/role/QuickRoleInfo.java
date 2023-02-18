package fr.rhodless.akira.uhc.api.module.role;

import fr.rhodless.akira.uhc.api.module.camp.Camp;
import org.bukkit.inventory.ItemStack;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public class QuickRoleInfo {
    private final String name;
    private final ItemStack display;
    private final Camp camp;
    private final Class<? extends Role> roleClass;

    /**
     * @param name    le nom du rôle
     * @param display l'item qui représente le rôle
     * @param camp    le camp du rôle
     * @param roleClass    la classe du rôle
     */
    public QuickRoleInfo(String name, ItemStack display, Camp camp, Class<? extends Role> roleClass) {
        this.name = name;
        this.display = display;
        this.camp = camp;
        this.roleClass = roleClass;
    }

    /**
     * Permet de récupérer le nom du rôle
     *
     * @return le nom du rôle
     */
    public String getName() {
        return name;
    }

    /**
     * Permet de récupérer l'item qui représente le rôle
     *
     * @return l'item qui représente le rôle
     */
    public ItemStack getDisplay() {
        return display;
    }

    /**
     * Permet de récupérer le camp du rôle
     *
     * @return le camp du rôle
     */
    public Camp getCamp() {
        return camp;
    }

    /**
     * Permet de récupérer la classe du rôle
     *
     * @return la classe du rôle
     */
    public Class<? extends Role> getRoleClass() {
        return roleClass;
    }
}
