package fr.rhodless.akira.uhc.api.world;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.HashMap;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface WorldHandler {
    /**
     * Permet de récupérer le status actuel du monde uhc.
     * Si le monde n'existe pas, le status sera "NOT_CREATED".
     * Si le monde existe, mais qu'il n'a pas été généré, le status sera "CREATED".
     * Si le monde a été généré, le status sera "GENERATED".
     *
     * @return le status actuel du monde uhc
     */
    WorldConfigurationStatus getCurrentStatus();

    /**
     * Permet de changer le status du monde uhc.
     *
     * @param status le nouveau status du monde uhc
     */
    void setCurrentStatus(WorldConfigurationStatus status);

    /**
     * Permet de récupérer la liste des taux de génération des blocs.
     *
     * @return la liste des taux de génération des blocs
     */
    HashMap<Material, Integer> getRates();

    /**
     * Permet de récupérer le taux de génération d'un bloc.
     *
     * @return le monde uhc
     */
    World getWorld();

    /**
     * Permet de changer le monde uhc.
     *
     * @param world le nouveau monde uhc
     */
    void setWorld(World world);

    /**
     * Permet de récupérer le taux de génération des blocs de type "cave".
     *
     * @return le taux de génération des blocs de type "cave"
     */
    int getCaveRate();

    /**
     * Permet de changer le taux de génération des blocs de type "cave".
     *
     * @param rate le nouveau taux de génération des blocs de type "cave"
     */
    void setCaveRate(int rate);

    /**
     * Permet de créer un monde.
     * Le monde ne peut pas être créé s'il est déjà créé.
     *
     * @param player le joueur
     */
    void createWorld(Player player);

    /**
     * Permet de supprimer un monde.
     * Le monde ne peut pas être supprimé s'il n'est pas créé.
     *
     * @param player le joueur
     */
    void deleteWorld(Player player);

    /**
     * Permet de téléporter un joueur dans le monde uhc.
     * Le joueur ne peut pas être téléporté si le monde n'est pas créé.
     *
     * @param player le joueur
     */
    void teleportToWorld(Player player);

    /**
     * Permet de générer le monde uhc.
     * Le monde ne peut pas être généré s'il n'est pas créé.l
     *
     * @param player le joueur
     */
    void generateWorld(Player player);
}
