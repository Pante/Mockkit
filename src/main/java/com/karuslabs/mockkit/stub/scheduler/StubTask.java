/*
 * Copyright (C) 2017 Karus Labs
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.karuslabs.mockkit.stub.scheduler;

import java.util.concurrent.Future;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.*;


public class StubTask implements BukkitTask {
    
    private StubScheduler scheduler;
    private int id;
    private Plugin plugin;
    private boolean sync;
   
    
    public StubTask(StubScheduler scheduler, int id, Plugin plugin, boolean sync) {
        this.scheduler = scheduler;
        this.id = id;
        this.plugin = plugin;
        this.sync = sync;
    }
    
    
    @Override
    public int getTaskId() {
        return id;
    }

    @Override
    public Plugin getOwner() {
        return plugin;
    }

    @Override
    public boolean isSync() {
        return sync;
    }

    @Override
    public void cancel() {
        Future<?> future = scheduler.getTasks().remove(id);
        if (future != null) {
            future.cancel(true);
        }
    }
    
}
