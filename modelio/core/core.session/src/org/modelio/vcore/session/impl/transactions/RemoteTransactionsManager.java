/*
 * Copyright 2013-2025 Docaposte
 *
 * This file is part of Modelio.
 *
 * Modelio is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Modelio is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Modelio.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
/*
 * Copyright 2013-2024 Docaposte
 *
 * This file is part of Modelio.
 *
 * Modelio is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Modelio is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Modelio.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.modelio.vcore.session.impl.transactions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vbasic.log.Log;
import org.modelio.vcore.smkernel.transaction.ISmRemoteTransaction;
import org.modelio.vcore.smkernel.transaction.SmTransactionException;

/**
 * Service to commit remote transactions using the 2 phases commit pattern.
 *
 * @since 5.5 06/02/2024
 */
@objid ("4fea4b88-6e74-4ae6-987b-5b8b5d8751d6")
class RemoteTransactionsManager {
    @objid ("6f5358f9-1b3b-43fe-80c3-c25fa3115444")
    private static final ExecutorService executor = initExecutor();

    @objid ("034719b2-56a0-4208-b88e-b77bf71e301c")
    public static void commit(Collection<ISmRemoteTransaction> transactions) throws SmTransactionException {
        // Fast exit if nothing to do
        if (transactions.isEmpty())
            return ;

        final int MIN_TIMEOUT_SECONDS = 2;

        // Easy path if only one remote transaction
        if (transactions.size() == 1) {
            ISmRemoteTransaction rt = transactions.iterator().next();

            final boolean DEBUG = false;
            long timeOutMillis = rt.getCommitExpectedMaxDuration().plusSeconds(MIN_TIMEOUT_SECONDS).toMillis();
            if (DEBUG) timeOutMillis = TimeUnit.HOURS.toMillis(2);

            try {
                runAsync(rt::prepareCommit).get(timeOutMillis, TimeUnit.MILLISECONDS);
                runAsync(rt::commit).get(timeOutMillis, TimeUnit.MILLISECONDS);
                // Done
                return;
            } catch (InterruptedException e) {
                throw new SmTransactionException(e.getLocalizedMessage(), e);
            } catch (ExecutionException e) {
                throw new SmTransactionException(e.getCause().getLocalizedMessage(), e);
            } catch (TimeoutException e) {
                // TimeoutException thrown by
                //  java.util.concurrent.CompletableFuture.timedGet(CompletableFuture.java:1960)
                // has no message.
                throw new SmTransactionException(String.format("Time out waiting %d millis for remote transaction commit.", timeOutMillis), e);
            }
        }

        // Hard path : implement 2 phases commit asynchronously
        Duration timeoutSum = transactions.stream().map(t -> t.getCommitExpectedMaxDuration())
                .reduce((a,b)-> a.plus(b))
                .orElseThrow()
                .plusSeconds(MIN_TIMEOUT_SECONDS);
        try {
            new PhaseCoordinator(transactions, ISmRemoteTransaction::prepareCommit, ISmRemoteTransaction::rollback)
            .asFuture(timeoutSum.toSeconds(), TimeUnit.SECONDS)
            .thenComposeAsync(
                    $ -> new PhaseCoordinator(transactions, ISmRemoteTransaction::commit, t -> {}) // no rollback on failure here: too hard to implement
                    .asFuture(timeoutSum.toSeconds(), TimeUnit.SECONDS))
            .get(timeoutSum.toSeconds() * 2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new SmTransactionException(e.getLocalizedMessage(), e);
        } catch (ExecutionException e) {
            throw new SmTransactionException(e.getCause().getLocalizedMessage(), e);
        } catch (TimeoutException e) {
            // TimeoutException thrown by
            //  java.util.concurrent.CompletableFuture.timedGet(CompletableFuture.java:1960)
            // has no message.

            String msg = e.getMessage();
            if (msg==null) msg = String.format("Time out waiting %d millis for remote transaction commit.", timeoutSum.toMillis());
            throw new SmTransactionException(msg, e);
        }
    }

    @objid ("34dcceda-d223-4c07-9876-85a7bf864222")
    private static CompletableFuture<Void> runAsync(Runnable r) {
        return CompletableFuture.runAsync(r, executor);
    }

    /**
     *
     * @return Create a thread pool to commit distributed remote transactions in parallel.
     */
    @objid ("783c2dca-4970-4e6a-b08d-8b1b32f9082c")
    private static ExecutorService initExecutor() {
        final AtomicInteger threadNumber = new AtomicInteger(1);
        final ThreadGroup group = new ThreadGroup("GlobalTransaction");
        return Executors.newCachedThreadPool(runnable -> {
            Thread t = new Thread(
                    group,
                    runnable,
                    "GlobalTransaction-thread-" + threadNumber.getAndIncrement());
            if (!t.isDaemon())
                t.setDaemon(true);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        });
    }

    /**
     * Aggregates all remote commits results and trigger the rollback of the
     * successful commits in case one of them fails or times out.
     *
     * @net.jcip.annotations.ThreadSafe
     */
    @objid ("09b3b7c9-b5b6-47a3-926a-c20ff07d0966")
    private static class PhaseCoordinator {
        /**
         * Count of tasks still running.
         *
         * @net.jcip.annotations.GuardedBy("this")
         */
        @objid ("ecfe6422-396a-497e-8771-4891e8d70035")
        private int remainingCount;

        @objid ("6ffb9718-d86e-4d62-a93f-c905f8acce95")
        private final int totalCount;

        /**
         * future that completes once all tasks are done or as soon as one fails.
         */
        @objid ("dbbf198e-2612-4b03-a965-c433399b4d49")
        private final CompletableFuture<Void> allDone;

        /**
         * Contains one compensation Runnable for each task that has already completed.
         *
         * @net.jcip.annotations.GuardedBy("this")
         */
        @objid ("72f9c7bb-1886-4a00-b93a-a9d5b828c511")
        private final Collection<Runnable> allCompensations;

        /**
         *
         * @param start the number of remote actions to wait for.
         */
        @objid ("64a6690b-a204-42eb-b228-0d433b2ed740")
        public PhaseCoordinator(int start) {
            this.remainingCount = start;
            this.totalCount = start;
            this.allDone = new CompletableFuture<>();
            this.allCompensations = new ArrayList<>(start);

            // Trigger transaction undo on failure
            this.allDone.exceptionally( t->compensateAll() );
        }

        /**
         *
         * @param col the remote transactions
         * @param committer the action to call on each remote transaction
         * @param compensate the action to call to compensate the action on rollback
         */
        @objid ("515cbda4-3059-491a-ae2b-824cffacabcd")
        public PhaseCoordinator(Collection<ISmRemoteTransaction> col, Consumer<ISmRemoteTransaction> committer, Consumer<ISmRemoteTransaction> compensate) {
            this(col.size());
            for (ISmRemoteTransaction t : col) {
                add(runAsync(() -> committer.accept(t)), () -> compensate.accept(t));
            }
        }

        /**
         * Register an async action, and its compensation action
         *
         * @param participant an async action, potentially already running.
         * @param compensate a runnable that can undo the async action.
         */
        @objid ("b15c2cc3-694c-4b92-b51d-a8421536152f")
        public void add(CompletableFuture<Void> participant, Runnable compensate) {
            participant.whenComplete((Void v, Throwable error) -> onOneComplete(error, compensate));
        }

        /**
         * Start waiting for completion of all actions.
         *
         * @param timeout how long to wait, in units of {@code unit}. ZERO means no time out.
         * @param unit a {@code TimeUnit} determining how to interpret the
         * {@code timeout} parameter
         * @return future that completes once all tasks are done or as soon as one fails.
         */
        @objid ("c9839fdd-ec41-4ddd-89ff-0a5218885726")
        public CompletableFuture<Void> asFuture(long timeout, TimeUnit unit) {
            if (timeout > 0 && ! this.allDone.isDone()) {
                // Add a time out
                CompletableFuture.delayedExecutor(timeout, unit, executor).execute(() -> {
                    if (!this.allDone.isDone()) synchronized(this) {
                        String msg = String.format("Time out waiting %d %s for %d/%d remote transactions to commit.", timeout, unit, this.remainingCount, this.totalCount);
                        this.allDone.completeExceptionally(new TimeoutException(msg));
                    }
                });
            }
            return this.allDone;
        }

        @objid ("d9c39d5d-5f73-44b9-9da8-c46c580876cb")
        private synchronized void onOneComplete(Throwable error, Runnable compensate) {
            if (error == null) {
                // One success
                if (this.allDone.isCompletedExceptionally()) {
                    // Time out or another transaction already failed.
                    // Undo the commit immediately.
                    executor.execute(compensate);
                } else {
                    // Success, keep the compensation action
                    this.allCompensations.add(compensate);
                }
            } else {
                // Failure, trigger global failure that triggers all compensation actions.
                Log.error(error);
                this.allDone.completeExceptionally(error);
            }

            if ( --this.remainingCount == 0) {
                // Everybody completed (success or failure) ,
                // complete global as success if not already failed.
                this.allDone.complete(null);
            }
        }

        @objid ("b5d46bd9-183e-42fa-863f-4250bf84282d")
        private Void compensateAll() {
            for (Runnable runnable : this.allCompensations) {
                executor.execute(runnable);
            }
            return null;
        }

    }

}
