package fr.rhodless.akira.uhc.api.game.config;

import fr.rhodless.akira.uhc.api.game.config.list.*;
import fr.rhodless.akira.uhc.api.module.Module;
import fr.rhodless.akira.uhc.api.module.camp.Camp;
import fr.rhodless.akira.uhc.api.module.role.QuickRoleInfo;

import java.util.List;
import java.util.UUID;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface GameConfiguration {
    /**
     * Permet de récupérer l'id unique de la configuration.
     *
     * @return l'id unique de la configuration
     */
    UUID getUniqueId();

    /**
     * Permet de définir l'id unique de la configuration.
     *
     * @param uniqueId l'id unique de la configuration
     */
    void setUniqueId(UUID uniqueId);

    /**
     * Permet de récupérer le nom custom de la configuration.
     * Ce nom sera utilisé dans le scoreboard en tant que titre.
     *
     * @return le nom custom de la configuration
     */
    String getName();

    /**
     * Permet de définir le nom custom de la configuration.
     *
     * @param name le nom custom de la configuration
     */
    void setName(String name);

    /**
     * Permet de récupérer si les spectateurs sont activés.
     * Si les spectateurs sont activés, alors n'importe qui peut rejoindre la partie en tant que spectateur.
     * Les spectateurs peuvent voir les joueurs vivants, mais ne peuvent pas interagir avec eux.
     * Si les spectateurs sont désactivés, alors seuls les joueurs vivants peuvent rejoindre la partie.
     *
     * @return true si la configuration est en mode spectateur
     */
    boolean isSpectator();

    /**
     * Permet de définir le nom de la configuration.
     *
     * @param spectator true si la configuration est en mode spectateur
     */
    void setSpectator(boolean spectator);

    /**
     * Permet de récupérer le nombre de slots maximum de la partie.
     * Par exemple, si le nombre de slots est de 20, alors la partie ne pourra pas dépasser 20 joueurs.
     *
     * @return true si la configuration est en mode whitelist
     */
    int getSlots();

    /**
     * Permet de définir le nombre de slots de la configuration.
     *
     * @param slots le nombre de slots de la configuration
     */
    void setSlots(int slots);

    /**
     * Permet de récupérer si la partie a la whitelist d'activée.
     * Si la whitelist est activée, alors seuls les joueurs qui sont dans la whitelist peuvent rejoindre la partie.
     * Si la whitelist est désactivée, alors tout le monde peut rejoindre la partie.
     *
     * @return true si la configuration est en mode whitelist
     */
    boolean isWhitelist();

    /**
     * Permet de définir le nombre de slots de la configuration.
     *
     * @param whitelist true si la configuration est en mode whitelist
     */
    void setWhitelist(boolean whitelist);

    /**
     * Permet de récupérer si la partie a la composition cachée d'activée.
     * Si la composition est cachée, alors les joueurs ne verront pas les rôles de la partie en utilisant la commande /module roles.
     *
     * @return true si la configuration est en mode composition cachée
     */
    boolean isHiddenComposition();

    /**
     * Permet de définir si la partie a la composition cachée d'activée.
     *
     * @param hiddenComposition true si la configuration est en mode composition cachée
     */
    void setHiddenComposition(boolean hiddenComposition);

    /**
     * Permet de récupérer le nombre maximum de groupes pour la partie.
     * Par exemple, si le nombre de groupes est de 2, alors les joueurs ne peuvent pas dépasser 2 personnes.
     *
     * @return le nombre maximum de groupes
     */
    int getGroups();

    /**
     * Permet de définir le nombre maximum de groupes pour la partie.
     *
     * @param groups le nombre maximum de groupes
     */
    void setGroups(int groups);

    /**
     * Permet de récupérer la liste des rôles activés pour la partie.
     * Cette liste est utilisée pour définir les rôles de la partie.
     * Ces rôles seront distribués aléatoirement aux joueurssi le module de distribution
     * des rôles est activé {@link Module#isEnabledRoles()}
     *
     * @return la liste des rôles activés pour la partie
     */
    List<QuickRoleInfo> getEnabledRoles();

    /**
     * Permet de récupérer la liste des rôles activés pour la partie appartenant au camp donné.
     *
     * @param camp le camp dont on veut récupérer les rôles
     * @return la liste des rôles activés pour la partie appartenant au camp donné
     */
    List<QuickRoleInfo> getEnabledRoles(Camp camp);

    /**
     * Permet de récupérer le nombre de fois que le rôle donné est activé pour la partie.
     * Par exemple, si un rôle est activé 2 fois, alors le nombre retourné sera de 2.
     *
     * @param quickRoleInfo le rôle dont on veut récupérer le nombre
     * @return le nombre de fois que le rôle donné est activé pour la partie
     */
    int getEnabledRolesCount(QuickRoleInfo quickRoleInfo);

    /**
     * Permet de récupérer la configuration de la bordure
     *
     * @return la configuration de la bordure
     */
    ConfigurationBorder getBorder();

    /**
     * Permet de récupérer la configuration des limites
     *
     * @return la configuration des limites
     */
    ConfigurationLimits getLimits();

    /**
     * Permet de récupérer la configuration des taux
     *
     * @return la configuration des taux
     */
    ConfigurationRates getRates();

    /**
     * Permet de récupérer la configuration des timers
     *
     * @return la configuration des timers
     */
    ConfigurationTimers getTimers();

    /**
     * Permet de récupérer la configuration des enchantements
     *
     * @return la configuration des enchantements
     */
    ConfigurationEnchantments getEnchantments();

    /**
     * Permet de récupérer la configuration des règles
     *
     * @return la configuration des règles
     */
    ConfigurationRules getRules();

    /**
     * Permet de récupérer la configuration des inventaires
     *
     * @return la configuration des inventaires
     */
    ConfigurationInventories getInventories();
}