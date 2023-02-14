package fr.rhodless.akira.uhc.api.player;

import fr.rhodless.akira.uhc.api.player.info.ProfileInfo;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.UUID;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface PlayerHandler {
    /**
     * Permet de récupérer la liste des profils.
     *
     * @return la liste des profils
     */
    HashMap<UUID, ProfileInfo> getProfiles();

    /**
     * Permet de récupérer le profil du joueur.
     * Si le joueur n'a pas de profil, il sera créé.
     *
     * @param player le joueur
     * @return le profil du joueur
     */
    ProfileInfo getProfile(Player player);

    /**
     * Permet de récupérer le profil du joueur.
     * Si le joueur n'a pas de profil, la méthode retournera null.
     *
     * @param uuid l'uuid du joueur
     * @return le profil du joueur
     */
    @Nullable
    ProfileInfo getProfile(UUID uuid);
}
