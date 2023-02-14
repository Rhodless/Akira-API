package fr.rhodless.akira.uhc.api.game.config.list;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface ConfigurationTimers {
    /**
     * Permet de récupérer le temps entre chaque cycle pendant la partie.
     * Par exemple, si le temps de cycle est 5 minutes, alors le jour durera 5 minutes.
     *
     * @return le temps entre chaque cycle pendant la partie
     */
    int getCycleTimer();

    /**
     * Permet de définir le temps entre chaque cycle pendant la partie.
     *
     * @param cycleTimer le temps entre chaque cycle pendant la partie
     */
    void setCycleTimer(int cycleTimer);

    /**
     * Permet de récupérer le temps qu'à chaque joueur avant de mourir pour deconnexion.
     * Par exemple, si le temps de deconnexion est de 5 minutes, et que le joueur s'absente pendant 5 minutes,
     * alors il mourra.
     *
     * @return le temps qu'à chaque joueur avant de mourir pour deconnexion
     */
    int getDeconnexionTimer();

    /**
     * Permet de définir le temps qu'à chaque joueur avant de mourir pour deconnexion.
     *
     * @param deconnexionTimer le temps qu'à chaque joueur avant de mourir pour deconnexion
     */
    void setDeconnexionTimer(int deconnexionTimer);

    /**
     * Permet de récupérer le temps avant que le pvp soit activé.
     * Par exemple, si le temps avant le pvp est de 5 minutes, alors le pvp sera activé après 5 minutes.
     *
     * @return le temps avant que le pvp soit activé
     */
    int getPvPTimer();

    /**
     * Permet de définir le temps avant que le pvp soit activé.
     *
     * @param pvpTimer le temps avant que le pvp soit activé
     */
    void setPvPTimer(int pvpTimer);

    /**
     * Permet de récupérer le temps avant que le border commence à rétrécir.
     *
     * @return le temps avant que le border commence à rétrécir
     */
    int getBorderTimer();

    /**
     * Permet de définir le temps avant que le border commence à rétrécir.
     *
     * @param borderTimer le temps avant que le border commence à rétrécir
     */
    void setBorderTimer(int borderTimer);

    /**
     * Permet de récupérer le temps avant que les rôles soient distribués.
     *
     * @return le temps avant que les rôles soient distribués
     */
    int getRolesTimer();

    /**
     * Permet de définir le temps avant que les rôles soient distribués.
     *
     * @param rolesTimer le temps avant que les rôles soient distribués
     */
    void setRolesTimer(int rolesTimer);
}
