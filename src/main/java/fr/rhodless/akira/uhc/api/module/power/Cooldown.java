package fr.rhodless.akira.uhc.api.module.power;

import fr.rhodless.akira.uhc.api.API;
import fr.rhodless.akira.uhc.api.utils.time.TimeUtil;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import javax.annotation.Nullable;
import java.util.function.Consumer;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public class Cooldown {
    private final String name;
    private BukkitTask runnable;
    private int seconds;
    private final Consumer<Player> consumer;

    /**
     * Cette classe permet de créer un cooldown.
     * Pour lancer le cooldown, il faut définir la valeur du cooldown avec
     * {@link Cooldown#setCooldown(int)} et lancer le cooldown avec {@link Cooldown#task()}
     *
     * @param name     le nom du cooldown
     * @param consumer le consumer à executer à la fin du cooldown
     */
    public Cooldown(String name, @Nullable Consumer<Player> consumer) {
        this.name = name;
        this.consumer = consumer;
    }

    /**
     * Permet de démarrer le cooldown
     */
    public void task() {
        this.task(null);
    }

    /**
     * Permet de démarrer le cooldown
     *
     * @param player le joueur à passer en paramètre du consumer
     */
    public void task(@Nullable Player player) {
        if (runnable != null) runnable.cancel();

        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                if (seconds > 0) {
                    onSecond();
                    return;
                }
                cancel();

                if (player == null) return;
                onEnd(player);
            }
        }.runTaskTimer(API.getPlugin(), 0, 20);
    }

    /**
     * Permet de décrémenter le cooldown
     */
    public void onSecond() {
        this.seconds--;
    }

    /**
     * Permet de récupérer le message de cooldown
     *
     * @return le message de cooldown
     */
    public String getCooldownMessage() {
        return API.getPrefixHandler().prefix("&cVous ne pouvez pas utiliser cette capacité. Elle sera de nouveau disponible dans " + TimeUtil.getReallyNiceTime2(this.getSeconds() * 1000L));
    }

    /**
     * Permet de vérifier si le joueur est en cooldown.
     * Si le joueur est en cooldown, le message de cooldown sera envoyé.
     *
     * @param player le joueur à vérifier
     * @return true si le joueur est en cooldown
     */
    public boolean isCooldown(Player player) {
        if (this.getSeconds() <= 0) return false;

        player.sendMessage(getCooldownMessage());

        return true;
    }

    /**
     * Permet de vérifier si le joueur est en cooldown.
     * Si le joueur est en cooldown, le message de cooldown ne sera pas envoyé.
     *
     * @return true si le joueur est en cooldown
     */
    public boolean isCooldownNoMessage() {
        return this.getSeconds() > 0;
    }

    /**
     * Permet de terminer le cooldown.
     * Le consumer sera executé si le joueur n'est pas null.
     *
     * @param player le joueur à passer en paramètre du consumer
     */
    public void onEnd(Player player) {
        if (this.consumer != null) this.consumer.accept(player);
    }

    /**
     * Permet de définir le cooldown
     *
     * @param seconds le nombre de secondes du cooldown
     */
    public void setCooldown(int seconds) {
        this.seconds = seconds;
    }

    /**
     * Permet de récupérer le nombre de secondes restantes du cooldown
     *
     * @return le nombre de secondes restantes du cooldown
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * Permet de récupérer le nom du cooldown
     *
     * @return le nom du cooldown
     */
    public String getName() {
        return name;
    }
}

