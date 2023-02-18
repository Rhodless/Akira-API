package fr.rhodless.akira.uhc.api.module.power;

import fr.rhodless.akira.uhc.api.API;
import fr.rhodless.akira.uhc.api.events.game.list.player.list.GamePowerUsePlayerEvent;
import fr.rhodless.akira.uhc.api.player.info.ProfileInfo;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public abstract class Power {
    private final List<RestrictionType> restrictions = new ArrayList<>();
    private final Cooldown cooldown = new Cooldown(this.getPowerName(), null);

    private int cooldownAmount;
    private int maxUses;
    private int uses = 0;

    public Power(int cooldown, int maxUses) {
        this.cooldownAmount = cooldown;
        this.maxUses = maxUses;

        if (cooldownAmount != -1) {
            this.restrictions.add(RestrictionType.COOLDOWN);
        }

        if (this.maxUses != -1) {
            this.restrictions.add(RestrictionType.USES);
        }
    }

    /**
     * Permet de récupérer le nom du pouvoir
     *
     * @return le nom du pouvoir
     */
    public abstract String getPowerName();

    /**
     * Methode executée lors de l'utilisation du pouvoir
     *
     * @param player le joueur
     * @return true si le pouvoir s'est executé avec succès
     */
    public abstract boolean onEnable(Player player);

    /**
     * Permet de récupérer le cooldown du pouvoir
     *
     * @param restriction la restriction
     * @return true si le pouvoir a la restriction
     */
    public boolean hasRestriction(RestrictionType restriction) {
        return getRestrictions().contains(restriction);
    }

    /**
     * Permet de récupérer les restrictions du pouvoir.
     *
     * @return les restrictions du pouvoir
     */
    public List<RestrictionType> getRestrictions() {
        return this.restrictions;
    }

    /**
     * Méthode executée lorsqu'un joueur essaye d'utiliser le pouvoir.
     * Cette méthode est appelée avant onEnable, elle permet de vérifier si le joueur peut utiliser le pouvoir.
     *
     * @param player le joueur
     */
    public void usePower(Player player) {
        if (hasRestriction(RestrictionType.COOLDOWN) && (mustSendCooldownMessage() ? cooldown.isCooldown(player) : cooldown.isCooldownNoMessage()))
            return;

        if (hasRestriction(RestrictionType.USES) && uses >= maxUses) {
            player.sendMessage(API.getPrefixHandler().prefix("&cVous avez déjà utilisé ce pouvoir &8(&7" + maxUses + "x utilisations&8)"));
            return;
        }

        ProfileInfo profileInfo = API.getPlayerHandler().getProfile(player);
        if (!profileInfo.isAlive() || profileInfo.getDeathProcess() != null) return;

        if (!this.onEnable(player)) return;

        uses++;
        Bukkit.getPluginManager().callEvent(new GamePowerUsePlayerEvent(player, profileInfo, this));

        if (this.hasRestriction(RestrictionType.COOLDOWN)) {
            cooldown.setCooldown(cooldownAmount);
            cooldown.task();
        }
    }

    /**
     * Permet de créer une liste de restrictions
     *
     * @param types les restrictions
     * @return les restrictions pour le pouvoir
     */
    protected List<RestrictionType> of(RestrictionType... types) {
        return Arrays.asList(types);
    }

    /**
     * Permet de savoir si le joueur doit recevoir un message de cooldown.
     *
     * @return true si le joueur doit recevoir un message de cooldown
     */
    public boolean mustSendCooldownMessage() {
        return true;
    }

    /**
     * Permet de savoir si le pouvoir bypass le système de désactivation des pouvoirs.
     *
     * @return true si le pouvoir bypass le système de désactivation des pouvoirs
     */
    public boolean bypassesDisabler() {
        return false;
    }

    /**
     * Permet de récupérer le cooldown du pouvoir.
     * Pour récupérer le cooldown du pouvoir en temps réel, utilisez {@link Cooldown#getSeconds()}
     *
     * @return le cooldown du pouvoir
     */
    public int getCooldownAmount() {
        return cooldownAmount;
    }

    /**
     * Permet de définir le cooldown du pouvoir.
     *
     * @param cooldownAmount le cooldown du pouvoir
     */
    public void setCooldownAmount(int cooldownAmount) {
        this.cooldownAmount = cooldownAmount;
    }

    /**
     * Permet de récupérer le nombre d'utilisations maximum du pouvoir.
     *
     * @return le nombre d'utilisations maximum du pouvoir
     */
    public int getMaxUses() {
        return maxUses;
    }

    /**
     * Permet de définir le nombre d'utilisations maximum du pouvoir.
     *
     * @param maxUses le nombre d'utilisations maximum du pouvoir
     */
    public void setMaxUses(int maxUses) {
        this.maxUses = maxUses;
    }

    /**
     * Permet de récupérer le cooldown du pouvoir.
     *
     * @return le cooldown du pouvoir
     */
    public Cooldown getCooldown() {
        return cooldown;
    }

    /**
     * Permet de récupérer le nombre d'utilisations du pouvoir.
     *
     * @return le nombre d'utilisations du pouvoir
     */
    public int getUses() {
        return uses;
    }

    /**
     * Permet de définir le nombre d'utilisations du pouvoir.
     *
     * @param uses le nombre d'utilisations du pouvoir
     */
    public void setUses(int uses) {
        this.uses = uses;
    }
}
