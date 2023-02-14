package fr.rhodless.akira.uhc.api.hotbar;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public class ActionBarValue {
    private final String id;
    private final String name;
    private final String value;

    /**
     * @param id    l'id de la valeur
     * @param name  le nom de la valeur
     * @param value la valeur
     */
    public ActionBarValue(String id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }


    /**
     * Permet de récupérer l'id de la valeur.
     *
     * @return l'id de la valeur
     */
    public String getId() {
        return id;
    }

    /**
     * Permet de récupérer le nom de la valeur.
     *
     * @return le nom de la valeur
     */
    public String getName() {
        return name;
    }

    /**
     * Permet de récupérer la valeur.
     *
     * @return la valeur
     */
    public String getValue() {
        return value;
    }
}
