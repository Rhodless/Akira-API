package fr.rhodless.akira.uhc.api.module.role;

import fr.rhodless.akira.uhc.api.API;
import fr.rhodless.akira.uhc.api.module.camp.Camp;
import fr.rhodless.akira.uhc.api.module.power.Power;
import fr.rhodless.akira.uhc.api.player.PlayerHandler;
import fr.rhodless.akira.uhc.api.player.info.ProfileInfo;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
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
        for (Camp camp : API.getModuleHandler().getCurrentModule().getCamps()) {
            if (camp.getClass().equals(this.getCampClass())) {
                return camp;
            }
        }
        return null;
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
        PlayerHandler playerHandler = API.getPlayerHandler();
        for (UUID uuid : API.getGameHandler().getPlayers()) {
            if (Bukkit.getPlayer(uuid) != null) {
                Player player = Bukkit.getPlayer(uuid);
                ProfileInfo profile = playerHandler.getProfile(player);
                if (profile.getRole() != null) {
                    if (profile.getRole().getName().equals(this.getName())) {
                        return profile.getPlayer();
                    }
                }
            }
        }
        return null;
    }

    /**
     * Permet de récupérer le profil du joueur possédant ce rôle
     *
     * @return le profil du joueur possédant ce rôle
     */
    protected ProfileInfo getProfile() {
        return API.getPlayerHandler().getProfile(getPlayer());
    }

    /**
     * Permet de vérifier si un joueur possède ce rôle
     *
     * @param player le joueur
     * @return true si le joueur possède ce rôle
     */
    protected boolean isRole(Player player) {
        ProfileInfo profile = API.getPlayerHandler().getProfile(player);

        return profile.getRole() != null && profile.getRole().getName().equals(this.getName());
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

    @Nullable
    @Deprecated
    public static ProfileInfo findPlayer(QuickRoleInfo info) {
        for (UUID uuid : API.getGameHandler().getPlayers()) {
            ProfileInfo profile = API.getPlayerHandler().getProfile(uuid);
            if (profile != null) {
                if (profile.getRole() != null && profile.getRole().getClass().getSimpleName().equals(info.getRoleClass().getSimpleName())) {
                    return profile;
                }
            }
        }
        return null;
    }

    /**
     * Permet de récupérer les joueurs possédant un rôle
     *
     * @param info le rôle à trouver
     * @return les joueurs possédant le rôle
     */
    public static List<ProfileInfo> findPlayers(QuickRoleInfo info) {
        List<ProfileInfo> list = new ArrayList<>();
        for (UUID uuid : API.getGameHandler().getPlayers()) {
            ProfileInfo profile = API.getPlayerHandler().getProfile(uuid);
            if (profile == null) continue;
            if (info.getRoleClass() == null) continue;

            if (profile.getRole() != null && profile.getRole().getClass().getSimpleName().equals(info.getRoleClass().getSimpleName())) {
                list.add(profile);
            }

        }
        return list;
    }

    /**
     * Permet de vérifier si un joueur possède un rôle
     *
     * @param player le joueur
     * @param info   le rôle à vérifier
     * @return true si le joueur possède le rôle
     */
    public static boolean isRole(Player player, QuickRoleInfo info) {
        for (ProfileInfo profileInfo : findPlayers(info)) {
            if (profileInfo.getUniqueId().equals(player.getUniqueId())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Permet d'envoyer à un joueur l'identité d'un autre joueur possédant un rôle particulier
     *
     * @param player le joueur
     * @param info   le rôle
     */
    public static void knowsRole(Player player, QuickRoleInfo info) {
        List<String> foundPlayers = new ArrayList<>();
        for (ProfileInfo profileInfo : findPlayers(info)) {
            foundPlayers.add(profileInfo.getName());
        }
        if (foundPlayers.isEmpty()) return;

        String nameDisplay = String.join("&7, &a", foundPlayers);
        if (foundPlayers.size() > 1) {
            player.sendMessage(API.getPrefixHandler().prefix("&7Le &c" + info.getName() + " &7de la partie est &a" + nameDisplay));
        } else {
            player.sendMessage(API.getPrefixHandler().prefix("&7Les &c" + info.getName() + "s &7de la partie sont &a" + nameDisplay));
        }
    }

    /**
     * Permet de récupérer la liste des joueurs possédant un camp spécifique
     *
     * @param camp le camp
     * @return la liste des joueurs dans le camp
     */
    public static List<ProfileInfo> getPlayersInCamp(Camp camp) {
        List<ProfileInfo> list = new ArrayList<>();
        for (UUID player : API.getGameHandler().getPlayers()) {
            ProfileInfo profile = API.getPlayerHandler().getProfile(player);
            if (profile != null) {
                if (profile.getCamp() != null && profile.getCamp().equals(camp)) {
                    list.add(profile);
                }
            }
        }
        return list;
    }

    /**
     * Permet de récupérer un pouvoir par son type
     *
     * @param power le pouvoir
     * @param <T>   le type du pouvoir
     * @return le pouvoir
     */
    public <T extends Power> T getPower(Class<T> power) {
        for (Power power1 : this.powers) {
            if (power1.getClass().getSimpleName().equals(power.getSimpleName())) {
                return power.cast(power1);
            }
        }
        return null;
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
