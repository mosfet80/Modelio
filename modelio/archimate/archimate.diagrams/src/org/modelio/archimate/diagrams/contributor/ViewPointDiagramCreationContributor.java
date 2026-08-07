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

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.inject.Inject;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.swt.graphics.Image;
import org.modelio.api.modelio.model.scope.ElementScope;
import org.modelio.api.module.contributor.ElementDescriptor;
import org.modelio.api.module.contributor.diagramcreation.AbstractDiagramWizardContributor;
import org.modelio.api.ui.contributor.DefaultWizardPreviewPanel;
import org.modelio.api.ui.viewtemplate.IModelViewTemplate;
import org.modelio.archimate.metamodel.core.ViewPointDiagram;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.metamodel.mmextensions.standard.services.IMModelServices;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.platform.model.ui.swt.images.MetamodelImageService;
import org.modelio.platform.model.view.template.service.ModelViewTemplateManager;
import org.modelio.platform.ui.panel.IPanelProvider;
import org.modelio.vcore.model.api.MTools;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MMetamodel;

/**
 * Creation contributor for ViewPoint diagrams.
 */
@objid ("4471ecd8-1845-44fb-9346-a1af813dcd86")
public class ViewPointDiagramCreationContributor extends AbstractDiagramWizardContributor {
    @objid ("9a31c1d5-8f33-475e-8e69-246f85fde014")
    @Inject
    @Optional
    protected IMModelServices mmServices;

    @objid ("4ed574c5-9343-4419-a3e0-df26db3c7c19")
    @Inject
    @Optional
    private ModelViewTemplateManager diagramCreationService;

    @objid ("07b1f50d-d1c1-4f0e-b427-d8f626970eac")
    @Override
    public AbstractDiagram actionPerformed(final ModelElement diagramContext, final String diagramName, final String diagramDescription) {
        if (diagramContext == null) {
            return null;
        }
        IModelViewTemplate<AbstractDiagram> template = this.diagramCreationService.get(getModelViewTemplateId());
        AbstractDiagram diagram = template.createView(diagramContext);
        if (!diagramName.equals(getLabel())) {
            diagram.setName(diagramName);
        }
        diagram.putNoteContent("ModelerModule", ModelElement.MQNAME, "description", diagramDescription);
        return diagram;
    }

    @objid ("34684754-cdc6-414f-ab4e-85700dd58346")
    @Override
    public Image getIconImage() {
        return MetamodelImageService.getIcon(getMetamodel().getMClass(ViewPointDiagram.class));
    }

    @objid ("afb091fd-8c86-496d-bf4b-2c148edbcfb8")
    @Override
    public List<ElementScope> getScopes() {
        List<ElementScope> allowedScopes = new ArrayList<>();
        allowedScopes.add(new ElementScope(getMetamodel().getMClass(ViewPoint.class), true, null, true));
        return allowedScopes;
    }

    @objid ("13d47e55-58ec-4b25-9064-070e314e50a2")
    protected final void setElementDefaultName(ModelElement element) {
        String uniqueName = this.mmServices.getElementNamer().getUniqueName(element);
        if (uniqueName != null) {
            element.setName(uniqueName);
        }

    }

    @objid ("8239045e-e11d-414b-b564-437ff5ad7c09")
    protected final MMetamodel getMetamodel() {
        return this.mmServices.getMetamodel();
    }

    @objid ("b64c2f21-6132-4f13-b46d-50027fc68246")
    @Override
    public final IPanelProvider getWizardPanel() {
        return new DefaultWizardPreviewPanel();
    }

    @objid ("40e8f32e-e615-42d3-ae8e-9f20fde25db3")
    @Override
    protected boolean checkCanCreateIn(ModelElement owner) {
        return MTools.getAuthTool().canAdd(owner, ViewPointDiagram.MQNAME);
    }

    @objid ("d5f5a5ce-1c36-4f1a-8bdb-0530d9b41650")
    @Override
    public ElementDescriptor getCreatedElementType() {
        MClass mClass = this.mmServices.getMetamodel().getMClass(ViewPointDiagram.class);
        return new ElementDescriptor(mClass, null);
    }

    @objid ("8b1c4da0-8296-4d4d-b6d2-d882e3925ec5")
    @Override
    public void dispose() {
        // Nothing to dispose
    }

}
