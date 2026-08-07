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
package org.modelio.archimate.exchange.v21.importer;

import java.util.HashMap;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.swt.widgets.Display;
import org.modelio.archimate.exchange.plugin.ArchiExchange;
import org.modelio.archimate.exchange.v21.importer.factory.IDiagramFactoryImport;
import org.modelio.archimate.exchange.v21.importer.factory.IElementFactoryImport;
import org.modelio.archimate.exchange.v21.xmlmodel.ElementType;
import org.modelio.archimate.exchange.v21.xmlmodel.ModelType;
import org.modelio.archimate.exchange.v21.xmlmodel.OrganizationType;
import org.modelio.archimate.exchange.v21.xmlmodel.RelationshipType;
import org.modelio.archimate.exchange.v21.xmlmodel.ViewType;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.session.api.transactions.ITransaction;

@objid ("aec9c647-282f-48f9-b611-900dcc566bdb")
public class JAXBWalker {
    @objid ("504a1c94-93fc-4adc-8093-7df585444da0")
    private IElementFactoryImport elementFactory;

    @objid ("0ef9f60d-00b2-4d66-9f23-ff639d84693e")
    private IDiagramFactoryImport diagramFactory;

    @objid ("9b2d5e87-415c-40dd-ad8b-d244b7555317")
    private ArchimateProject context;

    @objid ("6d6c046b-952b-422b-807e-39cab98a83d9")
    private ICoreSession session;

    @objid ("caae90ed-8acd-413f-a002-328419612de1")
    public JAXBWalker(IElementFactoryImport elementFactory, IDiagramFactoryImport diagramFactory, ArchimateProject context, ICoreSession session) {
        this.elementFactory = elementFactory;
        this.diagramFactory = diagramFactory;
        this.context = context;
        this.session = session;

    }

    @objid ("72f82470-f337-4acf-9966-97a4d0f819c2")
    public void walk(ModelType jaxModel, IProgressMonitor progress) {
        Map<String, ModelElement> refs = new HashMap<>();
        this.elementFactory.setReferenceMap(refs);
        this.diagramFactory.setReferenceMap(refs);

        SubMonitor monitor = null;
        if (progress != null) {
            int workload = 2;
            if (jaxModel.getViews() != null) {
                workload = workload + jaxModel.getViews().getView().size();
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
            for (ViewType jaxView : jaxModel.getViews().getView()) {
                createView(jaxView.getIdentifier(), jaxView, (Model) model, monitor);
            }
        }

        try (ITransaction tr = this.session.getTransactionSupport().createTransaction("Archi Import")) {
            for (OrganizationType jaxOrg : jaxModel.getOrganization()) {
                this.elementFactory.createOrganization(jaxOrg, (Model) model);
            }
            tr.commit();
        }

    }

    @objid ("73edc6ef-c643-4f7d-9fb2-e846bbb647ac")
    private ModelElement createElement(String identifier, Object jaxElement) {
        ModelElement element = this.elementFactory.findElement(identifier);
        if (element == null || !(element instanceof Concept)) {
            element = this.elementFactory.createElement(identifier, jaxElement);
        }

        this.elementFactory.updateElement(element, jaxElement);
        return element;
    }

    @objid ("693179f4-f360-42ec-8fb4-069e59d04bd5")
    private void createView(String identifier, ViewType jaxView, Model model, SubMonitor monitor) {
        ArchimateView view = null;
        try (ITransaction tr = this.session.getTransactionSupport().createTransaction("Archi Import")) {
            view = (ArchimateView) createElement(jaxView.getIdentifier(), jaxView);
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
