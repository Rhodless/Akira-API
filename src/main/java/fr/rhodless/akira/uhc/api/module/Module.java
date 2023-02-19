package fr.rhodless.akira.uhc.api.module;

import fr.rhodless.akira.uhc.api.module.camp.Camp;
import fr.rhodless.akira.uhc.api.module.role.QuickRoleInfo;
import fr.rhodless.akira.uhc.api.scoreboard.ScoreboardValue;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public abstract class Module {
    private final String name;
    private final String documentURL;
    private final String version;

    /**
     * @param name        le nom du module
     * @param documentURL l'URL du document du module
     * @param version     la version du module
     */
    public Module(String name, String documentURL, String version) {
        this.name = name;
        this.documentURL = documentURL;
        this.version = version;
    }

    /**
     * Permet de savoir si les rôles sont activés
     *
     * @return si les rôles sont activés
     */
    public abstract boolean isEnabledRoles();

    /**
     * Permet de récupérer la couleur principale du module
     *
     * @return la couleur principale du module
     */
    public abstract ChatColor getMainColor();

    /**
     * Permet de récupérer le préfixe des commandes du module
     * Par exemple, si vous faites un Loup-Garou, le préfixe sera "lg", et les commandes seront "lg me", "lg roles", etc...
     *
     * @return le préfixe des commandes du module
     */
    public abstract String getCommandPrefix();

    /**
     * Permet de récupérer les développeurs du module
     *
     * @return les développeurs du module
     */
    public abstract String[] getDevelopers();

    /**
     * Permet de récupérer les game designers du module
     *
     * @return les game designers du module
     */
    public abstract String[] getGameDesigners();

    /**
     * Permet de récupérer les contributeurs du module
     *
     * @return les contributeurs du module
     */
    public abstract String[] getContributors();

    /**
     * Permet de récupérer le camp des héros.
     * Le camp des héros sera affiché en premier dans le menu de configuration des rôles.
     *
     * @return le camp des héros
     */
    public abstract Camp getHeroesCamp();

    /**
     * Permet de récupérer le camp des vilains.
     * Le camp des vilains sera affiché en deuxième dans le menu de configuration des rôles.
     *
     * @return le camp des vilains
     */
    public abstract Camp getVillainsCamp();

    /**
     * Permet de récupérer le 3ème camp.
     * Le 3ème camp sera affiché en troisième dans le menu de configuration des rôles.
     * Si vous n'avez pas de 3ème camp, retournez null.
     *
     * @return le 3ème camp
     */
    public abstract Camp getOtherCamp();

    /**
     * Permet de récupérer la liste des camps.
     *
     * @return la liste des camps
     */
    public abstract List<Camp> getCamps();

    /**
     * Permet de récupérer la liste des rôles.
     *
     * @return la liste des rôles
     */
    public abstract List<QuickRoleInfo> getRoles();

    /**
     * Méthode appelée au démarrage de la partie
     */
    public void onStart() {
    }

    /**
     * Méthode appelée lors d'un nouvel épisode
     *
     * @param episode l'épisode actuel
     */
    public void onEpisode(int episode) {
    }

    /**
     * Méthode appelée lors d'un nouveau jour
     */
    public void onDay() {
    }

    /**
     * Méthode appelée lors d'une nouvelle nuit
     */
    public void onNight() {
    }

    /**
     * Méthode appelée lors de l'annonce des rôles
     */
    public void onRoles() {
    }

    /**
     * Retourne si le module doit annoncer la mort des joueurs
     *
     * @return si le module doit annoncer la mort des joueurs
     */
    public boolean shouldAnnounceDeath() {
        return true;
    }

    /**
     * Retourne si le module doit attendre avant de tuer les joueurs.
     * Par exemple, si un joueur meurt, il ne sera pas tué tout de suite, mais après 10 secondes
     * si personne ne le sauve.
     * Si vous ne voulez pas que l'uhc attende, retournez false.
     *
     * @return si le module doit attendre avant de tuer les joueurs
     */
    public boolean shouldWaitBeforeGameDeath() {
        return true;
    }

    /**
     * Retourne si le module doit drop les items de mort
     *
     * @return si le module doit drop les items de mort
     */
    public boolean shouldDropDeathStuff() {
        return true;
    }

    /**
     * Permet d'ajouter des valeurs au scoreboard.
     * Rajouter une valeur au scoreboard ne supprime pas la ligne en question,
     * mais rajoute une ligne en dessous de celle-ci.
     *
     * @return les valeurs à afficher dans le scoreboard
     */
    public List<ScoreboardValue> getForceScoreboardValues(Player player) {
        return new ArrayList<>();
    }

    /**
     * Permet de récupérer le nom du module
     *
     * @return le nom du module
     */
    public String getName() {
        return name;
    }

    /**
     * Permet de récupérer l'URL du document du module
     *
     * @return l'URL du document du module
     */
    public String getDocumentURL() {
        return documentURL;
    }

    /**
     * Permet de récupérer la version du module
     *
     * @return la version du module
     */
    public String getVersion() {
        return version;
    }
}
