package fr.rhodless.akira.uhc.api;

import fr.rhodless.akira.uhc.api.command.CommandHandler;
import fr.rhodless.akira.uhc.api.game.GameHandler;
import fr.rhodless.akira.uhc.api.actionbar.ActionBarHandler;
import fr.rhodless.akira.uhc.api.item.ItemHandler;
import fr.rhodless.akira.uhc.api.module.ModuleHandler;
import fr.rhodless.akira.uhc.api.npc.NPCHandler;
import fr.rhodless.akira.uhc.api.player.PlayerHandler;
import fr.rhodless.akira.uhc.api.prefix.PrefixHandler;
import fr.rhodless.akira.uhc.api.saves.SavedConfigurationHandler;
import fr.rhodless.akira.uhc.api.tablist.TabListHandler;
import fr.rhodless.akira.uhc.api.world.WorldHandler;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public class API {
    private static Implementation implementation;

    /**
     * Permet de définir l'implémentation de l'API.
     * Si l'implémentation est déjà définie, une exception sera lancée.
     *
     * @param implementation l'implémentation de l'API
     */
    public static void setImplementation(Implementation implementation) {
        API.implementation = implementation;
    }

    /**
     * Permet de récupérer le plugin bukkit de l'API.
     *
     * @return le plugin bukkit de l'API
     */
    public static JavaPlugin getPlugin() {
        return implementation.getPlugin();
    }

    /**
     * Permet de récupérer le gestionnaire de commandes.
     *
     * @return le gestionnaire de commandes
     */
    public static CommandHandler getCommandHandler() {
        return implementation.getCommandHandler();
    }

    /**
     * Permet de récupérer le gestionnaire de partie.
     *
     * @return le gestionnaire de partie
     */
    public static GameHandler getGameHandler() {
        return implementation.getGameHandler();
    }

    /**
     * Permet de récupérer le gestionnaire de joueurs.
     *
     * @return le gestionnaire de joueurs
     */
    public static PlayerHandler getPlayerHandler() {
        return implementation.getPlayerHandler();
    }

    /**
     * Permet de récupérer le gestionnaire de monde.
     *
     * @return le gestionnaire de monde
     */
    public static WorldHandler getWorldHandler() {
        return implementation.getWorldHandler();
    }

    /**
     * Permet de récupérer le gestionnaire de modules.
     *
     * @return le gestionnaire de modules
     */
    public static ModuleHandler getModuleHandler() {
        return implementation.getModuleHandler();
    }

    /**
     * Permet de récupérer le gestionnaire de configuration.
     *
     * @return le gestionnaire de configuration
     */
    public static SavedConfigurationHandler getSavedConfigurationHandler() {
        return implementation.getSavedConfigurationHandler();
    }

    /**
     * Permet de récupérer le gestionnaire de tablist.
     *
     * @return le gestionnaire de tablist
     */
    public static TabListHandler getTabListHandler() {
        return implementation.getTabListHandler();
    }

    /**
     * Permet de récupérer le gestionnaire de l'actionbar.
     *
     * @return le gestionnaire d'actionbar
     */
    public static ActionBarHandler getActionBarHandler() {
        return implementation.getActionBarHandler();
    }

    /**
     * Permet de récupérer le gestionnaire de prefix.
     *
     * @return le gestionnaire de prefix
     */
    public static PrefixHandler getPrefixHandler() {
        return implementation.getPrefixHandler();
    }

    /**
     * Permet de récupérer le gestionnaire d'item.
     *
     * @return le gestionnaire d'item
     */
    public static ItemHandler getItemHandler() {
        return implementation.getItemHandler();
    }

    /**
     * Permet de récupérer le gestionnaire de NPC.
     *
     * @return le gestionnaire de NPC
     */
    public static NPCHandler getNpcHandler() {
        return implementation.getNpcHandler();
    }

    public interface Implementation {
        JavaPlugin getPlugin();

        CommandHandler getCommandHandler();

        GameHandler getGameHandler();

        PlayerHandler getPlayerHandler();

        WorldHandler getWorldHandler();

        ModuleHandler getModuleHandler();

        SavedConfigurationHandler getSavedConfigurationHandler();

        TabListHandler getTabListHandler();

        ActionBarHandler getActionBarHandler();

        PrefixHandler getPrefixHandler();

        NPCHandler getNpcHandler();

        ItemHandler getItemHandler();
    }
}
