package fr.rhodless.akira.uhc.api.command.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;




/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Command {
    /**
     * Permet de définir le nom de la commande.
     * Le premier élément étant la commande principale et les autres étant les alias
     *
     * @return les différents noms de la commande
     */
    String[] names();

    /**
     * Définir la permission de la commande permet d'empêcher l'exécution de la commande si le joueur n'a pas la permission.
     * Si la permission est "none", la commande ne sera pas protégée par une permission.
     *
     * @return la permission de la commande
     */
    String permission() default "none";

    /**
     * Définir la commande asynchrone permet d'exécuter la commande dans un thread séparé.
     * Si la commande est asynchrone, le thread principal ne sera pas bloqué pendant l'exécution de la commande.
     *
     * @return si la commande est asynchrone
     */
    boolean async() default false;

    /**
     * Définir la description de la commande permet d'afficher la description de la commande dans la commande d'aide.
     * Si la description est vide, la commande n'apparaitra pas dans la commande d'aide.
     *
     * @return la description de la commande
     */
    String description() default "";
}