package fr.rhodless.akira.uhc.api.module.role;

import fr.rhodless.akira.uhc.api.module.camp.Camp;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RoleMeta {
    /**
     * Permet de récupérer le nom du rôle.
     *
     * @return le nom du rôle
     */
    String name();

    /**
     * Permet de récupérer le camp du rôle
     *
     * @return la class du camp
     */
    Class<? extends Camp> camp();
}
