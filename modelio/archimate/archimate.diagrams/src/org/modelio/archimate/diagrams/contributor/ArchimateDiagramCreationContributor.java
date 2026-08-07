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
import org.modelio.archimate.metamodel.core.ArchimateView;
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
 * Creation contributor for Archimate diagrams.
 */
@objid ("1a0b4004-435b-407c-a50c-47da46521a80")
public class ArchimateDiagramCreationContributor extends AbstractDiagramWizardContributor {
    @objid ("7bc13be2-1b72-4083-902a-fb50301be44a")
    @Inject
    @Optional
    protected IMModelServices mmServices;

    @objid ("56ac8f26-d614-4829-8739-a7fc0f0e0f0f")
    @Inject
    @Optional
    private ModelViewTemplateManager diagramCreationService;

    @objid ("dcb62335-beae-4af9-9f57-3c41df997e82")
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

    @objid ("5c4e39ce-0e32-43ad-bc00-87905da56558")
    @Override
    public Image getIconImage() {
        MMetamodel metamodel = getMetamodel();
        if (metamodel != null) {
            return MetamodelImageService.getIcon(metamodel.getMClass(ArchimateView.class));
        } else {
            return null;
        }

    }

    @objid ("fc0fcb48-8f92-450a-80a1-2d091e9ec22d")
    @Override
    public List<ElementScope> getScopes() {
        List<ElementScope> allowedScopes = new ArrayList<>();
        MMetamodel metamodel = getMetamodel();
        if (metamodel != null) {
            allowedScopes.add(new ElementScope(metamodel.getMClass(ViewPoint.class), true, null, true));
        }
        return allowedScopes;
    }

    @objid ("008bc5f1-8560-40b4-89d1-87a102eb8e3e")
    protected final void setElementDefaultName(ModelElement element) {
        String uniqueName = this.mmServices.getElementNamer().getUniqueName(element);
        if (uniqueName != null) {
            element.setName(uniqueName);
        }

    }

    @objid ("e13898c3-52bf-4f5d-b8d3-97de8288c278")
    protected final MMetamodel getMetamodel() {
        if (this.mmServices == null) {
            return null;
        } else {
            return this.mmServices.getMetamodel();
        }

    }

    @objid ("45011bb6-a501-49d6-84bd-7d8c967d2e70")
    @Override
    public final IPanelProvider getWizardPanel() {
        return new DefaultWizardPreviewPanel();
    }

    @objid ("7f5af40b-1d62-4682-8908-5943a992b34c")
    @Override
    protected boolean checkCanCreateIn(ModelElement owner) {
        return MTools.getAuthTool().canAdd(owner, ArchimateView.MQNAME);
    }

    @objid ("61878726-0a6c-446a-830e-d0bf1b417446")
    @Override
    public ElementDescriptor getCreatedElementType() {
        MClass mClass = this.mmServices.getMetamodel().getMClass(ArchimateView.class);
        return new ElementDescriptor(mClass, null);
    }

    @objid ("96db4861-8b2b-4709-9808-e0caeebb4f93")
    @Override
    public void dispose() {
        // Nothing to dispose
    }

}
