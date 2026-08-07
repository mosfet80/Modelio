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

@objid ("0ff8a3bc-8e44-4157-94b6-c50a11181049")
public class ArchimateDiagramTemplate implements IModelViewTemplate<AbstractDiagram> {
    @objid ("47cc8051-b7f7-407d-9124-c49dbaa31c5a")
    @Inject
    @Optional
    protected IMModelServices mmServices;

    @objid ("d590ba5b-0986-4711-bdc1-5559c571faf0")
    @Override
    public String getId() {
        return this.getClass().getSimpleName();
    }

    @objid ("f0305d05-581a-4ff2-b50d-41dc95c18c17")
    @Override
    public AbstractDiagram createView(ModelElement base) {
        IArchimateModelFactory modelFactory = this.mmServices.getModelFactory().getFactory(IArchimateModelFactory.class);
        AbstractDiagram diagram = modelFactory.createArchimateView();
        diagram.setOrigin(base);
        diagram.setName(this.mmServices.getElementNamer().getUniqueName(diagram));
        return diagram;
    }

    @objid ("7f243f45-e12c-47ca-950c-27fa8bd5b56b")
    @Override
    public AbstractDiagram getExistingView(ModelElement base) {
        // Not supported concept
        return null;
    }

    @objid ("cc342f5e-d095-443b-b202-847f461f962b")
    @Override
    public void updateView(AbstractDiagram existingView) {
        // Not supported concept
    }

    @objid ("fb4cec3d-e227-433f-80f4-c95499f4148c")
    @Override
    public ModelElement resolveOrigin(ModelElement base) {
        return base;
    }

    @objid ("139fd691-8b2a-4345-8d19-87b7850b3144")
    @Override
    public ModelElement getMainElement(AbstractDiagram view) {
        return view.getOrigin();
    }

    /**
     * Mandatory default c'tor needed by eclipse when loading the extension point.
     */
    @objid ("757c4dd6-5a4b-448c-8b68-1284f87bd8aa")
    public ArchimateDiagramTemplate() {
        super();
    }

}
