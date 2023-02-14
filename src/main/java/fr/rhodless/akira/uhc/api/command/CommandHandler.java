package fr.rhodless.akira.uhc.api.command;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface CommandHandler {
    /**
     * Permet d'enregistrer une classe qui contient des commandes.
     * Les commandes doivent être annotées avec @Command.
     *
     * @param object l'objet qui contient les commandes
     */
    void registerCommands(Object object);

    /**
     * Permet d'enregistrer une classe qui contient des commandes.
     * Les commandes doivent être annotées avec @MainCommand.
     * Les sous-commandes doivent être annotées avec @SubCommand.
     *
     * @param object l'objet qui contient les commandes
     */
    void registerCommandWithSubCommands(Object object);
}
