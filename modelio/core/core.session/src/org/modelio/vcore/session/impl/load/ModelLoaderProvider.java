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
package org.modelio.vcore.session.impl.load;

import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vbasic.debug.ThreadDumper;
import org.modelio.vcore.session.api.repository.IRepositoryChangeEvent;
import org.modelio.vcore.session.impl.storage.IModelLoader;
import org.modelio.vcore.session.impl.storage.IModelLoaderProvider;
import org.modelio.vcore.session.impl.storage.IModelRefresher;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MRef;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmMetamodel;

/**
 * Implementation of {@link IModelLoaderProvider}.
 * <p>
 * Handles a concurrent pool of {@link IModelLoader} and
 * provides the first free one in {@link #beginLoadSession()}.
 */
@objid ("a55c7527-1a03-11e2-8eb9-001ec947ccaf")
public class ModelLoaderProvider implements IModelLoaderProvider {
    @objid ("b42ab8d9-a2ba-4f87-bd56-95d820c702d6")
    private final Queue<IModelLoader> loaderPool;

    @objid ("ec10b3aa-88ee-47f4-a299-96858cfffa9e")
    private final ModelLoaderConfiguration loaderConfig;

    @objid ("34a3103c-6fc0-434e-b100-a7fed28526aa")
    private final Queue<IModelLoader> refreshPool;

    /**
     * Initialize the model loader provider.
     *
     * @param loaderConfig The model loaders configuration.
     */
    @objid ("7dc20091-1c43-11e2-8eb9-001ec947ccaf")
    public ModelLoaderProvider(ModelLoaderConfiguration loaderConfig) {
        this.loaderPool = new ConcurrentLinkedQueue<>();
        this.refreshPool = new ConcurrentLinkedQueue<>();
        this.loaderConfig = loaderConfig;
    }

    @objid ("f69ee879-3948-11e2-920a-001ec947ccaf")
    @Override
    public short getKid() {
        return this.loaderConfig.getKid();
    }

    @objid ("1fc5fb7a-3a2d-11e2-bf6c-001ec947ccaf")
    @Override
    public IModelLoader beginLoadSession() {
        IModelLoader ret = this.loaderPool.poll();
        if (ret == null) {
            ret = new ModelLoader(this.loaderConfig, this.loaderPool);
        }

        ret.begin();
        return ret;
    }

    @objid ("b02c4de4-aa36-4dc4-8fda-60fbc92acecb")
    @Override
    public void asyncRefreshModel(Consumer<IModelRefresher> refreshFunction) {
        this.loaderConfig.getTransactionSupport().asyncExec(() -> {
            @SuppressWarnings ("resource")
            ModelRefresher ret = (ModelRefresher) this.refreshPool.poll();
            if (ret == null) {
                ret = new ModelRefresher(this.loaderConfig, this.refreshPool);
            }

            ret.begin();
            try (ModelRefresher toClose = ret){
                refreshFunction.accept(ret);
            }
        });
    }

    @objid ("d81f0572-7c5b-41b3-b780-310b34f5a147")
    @Override
    public void syncRefreshModel(Consumer<IModelRefresher> refreshFunction) {
        if (this.loaderConfig.getTransactionSupport().hasCurrentTransaction()) {
            runRefreshNow(refreshFunction);
            return;
        }

        CompletableFuture<Void> future = new CompletableFuture<>();

        asyncRefreshModel(refresher -> {
            try {
                refreshFunction.accept(refresher);
                future.complete(null);
            } catch (Throwable t) {
                future.completeExceptionally(t);
                throw t;
            }
        });

        try {
            future.orTimeout(30, TimeUnit.SECONDS).join();
        } catch (CompletionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof TimeoutException) {
                ThreadDumper.get().getAllThreads(true).addAsSupressed(cause);
                throw new IllegalStateException("Timeout waiting for model refresh completion (possible deadlock).", cause);
            }
            if (cause instanceof Error) {
                throw (Error) cause;
            }
            throw new IllegalStateException("Model refresh failed.", cause);
        }
    }

    @objid ("cce4dfaf-bb3e-4271-a674-f7f06a9d93ee")
    private void runRefreshNow(Consumer<IModelRefresher> refreshFunction) {
        //@SuppressWarnings ("resource")
        ModelRefresher ret = (ModelRefresher) this.refreshPool.poll();
        if (ret == null) {
            ret = new ModelRefresher(this.loaderConfig, this.refreshPool);
        }

        ret.begin();
        try (ModelRefresher toClose = ret) {
            refreshFunction.accept(ret);
        }
    }

    @objid ("591da55f-6323-4bd6-ad16-d447a8ee0ed1")
    @Override
    public void fireRepositoryChange(IRepositoryChangeEvent event) {
        this.loaderConfig.getSession().getRepositorySupport().fireRepositoryChange(event);
    }

    @objid ("4e669a55-78b0-437c-a8fa-8b83668a4c70")
    @Override
    public SmMetamodel getMetamodel() {
        return this.loaderConfig.getMetamodel();
    }

    @objid ("feb580e8-ceef-46c8-8ecf-29ed7290958f")
    @Override
    public ScheduledExecutorService getSchedulerService() {
        return this.loaderConfig.getSession().getSchedulerService();
    }

    @objid ("a04f4b3e-024d-42bb-a89c-9a3a433ab6d3")
    @Override
    public MObject findSessionObject(MRef ref) {
        SmClass cls = this.loaderConfig.getMetamodel().getMClass(ref.mc);
        if (cls == null) {
            return null;
        }
        // FIXME : this will load the object if it is not already loaded!!
        return this.loaderConfig.getSession().getModel().findById(cls, ref.uuid);
    }

}
