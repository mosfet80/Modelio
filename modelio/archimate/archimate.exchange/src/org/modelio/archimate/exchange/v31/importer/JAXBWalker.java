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
package org.modelio.archimate.exchange.v31.importer;

import java.util.HashMap;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.swt.widgets.Display;
import org.modelio.archimate.exchange.plugin.ArchiExchange;
import org.modelio.archimate.exchange.v31.importer.factory.IDiagramFactoryImport;
import org.modelio.archimate.exchange.v31.importer.factory.IElementFactoryImport;
import org.modelio.archimate.exchange.v31.xmlmodel.Diagram;
import org.modelio.archimate.exchange.v31.xmlmodel.ElementType;
import org.modelio.archimate.exchange.v31.xmlmodel.ModelType;
import org.modelio.archimate.exchange.v31.xmlmodel.OrganizationsType;
import org.modelio.archimate.exchange.v31.xmlmodel.RelationshipType;
import org.modelio.archimate.exchange.v31.xmlmodel.ViewpointType;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.metamodel.mmextensions.infrastructure.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.session.api.transactions.ITransaction;

@objid ("0eac99c4-cf0c-4124-901b-9cfd08e759db")
public class JAXBWalker {
    @objid ("a47ce763-b780-417e-a053-7a73a22157a2")
    private IElementFactoryImport elementFactory;

    @objid ("b7069814-9c96-4638-9e50-7f45b6690c98")
    private IDiagramFactoryImport diagramFactory;

    @objid ("11db9af3-8b58-46fb-9e3c-8c7c75687a0b")
    private ArchimateProject context;

    @objid ("bf04899e-573c-482a-b9b3-e9666c3014a3")
    private ICoreSession session;

    @objid ("f79f6063-3c8b-4312-867f-8691df5b81ff")
    private Map<String, ModelElement> elementMap;

    @objid ("e230c4ae-b9f6-4617-b8dc-00a9c1d36599")
    public JAXBWalker(IElementFactoryImport elementFactory, IDiagramFactoryImport diagramFactory, ArchimateProject context, ICoreSession session) {
        this.elementFactory = elementFactory;
        this.diagramFactory = diagramFactory;
        this.context = context;
        this.session = session;
        this.elementMap = new HashMap<>();

    }

    @objid ("6ad62198-af43-453b-91be-fb5df95a42cd")
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
            model = updateElement(jaxModel.getIdentifier(), jaxModel);

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

            if (jaxModel.getElements() != null) {
                for (ElementType jaxElement : jaxModel.getElements().getElement()) {
                    updateElement(jaxElement.getIdentifier(), jaxElement);
                }
            }

            if (jaxModel.getRelationships() != null) {
                for (RelationshipType jaxElement : jaxModel.getRelationships().getRelationship()) {
                    updateElement(jaxElement.getIdentifier(), jaxElement);
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

    @objid ("d67738c7-1cc7-430f-aca6-5a5d397be800")
    private ModelElement createElement(String identifier, Object jaxElement) {
        ModelElement element = this.elementFactory.findElement(identifier);
        if (element == null) {
            element = this.elementFactory.createElement(identifier, jaxElement);
        }
        this.elementMap.put(identifier,element);
        return element;
    }

    @objid ("9aaeb48d-afe9-4d2a-9e32-3ab39641c724")
    private void createView(String identifier, Diagram jaxView, Model model, SubMonitor monitor) {
        ArchimateView view = null;
        try (ITransaction tr = this.session.getTransactionSupport().createTransaction("Archi Import")) {
            view = (ArchimateView) createElement(jaxView.getIdentifier(), jaxView);
            view = (ArchimateView) updateElement(jaxView.getIdentifier(), jaxView);
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

    @objid ("ed1507cd-c3b4-4660-85f9-990fb7d2ce99")
    private ModelElement updateElement(String identifier, Object jaxElement) {
        ModelElement element = this.elementMap.get(identifier);
        this.elementFactory.updateElement(element, jaxElement);
        return element;
    }

}
