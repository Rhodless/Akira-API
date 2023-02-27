package fr.rhodless.akira.uhc.api.item;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public class Item implements ConfigurationSerializable {
    private final ItemStack itemStack;
    private final int slot;
    private final boolean onlyHost;
    private final String command;
    private final boolean spectator;

    /**
     * @param itemStack l'item
     * @param slot      la position de l'item
     * @param onlyHost  si l'item est seulement pour l'hôte
     * @param command   la commande à exécuter
     * @param spectator si l'item est pour les spectateurs
     */
    public Item(ItemStack itemStack, int slot, boolean onlyHost, String command, boolean spectator) {
        this.itemStack = itemStack;
        this.slot = slot;
        this.onlyHost = onlyHost;
        this.command = command;
        this.spectator = spectator;
    }

    /**
     * Permet de récupérer l'item.
     *
     * @return l'item
     */
    public ItemStack getItemStack() {
        return itemStack;
    }

    /**
     * Permet de récupérer la position de l'item.
     *
     * @return la position de l'item
     */
    public int getSlot() {
        return slot;
    }

    /**
     * Permet de savoir si l'item est seulement pour l'hôte.
     *
     * @return si l'item est seulement pour l'hôte
     */
    public boolean isOnlyHost() {
        return onlyHost;
    }

    /**
     * Permet de récupérer la commande à exécuter.
     *
     * @return la commande à exécuter
     */
    public String getCommand() {
        return command;
    }

    public boolean isSpectator() {
        return spectator;
    }

    /**
     * Permet de serializer l'item pour la configuration bukkit.
     *
     * @return la map de l'item
     */
    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> data = new HashMap<>();
        data.put("itemStack", itemStack);
        data.put("slot", slot);
        data.put("onlyHost", onlyHost);
        data.put("command", command);
        data.put("spectator", spectator);
        return data;
    }

    /**
     * Permet de désérialiser l'item pour la configuration bukkit.
     *
     * @param args la map de l'item
     * @return l'item
     */
    public static Item deserialize(Map<String, Object> args) {
        return new Item(
                (ItemStack) args.get("itemStack"),
                (int) args.get("slot"),
                (boolean) args.get("onlyHost"),
                (String) args.get("command"),
                (boolean) args.get("spectator")
        );
    }
}
