package fr.rhodless.akira.uhc.api.player.info;

import fr.rhodless.akira.uhc.api.module.camp.Camp;
import fr.rhodless.akira.uhc.api.module.role.Role;
import fr.rhodless.akira.uhc.api.player.info.death.ProfileDeathProcess;
import fr.rhodless.akira.uhc.api.player.info.plate.ProfileTeleportPlate;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.UUID;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface ProfileInfo {
    /**
     * Permet de récupérer l'uuid du joueur.
     *
     * @return l'uuid du joueur
     */
    UUID getUniqueId();

    /**
     * Permet de récupérer le nom du joueur.
     *
     * @return le nom du joueur
     */
    String getName();

    /**
     * Permet de définir le nom du joueur.
     *
     * @param name le nom du joueur
     */
    void setName(String name);

    /**
     * Permet de récupérer le temps restant avant que le joueur meure de déconnexion.
     * Ce timer diminue chaque seconde si le joueur est déconnecté.
     * Si le timer arrive à 0, le joueur meurt.
     *
     * @return le temps restant avant que le joueur meure de déconnexion
     */
    int getRemainingTime();

    /**
     * Permet de définir le temps restant avant que le joueur meure de déconnexion.
     *
     * @param remainingTime le temps restant avant que le joueur meure de déconnexion
     */
    void setRemainingTime(int remainingTime);

    /**
     * Permet de récupérer le prefix du joueur.
     * Ce prefix est utilisé pour le chat.
     *
     * @return le prefix du joueur
     */
    String getPrefix();

    /**
     * Permet de récupérer la plateforme de téléportation du joueur.
     * Si la valeur est null, le joueur n'a pas de plateforme.
     *
     * @return la plateforme de téléportation du joueur
     */
    @Nullable
    ProfileTeleportPlate getPlate();

    /**
     * Permet de définir la plateforme de téléportation du joueur.
     *
     * @param plate la plateforme de téléportation du joueur
     */
    void setPlate(@Nullable ProfileTeleportPlate plate);

    /**
     * Permet de récupérer la location de mort du joueur.
     * Si la valeur est null, le joueur n'est pas mort.
     * Si la valeur n'est pas null, le joueur est mort.
     * La location de mort est définie lorsqu'un joueur meurt.
     * Elle est utilisée entre autre lors d'un respawn manuel.
     *
     * @return la location de mort du joueur
     */
    Location getDeathLocation();

    /**
     * Permet de définir la location de mort du joueur.
     *
     * @param deathLocation la location de mort du joueur
     */
    void setDeathLocation(Location deathLocation);

    /**
     * Permet de récupérer l'inventaire de mort du joueur
     * Cette valeur est définie lorsqu'un joueur meurt.
     * Elle est utilisée entre autre lors d'un respawn manuel.
     *
     * @return l'inventaire de mort du joueur
     */
    ItemStack[] getDeathInventory();

    /**
     * Permet de définir l'inventaire de mort du joueur.
     *
     * @param deathInventory l'inventaire de mort du joueur
     */
    void setDeathInventory(ItemStack[] deathInventory);

    /**
     * Permet de récupérer l'armure de mort du joueur.
     * Cette valeur est définie lorsqu'un joueur meurt.
     * Elle est utilisée entre autre lors d'un respawn manuel.
     *
     * @return l'armure de mort du joueur
     */
    ItemStack[] getDeathArmor();

    /**
     * Permet de définir l'armure de mort du joueur.
     *
     * @param deathAmor l'armure de mort du joueur
     */
    void setDeathArmor(ItemStack[] deathAmor);

    /**
     * Permet de récupérer le processus de mort du joueur.
     * Ce processus est défini lorsqu'un joueur meurt.
     * 10 secondes après sa mort, si le joueur n'a pas été respawn, alors il meurt définitivement.
     * <p>
     * Si la valeur est null, le joueur n'est pas mort.
     * Si la valeur n'est pas null, le joueur est dans un processus de mort.
     * Lorsque le processus de mort est terminé, la valeur est définie à null.
     *
     * @return le processus de mort du joueur
     */
    @Nullable
    ProfileDeathProcess getDeathProcess();

    /**
     * Permet de définir le processus de mort du joueur.
     *
     * @param deathProcess le processus de mort du joueur
     */
    void setDeathProcess(ProfileDeathProcess deathProcess);

    /**
     * Permet de récupérer les kills du joueur.
     *
     * @return les kills du joueur
     */
    int getKills();

    /**
     * Permet de définir les kills du joueur.
     *
     * @param kills les kills du joueur
     */
    void setKills(int kills);

    /**
     * Permet de récupérer les diamants minés par le joueur.
     *
     * @return les diamants minés par le joueur
     */
    int getMinedDiamonds();

    /**
     * Permet de définir les diamants minés par le joueur.
     *
     * @param minedDiamonds les diamants minés par le joueur
     */
    void setMinedDiamonds(int minedDiamonds);

    /**
     * Permet de récupérer l'or miné par le joueur.
     *
     * @return l'or miné par le joueur
     */
    int getMinedGold();

    /**
     * Permet de définir l'or miné par le joueur.
     *
     * @param minedGold l'or miné par le joueur
     */
    void setMinedGold(int minedGold);

    /**
     * Permet de récupérer le fer miné par le joueur.
     *
     * @return le fer miné par le joueur
     */
    int getMinedIron();

    /**
     * Permet de définir le fer miné par le joueur.
     *
     * @param minedIron le fer miné par le joueur
     */
    void setMinedIron(int minedIron);

    /**
     * Permet de téléporter le joueur au lobby.
     */
    void teleportToLobby();

    /**
     * Permet de réinitialiser l'inventaire du joueur.
     */
    void clearInventory();

    /**
     * Permet d'actualiser l'inventaire du joueur.
     * Cette méthode permet entre autre de mettre à jour les items dans le lobby lorsqu'un joueur devient host.
     */
    void refreshHotbar();

    /**
     * Permet de définir le joueur en tant que spectateur.
     */
    void setSpectator();

    /**
     * Permet de récupérer le joueur bukkit.
     *
     * @return le joueur bukkit
     */
    Player getPlayer();

    /**
     * Permet de récupérer si le joueur est le host principal.
     *
     * @return true si le joueur est le host principal, false sinon
     */
    boolean isMainHost();

    /**
     * Permet de récupérer si le joueur est un host (co-host ou host principal).
     *
     * @return true si le joueur est un host (co-host ou host principal), false sinon
     */
    boolean hasHostAccess();

    /**
     * Methode appelée lorsqu'un joueur meurt.
     *
     * @param killer     Le joueur qui a tué le joueur
     * @param disconnect Si le joueur est mort à cause d'une déconnexion
     */
    void handleDeath(Player killer, boolean disconnect);

    /**
     * @param killer        Le joueur qui a tué le joueur
     * @param disconnect    Si le joueur est mort à cause d'une déconnexion
     * @param announceAfter Combien de temps après la mort doit être envoyé l'annonce de mort
     */
    void handleDeath(Player killer, boolean disconnect, int announceAfter);

    /**
     * Methode appelée lorsqu'un joueur meurt (sans déconnexion).
     *
     * @param killer Le joueur qui a tué le joueur
     */
    void handleDeath(Player killer);

    /**
     * Permet de récupérer le camp du joueur.
     * Le camp est défini lors de l'annonce des rôles.
     *
     * @return le camp du joueur
     */
    @Nullable
    Camp getCamp();

    /**
     * Permet de définir le camp du joueur.
     * Le camp peut être une valeur nulle si le joueur n'a plus de camp.
     *
     * @param camp le camp du joueur
     */
    void setCamp(@Nullable Camp camp);

    /**
     * Permet de récupérer le rôle du joueur.
     * Le rôle est défini lors de l'annonce des rôles.
     * Le rôle peut être une valeur nulle si le joueur n'a plus de rôle.
     *
     * @return le rôle du joueur
     */
    @Nullable
    Role getRole();

    /**
     * Permet de définir le rôle du joueur.
     *
     * @param role le rôle du joueur
     */
    void setRole(@Nullable Role role);

    /**
     * Permet de récupérer si le joueur est vivant.
     *
     * @return true si le joueur est vivant, false sinon
     */
    boolean isAlive();

    /**
     * Permet d'enlever des cœurs à un joueur.
     * Cette méthode enlève les cœurs d'absorption avant de retirer les cœurs de vie
     * et envoie une animation de dégâts au joueur.
     *
     * @param health le nombre de cœurs à retirer.
     */
    void removeHealth(float health);

    /**
     * Permet de récupérer le nombre de cœurs restants au joueur.
     * Cette méthode prend en compte les cœurs d'absorption.
     *
     * @return le nombre de cœurs restants au joueur
     */
    double getHealth();

    /**
     * Permet d'ajouter des cœurs à un joueur.
     *
     * @param health le nombre de cœurs à ajouter
     */
    void addHealth(float health);

    /**
     * Permet de récupérer le nombre de cœurs d'absorption restants au joueur.
     *
     * @return le nombre de cœurs d'absorption restants au joueur
     */
    float getAbsorptionHearts();

    /**
     * Permet d'ajouter des cœurs d'absorption à un joueur.
     *
     * @param health le nombre de cœurs d'absorption à ajouter
     */
    void addAbsorptionHearts(float health);

    /**
     * Permet de définir le nombre de cœurs d'absorption d'un joueur.
     *
     * @param health le nombre de cœurs d'absorption à définir
     */
    void setAbsorptionHearts(float health);

    /**
     * Permet de rendre le joueur invulnérable à un dégât pendant un certain temps.
     *
     * @param cause   le type de dégâts
     * @param seconds le nombre de secondes pendant lesquelles le joueur est invulnérable
     */
    void addDamageInvulnerability(EntityDamageEvent.DamageCause cause, int seconds);

    /**
     * Permet de rendre le joueur invulnérable à un dégât pendant un certain temps.
     *
     * @param seconds le nombre de secondes pendant lesquelles le joueur ne peut frapper personne
     */
    void removeDamageAbility(int seconds);

    /**
     * Permet de désactiver l'accès aux pouvoirs du joueur
     */
    void disablePowers();

    /**
     * Permet d'activer l'accès aux pouvoirs du joueur
     */
    void enablePowers();

    /**
     * Permet de récupérer si le joueur peut utiliser ses pouvoirs.
     *
     * @return true si le joueur peut utiliser ses pouvoirs, false sinon
     */
    boolean canUsePowers();

    /**
     * Permet d'immobiliser le joueur
     */
    void stun();

    /**
     * Permet de rendre le joueur mobile
     */
    void unStun();

    /**
     * Les points ne sont pas utilisés par le plugin, mais peuvent être utilisés par les autres plugins.
     * Vous pouvez par exemple utiliser les points pour définir une particularité pour un mode de jeu.
     *
     * @return le nombre de points du joueur
     */
    int getPoints();

    /**
     * Les points ne sont pas utilisés par le plugin, mais peuvent être utilisés par les autres plugins.
     *
     * @param points le nombre de points du joueur
     */
    void setPoints(int points);
}
