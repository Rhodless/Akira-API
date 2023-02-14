package fr.rhodless.akira.uhc.api.npc;

import java.util.List;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface NPCHandler {
    /**
     * Récupère la liste de tous les NPC du lobby
     *
     * @return la liste de tous les NPC du lobby
     */
    List<NPC> getLobbyNPCs();

    /**
     * Permet de faire spawn un npc.
     *
     * @param npc le npc à spawn
     */
    void spawn(NPC npc);

    /**
     * Permet de charger tous les NPC du lobby afin de les faire spawn.
     */
    void loadNPCs();
}
