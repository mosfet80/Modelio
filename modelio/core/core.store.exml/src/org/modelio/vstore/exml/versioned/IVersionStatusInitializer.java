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
package org.modelio.vstore.exml.versioned;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.session.impl.storage.IModelLoader;
import org.modelio.vcore.smkernel.SmObjectImpl;

/**
 * Interface to implement to initialize CMS status flags.
 */
@objid ("94fe420d-1e83-11e2-90db-001ec947ccaf")
public interface IVersionStatusInitializer {
    /**
     * Initialize the CMS status flags for a given element being loaded.
     * <p>
     * These flags must be set using the given {@link IModelLoader}.
     *
     * @param obj a model object being loaded.
     * @param modelLoader the model loading API to use to initialize flags.
     */
    @objid ("fbf296a7-1e83-11e2-90db-001ec947ccaf")
    void initObjectStatus(SmObjectImpl obj, IModelLoader modelLoader);

    /**
     * Loads the CMS status flags for a given CMS node.
     * <p>
     * These flags must be set using the given {@link IModelLoader}.
     *
     * @param obj a CMS node.
     * @param modelLoader the model loading API to use to initialize flags.
     */
    @objid ("c32f7ce7-b615-4a57-a8d1-56bc6c907a13")
    void loadCmsNodeStatus(SmObjectImpl obj, IModelLoader modelLoader);

    /**
     * Load/initialize the CMS status flags for a given element whose loading failed.
     * <p>
     * These flags must be set using the given {@link IModelLoader}.
     *
     * @param obj a model object being loaded.
     * @param modelLoader the model loading API to use to initialize flags.
     */
    @objid ("55e11129-575e-4ed6-9975-467c9e33c683")
    void onLoadFailed(SmObjectImpl obj, IModelLoader modelLoader);

}
