package fr.rhodless.akira.uhc.api.world;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public enum WorldConfigurationStatus {
    /**
     * Si le monde n'a pas été créé.
     */
    NOT_CREATED,
    /**
     * Si le monde a été créé.
     */
    CREATED,
    /**
     * Si le monde a été généré.
     */
    GENERATED
}
