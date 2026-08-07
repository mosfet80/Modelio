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
package org.modelio.vcore.session.impl.storage;

import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Consumer;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.session.api.repository.IRepositoryChangeEvent;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MRef;
import org.modelio.vcore.smkernel.meta.SmMetamodel;

/**
 * Service used get a model loader.
 * <p>
 * The obtained loader must be used in a <i>try-with-resource</i> statement in order to always
 * be closed.
 * <p>
 * 2 model loader types are available: one standard model loader and
 * one that fires model change events.
 */
@objid ("8649af9a-19f2-11e2-8eb9-001ec947ccaf")
public interface IModelLoaderProvider {
    /**
     *
     * @return the kernel id.
     */
    @objid ("f6a871ca-3948-11e2-920a-001ec947ccaf")
    short getKid();

    /**
     * Begin a loading session.
     * <p>
     * Should be called only when no model loader is already available.
     * This loader must be used in a <i>try-with-resource</i> statement in order to always
     * be closed.
     *
     * @return a model loader.
     */
    @objid ("1fcf84c5-3a2d-11e2-bf6c-001ec947ccaf")
    IModelLoader beginLoadSession();

    /**
     * Refresh a part of the model as soon as possible, asynchronously.
     * <p>
     * The passed code may be run either immediately in the current thread or later in a non determined thread.
     * The refresh session is automatically closed on return and does not have to be closed by the code.
     *
     * @param refreshFunction code that uses the {@link IModelRefresher} to refresh the model from the repository.
     * @since 6.0.0 : replaces completely beginRefreshSession() that was not thread safe
     */
    @objid ("e71a43e0-d267-4d5e-8fca-6ebe488c7118")
    void asyncRefreshModel(Consumer<IModelRefresher> refreshFunction);

    /**
     * Refresh a part of the model and wait until the refresh runnable has completed.
     * <p>
     * This is intended for command paths that must not expose intermediate model state
     * to callers before the refresh has actually finished.
     *
     * @param refreshFunction code that uses the {@link IModelRefresher} to refresh the model from the repository.
     * @since 6.2.1
     */
    @objid ("38446f3a-a5ce-40cf-a86d-c7f0d88ddb4f")
    void syncRefreshModel(Consumer<IModelRefresher> refreshFunction);

    /**
     * Notifies the registered repository change listeners of a repository change.
     *
     * @param event the repository change event.
     */
    @objid ("66924011-c7c6-49c0-bffe-7b6ca182ce91")
    void fireRepositoryChange(IRepositoryChangeEvent event);

    /**
     * Get the metamodel to use to load objects.
     *
     * @return the metamodel to use.
     */
    @objid ("26303d20-619a-459f-a104-c35ff1da87d2")
    SmMetamodel getMetamodel();

    /**
     * Get the service used to schedule tasks in a background thread.
     * <p>
     * This service is closed with the session.
     * <p>
     * It can be used by the repository to make background work.
     *
     * @return the background task service.
     */
    @objid ("8a447076-8b7f-4751-b9d0-382bc72591f8")
    ScheduledExecutorService getSchedulerService();

    /**
     * Look up an object already known by the current session model, including deleted ones
     * that are still retained in session caches.
     *
     * FIXME : The implementation loads the element if not already loaded !
     *
     * @param ref the reference to look up.
     * @return the known model object, or {@code null} if the session does not currently know it.
     * @since 6.2.1
     * @deprecated This method is a Copilot design smell to be removed
     */
    @objid ("51904b0d-9847-464f-b3a0-bf43b592c284")
    @Deprecated(since = "2026-05-07", forRemoval = true)
    MObject findSessionObject(MRef ref);

}
