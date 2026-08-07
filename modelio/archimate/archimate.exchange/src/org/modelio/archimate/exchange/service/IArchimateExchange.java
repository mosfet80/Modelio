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
package org.modelio.archimate.exchange.service;

import java.nio.file.Path;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.core.runtime.IProgressMonitor;
import org.modelio.archimate.exchange.service.exception.ArchimateException;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("37da5f9e-ccd1-4fcf-8d8a-7f311e8749ad")
public interface IArchimateExchange {
    @objid ("ce61620b-3123-4c6f-b0c6-6f1b867a3c51")
    Path exportArchimateModel(Path filePath, Model context) throws ArchimateException;

    @objid ("8d5138dd-7397-4ddc-837a-8aecb35d7ffa")
    MObject importArchimateModel(Path filePath, Object context, boolean keepId, boolean nativeStyle) throws ArchimateException;

    @objid ("8e5db5c9-1f47-4040-9a52-d8d9986bd5fa")
    void setProgressMonitor(IProgressMonitor progress);

}
