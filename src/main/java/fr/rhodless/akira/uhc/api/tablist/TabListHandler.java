package fr.rhodless.akira.uhc.api.tablist;

import org.bukkit.entity.Player;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface TabListHandler {
    /**
     * Permet d'envoyer la tablist au joueur.
     * La tablist est récupérée dans le fichier de configuration.
     *
     * @param player le joueur
     */
    void send(Player player);
}
