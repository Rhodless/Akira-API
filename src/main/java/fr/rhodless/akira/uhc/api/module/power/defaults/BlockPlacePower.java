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
 * Ce pouvoir s'active lorsque le joueur pose un bloc avec l'item
 */
public abstract class BlockPlacePower extends ItemPower {
    public BlockPlacePower(int cooldown, int maxUses) {
        super(cooldown, maxUses);
    }
}
