package fr.rhodless.akira.uhc.api.player.info.plate;

import org.bukkit.Location;
import org.bukkit.entity.Player;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface ProfileTeleportPlate {
    /**
     * Permet de récupérer le centre de la plaque.
     *
     * @return le centre de la plaque
     */
    Location getCenter();

    /**
     * Permet de créer la plaque.
     * Permet de créer la plaque.
     */
    void create();

    /**
     * Permet de supprimer la plaque.
     *
     * @param player le joueur à ajouter
     */
    void remove(Player player);
}
