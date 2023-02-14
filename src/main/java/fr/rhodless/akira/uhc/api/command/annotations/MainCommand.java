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
@Target(ElementType.TYPE)
public @interface MainCommand {
    /**
     * Permet de définir le nom de la commande.
     * Le premier élément étant la commande principale et les autres étant les alias
     *
     * @return les différents noms de la commande
     */
    String[] names();

    /**
     * Permet de définir l'argument pour la commande d'aide.
     * Par exemple, si l'argument est "help", la commande d'aide sera "/command help"
     *
     * @return l'argument pour la commande d'aide
     */
    String helpCommand();

    /**
     * Définir la permission de la commande permet d'empêcher l'exécution de la commande si le joueur n'a pas la permission.
     * Si la permission est "none", la commande ne sera pas protégée par une permission.
     *
     * @return la permission de la commande
     */
    String permission() default "none";

    /**
     * Définir la description de la commande permet d'afficher la description de la commande dans la commande d'aide.
     * Si la description est vide, la commande n'apparaitra pas dans la commande d'aide.
     *
     * @return permet de définir la description de la commande
     */
    String description() default "";

    /**
     * Définir l'usage de la commande permet d'afficher l'usage de la commande dans la commande d'aide.
     * Si l'usage est "none", l'usage de la commande sera générée automatiquement.
     *
     * @return permet de définir l'usage de la command
     */
    String usage() default "none";

    /**
     * Définir si la commande aura une page d'aide.
     * Si la commande a une page d'aide, la commande d'aide sera "/command helpCommand"
     *
     * @return permet de définir si la commande aura une page d'aide
     */
    boolean help() default false;
}
