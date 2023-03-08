package fr.rhodless.akira.uhc.api.scheduler;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface SchedulerHandler {
    Scheduler runTaskTimer(Runnable runnable, long period, long time, AbstractScheduler... schedulers);

    Scheduler runTaskTimer(Runnable runnable, long time, AbstractScheduler... schedulers);

    Scheduler runTaskLater(Runnable runnable, long time);
}
