package fr.rhodless.akira.uhc.api.scheduler.list;

import fr.rhodless.akira.uhc.api.scheduler.AbstractScheduler;
import fr.rhodless.akira.uhc.api.scheduler.Scheduler;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public class TimeScheduler extends AbstractScheduler {
    private int ticks = 0;

    private final int time;
    private final Runnable onFinish;

    public TimeScheduler(int time) {
        this.time = time;
        this.onFinish = null;
    }

    public TimeScheduler(int time, Runnable onFinish) {
        this.time = time;
        this.onFinish = onFinish;
    }

    public int getTime() {
        return time;
    }

    @Override
    public boolean onTick(Scheduler scheduler) {
        if (ticks++ == time) {
            if (this.onFinish != null) {
                this.onFinish.run();
            }
            return false;
        }

        return true;
    }
}
