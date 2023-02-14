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
@Target(ElementType.PARAMETER)
public @interface Param {
    /**
     * Définir le nom du paramètre permet d'afficher le nom du paramètre dans la commande d'aide.
     * Le nom du paramètre est obligatoire.
     * De plus, le nom du paramètre sera utilisé pour la tabulation ainsi que pour les messages d'utilisation de la commande.
     *
     * @return le nom du paramètre
     */
    String name();

    /**
     * Définir le paramètre comme wildcard permet de prendre en compte tous les arguments restants.
     * Cela veut dire qu'il est impossible rajouter des paramètres après un paramètre wildcard.
     *
     * @return si le paramètre prend en compte tous les arguments restants
     */
    boolean wildcard() default false;

    /**
     * Définir la valeur par défaut du paramètre permet de définir une valeur par défaut pour le paramètre.
     * Cela veut dire qu'il est impossible rajouter des paramètres après un paramètre avec une valeur par défaut.
     *
     * @return la valeur par défaut du paramètre
     */
    String baseValue() default "";

    /**
     * Définir une tabulation manuelle permet d'ajouter des valeurs à la tabulation du paramètre.
     *
     * @return la tabulation manuelle du paramètre
     */
    String[] tabCompleteFlags() default "";
}