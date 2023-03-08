package fr.rhodless.akira.uhc.api.scheduler.list;

import fr.rhodless.akira.uhc.api.scheduler.AbstractScheduler;
import fr.rhodless.akira.uhc.api.scheduler.Scheduler;

import java.util.function.Predicate;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public class PredicateScheduler extends AbstractScheduler {
    private final Predicate<? super Scheduler> canceler;

    public PredicateScheduler(Predicate<? super Scheduler> canceler) {
        this.canceler = canceler;
    }

    public Predicate<? super Scheduler> getCanceler() {
        return canceler;
    }

    @Override
    public boolean onTick(Scheduler scheduler) {
        return !this.canceler.test(scheduler);
    }
}
