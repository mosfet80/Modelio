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
package org.modelio.archimate.diagrams.contributor;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.inject.Inject;
import org.eclipse.e4.core.di.annotations.Optional;
import org.modelio.api.ui.viewtemplate.IModelViewTemplate;
import org.modelio.archimate.metamodel.mmextensions.archimate.IArchimateModelFactory;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.metamodel.mmextensions.standard.services.IMModelServices;
import org.modelio.metamodel.uml.infrastructure.ModelElement;

@objid ("ad3cb9f7-5767-435a-a4af-1900ec2035b1")
public class ViewPointDiagramTemplate implements IModelViewTemplate<AbstractDiagram> {
    @objid ("be312048-ca6e-4e74-9d1b-1ad239f1a765")
    @Inject
    @Optional
    protected IMModelServices mmServices;

    /**
     * Mandatory default c'tor needed by eclipse when loading the extension point.
     */
    @objid ("3ecfd7d0-3351-4430-a7e9-cb5edb7f0231")
    public ViewPointDiagramTemplate() {
        super();
    }

    @objid ("573f9414-07f3-4e5c-8584-78461b123a8b")
    @Override
    public String getId() {
        return this.getClass().getSimpleName();
    }

    @objid ("9ba2e781-788f-4375-98ed-f9df41963b74")
    @Override
    public AbstractDiagram createView(ModelElement base) {
        IArchimateModelFactory modelFactory = this.mmServices.getModelFactory().getFactory(IArchimateModelFactory.class);
        AbstractDiagram diagram =  modelFactory.createViewPointDiagram();
        diagram.setOrigin(base);
        diagram.setName(this.mmServices.getElementNamer().getUniqueName(diagram));
        return diagram;
    }

    @objid ("9bd053c7-f2f7-4845-b8e4-347ff33c030d")
    @Override
    public AbstractDiagram getExistingView(ModelElement base) {
        // Not supported concept
        return null;
    }

    @objid ("4dbb3ece-574c-4b01-87bd-ad3e9c4b19b5")
    @Override
    public void updateView(AbstractDiagram existingView) {
        // Not supported concept
    }

    @objid ("3f63f160-3b59-4c24-9a4c-c2a9bede8cf2")
    @Override
    public ModelElement resolveOrigin(ModelElement base) {
        return base;
    }

    @objid ("3926ea67-cab1-4f95-b7ba-12c5a7c07110")
    @Override
    public ModelElement getMainElement(AbstractDiagram view) {
        return view.getOrigin();
    }

}
