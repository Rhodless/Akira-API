package fr.rhodless.akira.uhc.api.module.role;

import fr.rhodless.akira.uhc.api.API;
import fr.rhodless.akira.uhc.api.module.camp.Camp;
import fr.rhodless.akira.uhc.api.module.power.Power;
import fr.rhodless.akira.uhc.api.player.info.ProfileInfo;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public abstract class Role implements Listener {
    private final List<Power> powers;
    private float strengthAmplifier = 1;
    private float resistanceAmplifier = 1;
    private float speedAmplifier = 1;

    /**
     * @param powers les pouvoirs du rôle
     */
    public Role(Power... powers) {
        this.powers = new ArrayList<>(Arrays.asList(powers));
    }

    /**
     * Permet de récupérer le rôle méta
     *
     * @return la role méta du rôle
     */
    public RoleMeta getMeta() {
        return this.getClass().getAnnotation(RoleMeta.class);
    }

    /**
     * Permet de récupérer le nom du rôle
     *
     * @return le nom du rôle
     */
    public String getName() {
        return this.getMeta().name();
    }

    /**
     * Permet de récupérer le camp du rôle
     *
     * @return le camp du rôle
     */
    public Class<? extends Camp> getCampClass() {
        return this.getMeta().camp();
    }

    /**
     * Permet de récupérer le camp du rôle
     *
     * @return le camp du rôle
     */
    public Camp getCamp() {
        return API.getModuleHandler().getCurrentModule().getCamps().stream()
                .filter(camp -> camp.getClass().equals(this.getCampClass()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Permet de récupérer les auteurs du rôle
     *
     * @return les auteurs du rôle
     */
    public abstract List<String> getAuthors();

    /**
     * Permet de créer une liste beaucoup plus rapidement
     *
     * @param t   les éléments à ajouter
     * @param <T> le type des éléments
     * @return une liste contenant les éléments
     */
    @SafeVarargs
    protected final <T> List<T> of(T... t) {
        return new ArrayList<>(Arrays.asList(t));
    }

    /**
     * Permet d'ajouter un pouvoir au rôle
     *
     * @param power le pouvoir à ajouter
     */
    public void addPower(Power power) {
        this.powers.add(power);
    }

    /**
     * Permet de retirer un pouvoir du rôle
     *
     * @param power le pouvoir à retirer
     */
    public void removePower(Power power) {
        this.powers.remove(power);
    }

    /**
     * Méthode executée lors de la distribution du rôle
     *
     * @param player le joueur
     */
    public void onDistribute(Player player) {
    }

    /**
     * Methode executée lorsque le joueur reçoit la description du rôle.
     * Cette méthode est donc appelée lors de la distribution du rôle mais aussi
     * lorsqu'il utilise la commande /module me
     *
     * @param player le joueur
     */
    public void onDescription(Player player) {
    }

    /**
     * Permet de récupérer la description du rôle
     *
     * @return la description du rôle
     */
    public abstract List<String> getDescription();

    /**
     * Methode executée lors du jour
     *
     * @param player le joueur
     */
    public void onDay(Player player) {
    }

    /**
     * Methode executée lors de la nuit
     *
     * @param player le joueur
     */
    public void onNight(Player player) {
    }

    /**
     * Methode executée lors d'un épisode
     *
     * @param player  le joueur
     * @param episode l'épisode
     */
    public void onEpisode(Player player, int episode) {
    }

    /**
     * Methode executée chaque seconde
     *
     * @param player le joueur
     */
    public void onSecond(Player player) {
    }

    /**
     * Permet de récupérer le joueur possédant ce rôle
     *
     * @return permet de récupérer le joueur possédant ce rôle
     */
    @Nullable
    protected Player getPlayer() {
        return API.getGameHandler().getPlayers().stream().filter(uuid -> Bukkit.getPlayer(uuid) != null).map(Bukkit::getPlayer).filter(player -> equals(API.getPlayerHandler().getProfile(player).getRole())).findFirst().orElse(null);
    }

    /**
     * Permet de vérifier si un joueur possède ce rôle
     *
     * @param player le joueur
     * @return true si le joueur possède ce rôle
     */
    protected boolean isRole(Player player) {
        ProfileInfo profile = API.getPlayerHandler().getProfile(player);

        return profile.getRole() != null && profile.getRole().equals(this);
    }

    /**
     * Permet de récupérer si le joueur possède une épée dans sa main
     *
     * @param player le joueur
     * @return true si le joueur possède une épée dans sa main
     */
    protected boolean hasSword(Player player) {
        return player.getItemInHand() != null && player.getItemInHand().getType().name().contains("SWORD");
    }

    /**
     * Permet de récupérer un joueur possédant un rôle
     *
     * @param info le rôle à trouver
     * @return le joueur possédant le rôle
     */
    @Nullable
    public static Player findPlayer(QuickRoleInfo info) {
        return API.getGameHandler().getPlayers().stream()
                .filter(uuid -> Bukkit.getPlayer(uuid) != null)
                .map(Bukkit::getPlayer)
                .map(player -> API.getPlayerHandler().getProfile(player))
                .filter(profile -> profile.getRole() != null && profile.getRole().getClass().getSimpleName().equals(info.getRole().getSimpleName()))
                .map(ProfileInfo::getPlayer)
                .findFirst().orElse(null);
    }

    /**
     * Permet de vérifier si un joueur possède un rôle
     *
     * @param player le joueur
     * @param info   le rôle à vérifier
     * @return true si le joueur possède le rôle
     */
    public static boolean isRole(Player player, QuickRoleInfo info) {
        Player found = findPlayer(info);
        if (found == null) return false;

        return player.getUniqueId().equals(found.getUniqueId());
    }

    /**
     * Permet d'envoyer à un joueur l'identité d'un autre joueur possédant un rôle particulier
     *
     * @param player le joueur
     * @param role   le rôle
     */
    public static void knowsRole(Player player, QuickRoleInfo role) {
        Player target = findPlayer(role);
        if (target == null) return;

        player.sendMessage(API.getPrefixHandler().prefix("&7Le &c" + role.getName() + " &7de la partie est &a" + target.getName()));
    }

    /**
     * Permet de récupérer la liste des joueurs possédant un camp spécifique
     *
     * @param camp le camp
     * @return la liste des joueurs dans le camp
     */
    public static List<Player> getPlayersInCamp(Camp camp) {
        return API.getGameHandler().getPlayers().stream()
                .filter(uuid -> Bukkit.getPlayer(uuid) != null)
                .map(Bukkit::getPlayer)
                .map(player -> API.getPlayerHandler().getProfile(player))
                .filter(profile -> profile.getCamp() != null && profile.getCamp().equals(camp))
                .map(ProfileInfo::getPlayer)
                .collect(Collectors.toList());
    }

    /**
     * Permet de récupérer un pouvoir par son type
     *
     * @param power le pouvoir
     * @param <T>   le type du pouvoir
     * @return le pouvoir
     */
    public <T extends Power> T getPower(Class<T> power) {
        return this.powers.stream().filter(power1 -> power1.getClass().getSimpleName().equals(power.getSimpleName())).map(power::cast).findFirst().orElse(null);
    }

    /**
     * Permet de récupérer les pouvoirs du rôle
     *
     * @return les pouvoirs du rôle
     */
    public List<Power> getPowers() {
        return powers;
    }

    /**
     * Permet de récupérer l'amplificateur de force
     * Par exemple, si l'amplificateur est de 2, le joueur aura 100% de force. Si l'amplificateur est de 1, le joueur aura une force basique.
     * Si l'amplificateur est de 0.5, le joueur aura 50% de weakness.
     *
     * @return l'amplificateur de force
     */
    public float getStrengthAmplifier() {
        return strengthAmplifier;
    }

    /**
     * Permet de définir l'amplificateur de force
     *
     * @param strengthAmplifier l'amplificateur de force
     */
    public void setStrengthAmplifier(float strengthAmplifier) {
        this.strengthAmplifier = strengthAmplifier;
    }

    /**
     * Permet de récupérer l'amplificateur de resistance
     * Par exemple, si l'amplificateur est de 2, le joueur aura 100% de resistance. Si l'amplificateur est de 1, le joueur aura une resistance basique.
     * Si l'amplificateur est de 0.5, le joueur prendra 50% de dégâts en plus.
     *
     * @return l'amplificateur de resistance
     */
    public float getResistanceAmplifier() {
        return resistanceAmplifier;
    }

    /**
     * Permet de définir l'amplificateur de resistance
     *
     * @param resistanceAmplifier l'amplificateur de resistance
     */
    public void setResistanceAmplifier(float resistanceAmplifier) {
        this.resistanceAmplifier = resistanceAmplifier;
    }

    /**
     * Permet de récupérer l'amplificateur de vitesse.
     * Par exemple, si l'amplificateur est de 2, le joueur aura 100% de vitesse. Si l'amplificateur est de 1, le joueur aura une vitesse basique.
     * Si l'amplificateur est de 0.5, le joueur aura 50% de ralentissement.
     *
     * @return l'amplificateur de vitesse
     */
    public float getSpeedAmplifier() {
        return speedAmplifier;
    }

    /**
     * Permet de définir l'amplificateur de vitesse
     *
     * @param speedAmplifier l'amplificateur de vitesse
     */
    public void setSpeedAmplifier(float speedAmplifier) {
        this.speedAmplifier = speedAmplifier;
    }
}
