package fr.rhodless.akira.uhc.api.module.power.defaults;

import fr.rhodless.akira.uhc.api.module.power.Power;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */

/**
 * Ce pouvoir s'active lorsque le joueur execute la commande /module argument
 */
public abstract class CommandPower extends Power {
    private String[] args;

    /**
     * Permet de récupérer l'argument de la commande.
     *
     * @return l'argument de la commande
     */
    public abstract String getArgument();

    /**
     * Permet de récupérer les arguments de la commande.
     *
     * @return les arguments de la commande
     */
    public String[] getArgs() {
        return args;
    }

    /**
     * Permet de définir les arguments de la commande.
     *
     * @param args les arguments de la commande
     */
    public void setArgs(String[] args) {
        this.args = args;
    }
}
