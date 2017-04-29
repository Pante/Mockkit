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

import com.karuslabs.mockkit.annotations.*;

import java.util.List;
import java.util.concurrent.*;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.*;


@PartialStub
public class StubScheduler implements BukkitScheduler {
    
    private ScheduledThreadPoolExecutor scheduler;
    private ConcurrentMap<Integer, Future<?>> tasks;
    
    
    protected StubScheduler() {
        scheduler = new ScheduledThreadPoolExecutor(1);
        scheduler.setMaximumPoolSize(4);
        scheduler.setRemoveOnCancelPolicy(true);
        tasks = new ConcurrentHashMap<>();
    }
    
    
    protected int random() {
        return ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
    }
    
    
    @Override
    @NonCompliant("Runnable will be executed immediately on the calling thread")
    public int scheduleSyncDelayedTask(Plugin plugin, Runnable task, long delay) {
        return scheduleSyncDelayedTask(plugin, task);
    }

    @Override
    @NonCompliant("BukkitRunnable will be executed immediately on the calling thread")
    public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task, long delay) {
        return scheduleSyncDelayedTask(plugin, (Runnable) task);
    }

    
    @Override
    public int scheduleSyncDelayedTask(Plugin plugin, Runnable task) {
        task.run();
        return random();
    }

    @Override
    public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task) {
        return scheduleSyncDelayedTask(plugin, (Runnable) task);
    }

    
    @Override
    @NonCompliant("Runnable will be executed immediately only once on the calling thread")
    public int scheduleSyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
        return scheduleSyncDelayedTask(plugin, task);
    }

    @Override
    @NonCompliant("BukkitRunnable will be executed immediately only once on the calling thread")
    public int scheduleSyncRepeatingTask(Plugin plugin, BukkitRunnable task, long delay, long period) {
        return scheduleSyncDelayedTask(plugin, (Runnable) task);
    }

    
    @Override
    public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task, long delay) {
        int random = random();
        ScheduledFuture<?> future = scheduler.schedule(task, Math.round(delay * 1000 / 20.0), TimeUnit.MILLISECONDS);
        tasks.put(random, future);
        
        return random;
    }

    @Override
    public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task) {
        int random = random();
        Future<?> future = scheduler.submit(() -> { task.run(); tasks.remove(random, task); });
        tasks.put(random, future);
        
        return random;
    }

    
    @Override
    public int scheduleAsyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
        int random = random();
        ScheduledFuture<?> future = scheduler.scheduleAtFixedRate(task, Math.round(delay * 1000 / 20.0), Math.round(period * 1000 / 20.0), TimeUnit.MILLISECONDS);
        tasks.put(random, future);
        
        return random;
    }

    
    @Override
    @NonCompliant("Callable will be executed on the calling thread")
    public <T> Future<T> callSyncMethod(Plugin plugin, Callable<T> task) {
        FutureTask<T> future = new FutureTask(task);
        future.run();
        
        return future;
    }

    
    @Override
    public void cancelTask(int taskId) {
        Future<?> future = tasks.remove(taskId);
        if (future != null) {
            future.cancel(true);
        }
    }

    @Override
    @NonCompliant("Cancels all tasks")
    public void cancelTasks(Plugin plugin) {
        cancelAllTasks();
    }

    @Override
    public void cancelAllTasks() {
        tasks.forEach((id, future) -> { future.cancel(true); tasks.remove(id, future); });
    }

    
    @Override
    @Unimplemented
    public boolean isCurrentlyRunning(int taskId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Unimplemented
    public boolean isQueued(int taskId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Unimplemented
    public List<BukkitWorker> getActiveWorkers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Unimplemented
    public List<BukkitTask> getPendingTasks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    @Override
    public @Stub BukkitTask runTask(Plugin plugin, Runnable task) {
        task.run();
        return new StubTask(this, random(), plugin, true);
    }

    @Override
    public @Stub BukkitTask runTask(Plugin plugin, BukkitRunnable task) {
        return runTask(plugin, (Runnable) task);
    }

    
    @Override
    public @Stub BukkitTask runTaskAsynchronously(Plugin plugin, Runnable task) {
        int random = random();
        Future<?> future = scheduler.submit(task);
        tasks.put(random, future);
        
        return new StubTask(this, random, plugin, false);
    }

    @Override
    public @Stub BukkitTask runTaskAsynchronously(Plugin plugin, BukkitRunnable task) {
        return runTaskAsynchronously(plugin, (Runnable) task);
    }

    
    @Override
    @NonCompliant("Runnable will be executed immediately")
    public @Stub BukkitTask runTaskLater(Plugin plugin, Runnable task, long delay) {
        return runTask(plugin, task);
    }

    @Override
    @NonCompliant("Runnable will be executed immediately")
    public @Stub BukkitTask runTaskLater(Plugin plugin, BukkitRunnable task, long delay) {
        return runTask(plugin, task);
    }

    
    @Override
    public @Stub BukkitTask runTaskLaterAsynchronously(Plugin plugin, Runnable task, long delay) {
        int random = random();
        ScheduledFuture<?> future = scheduler.schedule(task, Math.round(delay * 1000 / 20.0), TimeUnit.MILLISECONDS);
        tasks.put(random, future);
        
        return new StubTask(this, random, plugin, false);
    }

    @Override
    public @Stub BukkitTask runTaskLaterAsynchronously(Plugin plugin, BukkitRunnable task, long delay) {
        return runTaskLaterAsynchronously(plugin, (Runnable) task, delay);
    }

    
    @Override
    @NonCompliant("Runnable will be executed immediately")
    public @Stub BukkitTask runTaskTimer(Plugin plugin, Runnable task, long delay, long period) {
        return runTask(plugin, task);
    }

    @Override
    @NonCompliant("Runnable will be executed immediately")
    public @Stub BukkitTask runTaskTimer(Plugin plugin, BukkitRunnable task, long delay, long period) {
        return runTask(plugin, task);
    }

    
    @Override
    public @Stub BukkitTask runTaskTimerAsynchronously(Plugin plugin, Runnable task, long delay, long period) {
        int random = random();
        ScheduledFuture<?> future = scheduler.scheduleAtFixedRate(task, Math.round(delay * 1000 / 20.0), Math.round(period * 1000 / 20.0), TimeUnit.MILLISECONDS);
        tasks.put(random, future);
        
        return new StubTask(this, random, plugin, false);
    }

    @Override
    public @Stub BukkitTask runTaskTimerAsynchronously(Plugin plugin, BukkitRunnable task, long delay, long period) {
        return runTaskTimerAsynchronously(plugin, task, delay, period);
    }

    
    public ConcurrentMap<Integer, Future<?>> getTasks() {
        return tasks;
    }
    
}
