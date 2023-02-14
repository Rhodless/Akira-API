package fr.rhodless.akira.uhc.api.game.cycle;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface CycleHandler {
    /**
     * Permet de récupérer le cycle actuel.
     *
     * @return le cycle actuel
     */
    CycleState getCycleState();

    /**
     * Permet de définir le cycle actuel.
     *
     * @param cycleState le cycle actuel
     */
    void setCycleState(CycleState cycleState);

    /**
     * Cette méthode est appelée lors du début de la partie.
     */
    void onStart();

    /**
     * Cette méthode permet de changer le prochain cycle.
     * Par exemple si le cycle en paramètre est la nuit, alors la prochaine nuit sera en réalité un jour.
     *
     * @param cycleState le cycle à changer
     */
    void changeNextCycle(CycleState cycleState);

    /**
     * Cette méthode est appelée lorsque le cycle devient la nuit.
     */
    void onNight();

    /**
     * Cette méthode est appelée lorsque le cycle devient le jour.
     */
    void onDay();
}
