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
package org.modelio.archimate.exchange.v21.exporter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.swt.widgets.Display;
import org.modelio.archimate.exchange.plugin.ArchiExchange;
import org.modelio.archimate.exchange.v21.exporter.factory.IDiagramFactoryExport;
import org.modelio.archimate.exchange.v21.exporter.factory.IElementFactoryExport;
import org.modelio.archimate.exchange.v21.xmlmodel.ModelType;
import org.modelio.archimate.exchange.v21.xmlmodel.ViewType;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.core.ViewPointDiagram;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.metamodel.uml.infrastructure.ModelElement;

@objid ("f90d3e0e-bd57-41c5-887a-c18430c9e43c")
public class ModelioWalker {
    @objid ("6c143f59-ee80-45ef-9030-3b8afa747c53")
    private Set<String> exportedViews;

    @objid ("8c75e54e-0a0f-4142-a8ed-e271b7820c20")
    private IElementFactoryExport elementFactory;

    @objid ("e7016f44-4478-4c0a-96a9-23b3e5060684")
    private IDiagramFactoryExport diagramFactory;

    @objid ("b81ab253-021b-4601-b026-6f7e40439c47")
    public ModelioWalker(IElementFactoryExport elementFactory, IDiagramFactoryExport diagramFactory) {
        this.elementFactory = elementFactory;
        this.diagramFactory = diagramFactory;
        this.exportedViews = new HashSet<>();

    }

    @objid ("92871964-93b7-4fe9-a739-13fef02102cb")
    public ModelType walk(Model root, IProgressMonitor progress) {
        Map<String, Object> refs = new HashMap<>();
        this.elementFactory.setReferenceMap(refs);
        this.diagramFactory.setReferenceMap(refs);

        SubMonitor monitor = null;
        if (progress != null) {
            int workload = 2;
            for (ViewPoint viewpoint : root.getReferencedBy()) {
                workload = workload + countViews(viewpoint);
            }
            this.exportedViews = new HashSet<>();
            monitor = SubMonitor.convert(progress, workload);
            monitor.setTaskName(ArchiExchange.I18N.getMessage("ui.progress.export.element"));
        }

        ModelType context = (ModelType) createElement(null, root);

        for (Folder model : getModels(root)) {
            for (Concept concept : model.getContent()) {
                createElement(context, concept);
            }
        }

        if (monitor != null) {
            monitor.worked(1);
            monitor.setTaskName(ArchiExchange.I18N.getMessage("ui.progress.export.relation"));
        }

        for (Folder model : getModels(root)) {
            for (Concept concept : model.getContent()) {
                for (Relationship relationship : concept.getRelatedTo()) {
                    createElement(context, relationship);
                }
            }
        }

        if (monitor != null) {
            monitor.worked(1);
        }

        for (ViewPoint viewpoint : root.getReferencedBy()) {
            createViewPoint(context, viewpoint,monitor);
        }

        this.elementFactory.createOrganizations(context, root);
        return context;
    }

    @objid ("8dd4e535-0a29-4792-9424-b8a70943fc76")
    private List<Folder> getModels(Folder owner) {
        List<Folder> models = new ArrayList<>();
        models.add(owner);
        for (Folder sub : owner.getFolder()) {
            models.addAll(getModels(sub));
        }
        return models;
    }

    @objid ("852a9409-7554-45f6-89af-732582dd5910")
    private void createViewPoint(ModelType context, ViewPoint viewpoint, SubMonitor monitor) {
        for (AbstractDiagram diagram : viewpoint.getProduct()) {
            if (!(diagram instanceof ViewPointDiagram)) {
                createView(context, diagram,monitor);
            }
        }

        for (ViewPoint child : viewpoint.getChild()) {
            createViewPoint(context, child,monitor);
        }

    }

    @objid ("ddd39875-17ae-4626-81ff-afe3aeeeb686")
    private Object createElement(ModelType context, ModelElement element) {
        Object jaxElement = this.elementFactory.createElement(element);
        return this.elementFactory.updateElement(context, jaxElement, element);
    }

    @objid ("89c42782-f51c-4e8d-be27-6c1d13b910b5")
    private void createView(ModelType context, AbstractDiagram diagram, SubMonitor monitor) {
        if (!this.exportedViews.contains(diagram.getUuid())) {
            if (monitor != null) {
                monitor.worked(1);
                monitor.setTaskName(ArchiExchange.I18N.getMessage("ui.progress.export.view", diagram.getName()));
            }
            Display.getDefault().syncExec(new Runnable() {
                @Override
                public void run() {
                    ModelioWalker.this.exportedViews.add(diagram.getUuid());
                    ViewType view = (ViewType) createElement(context, diagram);
                    ModelioWalker.this.diagramFactory.createArchimateView(view, diagram);
                }
            });
        }

    }

    @objid ("015a6835-df6c-4250-a961-f7b5bc106dc3")
    private int countViews(ViewPoint viewpoint) {
        int val = 0;
        for (AbstractDiagram diagram : viewpoint.getProduct()) {
            if (!this.exportedViews.contains(diagram.getUuid())) {
                val++;
                this.exportedViews.add(diagram.getUuid());
            }
        }
        for (ViewPoint child : viewpoint.getChild()) {
            val = val + countViews(child);
        }
        return val;
    }

}
