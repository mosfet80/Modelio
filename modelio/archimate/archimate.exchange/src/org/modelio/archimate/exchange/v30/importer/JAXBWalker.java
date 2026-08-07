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
package org.modelio.archimate.exchange.v30.importer;

import java.util.HashMap;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.swt.widgets.Display;
import org.modelio.archimate.exchange.plugin.ArchiExchange;
import org.modelio.archimate.exchange.v30.importer.factory.IDiagramFactoryImport;
import org.modelio.archimate.exchange.v30.importer.factory.IElementFactoryImport;
import org.modelio.archimate.exchange.v30.xmlmodel.Diagram;
import org.modelio.archimate.exchange.v30.xmlmodel.ElementType;
import org.modelio.archimate.exchange.v30.xmlmodel.ModelType;
import org.modelio.archimate.exchange.v30.xmlmodel.OrganizationsType;
import org.modelio.archimate.exchange.v30.xmlmodel.RelationshipType;
import org.modelio.archimate.exchange.v30.xmlmodel.ViewpointType;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.metamodel.mmextensions.infrastructure.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.session.api.transactions.ITransaction;

@objid ("14baee54-f5f4-4f5a-9648-a4286f641834")
public class JAXBWalker {
    @objid ("b26076fa-7ce6-4e60-a1c7-137e71742e35")
    private IElementFactoryImport elementFactory;

    @objid ("33edbce4-fc42-4122-99a9-012060307b03")
    private IDiagramFactoryImport diagramFactory;

    @objid ("8139822e-68b4-4df3-8a73-d60c40f7c0b2")
    private ArchimateProject context;

    @objid ("46c3bf16-489e-4825-b00c-a098450ab820")
    private ICoreSession session;

    @objid ("447cc6a7-9d17-49aa-b242-9cb2cbff976f")
    public JAXBWalker(IElementFactoryImport elementFactory, IDiagramFactoryImport diagramFactory, ArchimateProject context, ICoreSession session) {
        this.elementFactory = elementFactory;
        this.diagramFactory = diagramFactory;
        this.context = context;
        this.session = session;

    }

    @objid ("cb5388b7-0977-4631-a4fd-f2ea10e2c9ba")
    public void walk(ModelType jaxModel, IProgressMonitor progress) {
        Map<String, ModelElement> refs = new HashMap<>();
        this.elementFactory.setReferenceMap(refs);
        this.diagramFactory.setReferenceMap(refs);

        SubMonitor monitor = null;
        if (progress != null) {
            int workload = 2;
            if (jaxModel.getViews() != null) {
                workload = workload + jaxModel.getViews().getDiagrams().getView().size();
            }
            monitor = SubMonitor.convert(progress, workload);
            monitor.setTaskName(ArchiExchange.I18N.getMessage("ui.progress.import.element"));
        }
        ModelElement model = null;
        try (ITransaction tr = this.session.getTransactionSupport().createTransaction("Archi Import")) {
            model = createElement(jaxModel.getIdentifier(), jaxModel);
            if (jaxModel.getElements() != null) {
                for (ElementType jaxElement : jaxModel.getElements().getElement()) {
                    createElement(jaxElement.getIdentifier(), jaxElement);
                }
            }

            if (monitor != null) {
                monitor.worked(1);
                monitor.setTaskName(ArchiExchange.I18N.getMessage("ui.progress.import.relation"));
            }

            if (jaxModel.getRelationships() != null) {
                for (RelationshipType jaxElement : jaxModel.getRelationships().getRelationship()) {
                    createElement(jaxElement.getIdentifier(), jaxElement);
                }
            }

            tr.commit();
        }

        if (monitor != null) {
            monitor.worked(1);
        }

        if (jaxModel.getViews() != null) {
            for (Diagram jaxView : jaxModel.getViews().getDiagrams().getView()) {
                createView(jaxView.getIdentifier(), jaxView, (Model) model, monitor);
            }
        }

        try (ITransaction tr = this.session.getTransactionSupport().createTransaction("Archi Import")) {
            for (OrganizationsType jaxOrg : jaxModel.getOrganizations()) {
                this.elementFactory.createOrganization(jaxOrg, (Model) model);
            }
            tr.commit();
        }

    }

    @objid ("c182cae3-b4b1-4643-a067-665277de7701")
    private ModelElement createElement(String identifier, Object jaxElement) {
        ModelElement element = this.elementFactory.findElement(identifier);
        if (element == null) {
            element = this.elementFactory.createElement(identifier, jaxElement);
        }
        this.elementFactory.updateElement(element, jaxElement);
        return element;
    }

    @objid ("8764e2f3-1d43-4f54-adc0-de9f1599bc77")
    private void createView(String identifier, Diagram jaxView, Model model, SubMonitor monitor) {
        ArchimateView view = null;
        try (ITransaction tr = this.session.getTransactionSupport().createTransaction("Archi Import")) {
            view = (ArchimateView) createElement(jaxView.getIdentifier(), jaxView);

            ViewpointType jaxViewPoint = (ViewpointType)jaxView.getViewpointRef();
            if(jaxViewPoint != null){
                try {
                    view.addStereotype("ArchiMate", jaxViewPoint.getIdentifier());
                } catch (ExtensionNotFoundException e) {
                    // Unknown View Point in Modelio / Nothing to do
                }
            }
            tr.commit();
        }

        final ArchimateView myView = view;

        if (monitor != null) {
            monitor.worked(1);
            monitor.setTaskName(ArchiExchange.I18N.getMessage("ui.progress.import.view", view.getName()));
        }
        Display.getDefault().syncExec(new Runnable() {
            @Override
            public void run() {
                try (ITransaction tr = JAXBWalker.this.session.getTransactionSupport().createTransaction("Archi Import")) {
                    JAXBWalker.this.diagramFactory.createArchimateView(model, myView, jaxView);
                    tr.commit();
                }
            }
        });

    }

}
