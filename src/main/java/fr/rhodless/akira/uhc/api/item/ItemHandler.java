package fr.rhodless.akira.uhc.api.item;

import org.bukkit.entity.Player;
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
public interface ItemHandler {
    /**
     * Permet de récupérer la liste de tous les items du lobby
     *
     * @return la liste de tous les items du lobby
     */
    List<Item> getItems();

    /**
     * Permet de charger tous les items du lobby afin de les faire spawn.
     */
    void loadItems();

    /**
     * Permet de gérer l'interaction avec un item.
     *
     * @param itemStack l'item avec lequel l'interaction a été faite
     * @param player    le joueur qui a fait l'interaction
     */
    void handleInteraction(ItemStack itemStack, Player player, boolean spectator);
}
