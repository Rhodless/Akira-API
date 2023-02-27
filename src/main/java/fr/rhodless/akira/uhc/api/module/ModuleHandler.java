package fr.rhodless.akira.uhc.api.module;

import fr.rhodless.akira.uhc.api.module.event.ModuleEvent;
import fr.rhodless.akira.uhc.api.module.timer.ModuleTimer;

import java.util.List;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface ModuleHandler {
    /**
     * Permet d'enregistrer un module.
     * Attention, il n'est pas possible d'enregister plus d'un module.
     *
     * @param module le module à enregistrer
     */
    void registerModule(Module module);

    /**
     * Permet de récupérer le module actuellement enregistré
     *
     * @return le module actuellement enregistré
     */
    Module getCurrentModule();

    /**
     * Permet de récupérer l'objet qui contient les commandes du module.
     *
     * @return l'objet qui contient les commandes
     */
    Object getOtherCommands();

    /**
     * Permet de récupérer la liste des timers enregistrés
     *
     * @return la liste des timers enregistrés
     */
    List<ModuleTimer> getTimers();

    /**
     * Permet d'enregistrer un timer
     *
     * @param timer le timer à enregistrer
     */
    void registerTimer(ModuleTimer timer);

    /**
     * Permet d'enregistrer une class qui contient des commandes du module.
     * Par exemple si vous voulez rajouter une commande /module mon_nom_spécial, vous
     * pouvez créer une class qui contient la commande et l'enregistrer avec cette méthode.
     * Attention à utiliser les annotations {@link fr.rhodless.akira.uhc.api.command.annotations.SubCommand}.
     *
     * @param object l'objet qui contient les commandes
     */
    void registerOtherCommands(Object object);

    /**
     * Permet de récupérer un timer à partir de sa classe
     *
     * @param timer la classe du timer
     * @param <T>   le type du timer
     * @return le timer enregistré
     */
    <T extends ModuleTimer> T getTimer(Class<T> timer);

    /**
     * Permet de récupérer la liste des events enregistrés
     *
     * @return la liste des events enregistrés
     */
    List<ModuleEvent> getEvents();

    /**
     * Permet d'enregistrer un event
     *
     * @param event l'event à enregistrer
     */
    void registerEvent(ModuleEvent event);

    /**
     * Permet de récupérer un event à partir de sa classe
     *
     * @param event la classe de l'event
     * @param <T>   le type de l'event
     * @return l'event enregistré
     */
    <T extends ModuleEvent> T getEvent(Class<T> event);
}
