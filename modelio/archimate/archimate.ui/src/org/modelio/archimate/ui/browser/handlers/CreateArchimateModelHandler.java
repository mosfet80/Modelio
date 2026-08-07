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
package org.modelio.archimate.ui.browser.handlers;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.archimate.metamodel.mmextensions.archimate.IArchimateModelFactory;
import org.modelio.archimate.ui.plugin.ArchiUi;
import org.modelio.metamodel.mmextensions.standard.services.IMModelServices;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.model.browser.view.handlers.create.CreateElementHandler;
import org.modelio.vcore.model.api.IElementNamerService;
import org.modelio.vcore.model.api.MTools;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.session.api.transactions.ITransaction;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MDependency;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("c2e2b12b-a00d-4892-b8c7-faab9ebbd0b4")
public class CreateArchimateModelHandler extends CreateElementHandler {
    /**
     * This method create the viewpoint automatically when it create the model
     *
     * @return the new Model created.
     */
    @objid ("853c8ac1-3690-472c-87b5-4d0b3e8c112e")
    @Override
    protected MObject doCreate(MObject owner, MClass metaclass, MDependency dependency, Stereotype stereotype, IMModelServices mmServices) {
        final ICoreSession session = this.projectService.getSession();
        Model newModel = null;
        try (ITransaction t = session.getTransactionSupport().createTransaction("Create ArchiMate Model")) {
            MTools mTools = MTools.get(session);
            IElementNamerService namer = mTools.getNamer();
            IArchimateModelFactory modelFactory = mTools.getModelFactory(IArchimateModelFactory.class);
            //create the model
            newModel = modelFactory.createModel();
            newModel.setProject((ArchimateProject) owner);
            newModel.setName(namer.getUniqueName(namer.getBaseName(newModel), newModel));
            //create the viewPoint
            ViewPoint newViewPoint = modelFactory.createViewPoint();
            newViewPoint.setProject((ArchimateProject) owner);
            newViewPoint.setName(namer.getUniqueName(namer.getBaseName(newViewPoint), newViewPoint));
            newViewPoint.setContext(newModel);
            t.commit();
        } catch (Exception e) {
            ArchiUi.LOG.error("CreateArchimateModelHandler: \n\tCannot create an Archimate Model");
            ArchiUi.LOG.error(e);
        }
        return newModel;
    }

}
