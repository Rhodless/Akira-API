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
public @interface SubCommand {
    /**
     * Permet de définir le nom de la sous-commande.
     * Le premier élément étant la commande principale et les autres étant les alias.
     *
     * @return les différents noms de la sous-commande
     */
    String[] names();

    /**
     * Définir la permission de la sous-commande permet d'empêcher l'exécution de la sous-commande si le joueur n'a pas la permission.
     * Si la permission est "none", la sous-commande ne sera pas protégée par une permission.
     *
     * @return la permission de la sous-commande
     */
    String permission() default "none";

    /**
     * Définir la sous-commande asynchrone permet d'exécuter la sous-commande dans un thread séparé.
     * Si la sous-commande est asynchrone, le thread principal ne sera pas bloqué pendant l'exécution de la sous-commande.
     *
     * @return si la sous-commande est asynchrone
     */
    boolean async() default false;

    /**
     * Définir la description de la sous-commande permet d'afficher la description de la sous-commande dans la commande d'aide.
     * Si la description est vide, la sous-commande n'apparaitra pas dans la commande d'aide.
     *
     * @return la description de la sous-commande
     */
    String description() default "";
}
