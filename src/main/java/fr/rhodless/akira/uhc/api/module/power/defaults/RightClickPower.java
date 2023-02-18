package fr.rhodless.akira.uhc.api.module.power.defaults;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */

/**
 * Ce pouvoir s'active lorsque le joueur fait un clic droit avec l'item
 */
public abstract class RightClickPower extends ItemPower {
    public RightClickPower(int cooldown, int maxUses) {
        super(cooldown, maxUses);
    }
}
