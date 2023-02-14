package fr.rhodless.akira.uhc.api.game.scenario;

import java.util.List;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface ScenarioHandler {
    /**
     * Permet de récupérer la liste des scénarios.
     *
     * @return la liste des scénarios
     */
    List<Scenario> getScenarios();

    /**
     * Permet de récupérer la liste des scénarios activés.
     *
     * @return la liste des scénarios activés
     */
    List<Scenario> getEnabledScenarios();

    /**
     * Permet d'enregistrer un scénario.
     * Ce scénario sera ajouté à la liste des scénarios.
     *
     * @param scenario le scénario à enregistrer
     */
    void registerScenario(Scenario scenario);

    /**
     * Permet de gérer le commencement de la partie.
     */
    void handleStart();
}
