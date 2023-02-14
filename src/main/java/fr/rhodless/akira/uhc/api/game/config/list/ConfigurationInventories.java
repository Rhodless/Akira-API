package fr.rhodless.akira.uhc.api.game.config.list;

import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.UUID;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface ConfigurationInventories {
    /**
     * Permet de récupérer l'inventaire qui sera donné à chaque joueur au début de la partie.
     *
     * @return l'inventaire de départ
     */
    ItemStack[] getStartInventory();

    /**
     * Permet de récupérer l'armure qui sera donnée à chaque joueur au début de la partie.
     *
     * @return l'armure de départ
     */
    ItemStack[] getStartArmor();

    /**
     * Permet de définir l'inventaire qui sera donné à chaque joueur au début de la partie.
     *
     * @param startInventory l'inventaire de départ
     */
    void setStartInventory(ItemStack[] startInventory);

    /**
     * Permet de définir l'armure qui sera donnée à chaque joueur au début de la partie.
     *
     * @param startArmor l'armure de départ
     */
    void setStartArmor(ItemStack[] startArmor);

    /**
     * Permet de récupérer la personne qui est en train d'éditer l'inventaire.
     * Si la valeur est null, personne n'est en train d'éditer l'inventaire.
     *
     * @return la personne qui est en train d'éditer l'inventaire
     */
    @Nullable
    UUID getInventoryEditor();

    /**
     * Permet de définir la personne qui est en train d'éditer l'inventaire.
     * Si la valeur est null, personne n'est en train d'éditer l'inventaire.
     *
     * @param uuid la personne qui est en train d'éditer l'inventaire
     */
    void setInventoryEditor(@Nullable UUID uuid);
}
