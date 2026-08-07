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
package org.modelio.archimate.exchange.v31.exporter;

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
import org.modelio.archimate.exchange.v31.exporter.factory.IDiagramFactoryExport;
import org.modelio.archimate.exchange.v31.exporter.factory.IElementFactoryExport;
import org.modelio.archimate.exchange.v31.xmlmodel.Diagram;
import org.modelio.archimate.exchange.v31.xmlmodel.ModelType;
import org.modelio.archimate.exchange.v31.xmlmodel.ViewpointType;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.core.ViewPointDiagram;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.metamodel.uml.infrastructure.ModelElement;

@objid ("f44421bf-7ff4-4e86-ac6e-bf14886093c2")
public class ModelioWalker {
    @objid ("b698b07c-9a1a-4490-bad8-19a512dc8709")
    private Set<String> exportedViews;

    @objid ("46512d18-b2ec-4605-b3f1-e410b4c01257")
    private IElementFactoryExport elementFactory;

    @objid ("6f436926-363f-4bcd-94d7-0a0cb19ed680")
    private IDiagramFactoryExport diagramFactory;

    @objid ("8b80253c-3821-4781-be64-f552daf136a8")
    private Map<String, Object> elementMap;

    @objid ("3d46d297-36bd-4cfc-b943-8a452fb4c32b")
    public ModelioWalker(IElementFactoryExport elementFactory, IDiagramFactoryExport diagramFactory) {
        this.elementFactory = elementFactory;
        this.diagramFactory = diagramFactory;
        this.exportedViews = new HashSet<>();
        this.elementMap = new HashMap<>();

    }

    @objid ("242961e3-6ef8-4150-9bef-e23850f7824c")
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

        // Create Root
        createElement(null, root);
        ModelType context = (ModelType) updateElement(null, root);

        // Create Model Elements
        for (Folder model : getModels(root)) {
            for (Concept concept : model.getContent()) {
                createElement(context, concept);
                createRelationship(context, concept);
            }
        }

        if (monitor != null) {
            monitor.worked(1);
            monitor.setTaskName(ArchiExchange.I18N.getMessage("ui.progress.export.relation"));
        }

        // Update Elements
        for (Folder model : getModels(root)) {
            for (Concept concept : model.getContent()) {
                updateElement(context, concept);
                updateRelationship(context, concept);
            }
        }

        // Update Relations

        if (monitor != null) {
            monitor.worked(1);
        }

        // Create ViewPoints
        for (ViewPoint viewpoint : root.getReferencedBy()) {
            createViewPoint(context, viewpoint, monitor);
        }

        // Create Organisation
        this.elementFactory.createOrganizations(context, root);
        return context;
    }

    @objid ("4a485ec7-aff7-4915-93e3-b5802ff9bba7")
    private void createRelationship(ModelType context, Concept concept) {
        for (Relationship relationship : concept.getRelatedTo()) {
            createElement(context, relationship);
            createRelationship(context, relationship);

        }

    }

    @objid ("45cb90f3-0b52-4b92-ad9d-e6cb0f7367af")
    private List<Folder> getModels(Folder owner) {
        List<Folder> models = new ArrayList<>();
        models.add(owner);
        for (Folder sub : owner.getFolder()) {
            models.addAll(getModels(sub));
        }
        return models;
    }

    @objid ("aff3a601-d1f5-4a91-8097-e7af92849bd4")
    private void createViewPoint(ModelType context, ViewPoint viewpoint, SubMonitor monitor) {
        for (AbstractDiagram diagram : viewpoint.getProduct()) {
            if (!(diagram instanceof ViewPointDiagram)) {
                createView(context, diagram, monitor);
            }
        }

        for (ViewPoint child : viewpoint.getChild()) {
            createViewPoint(context, child, monitor);
        }

    }

    @objid ("cd09fb5e-6ab6-45d1-8571-31a7c6e463ef")
    private void createElement(ModelType context, ModelElement element) {
        Object jaxElement = this.elementFactory.createElement(element);
        this.elementMap.put(element.getUuid().toString(), jaxElement);

    }

    @objid ("c806d312-de60-43f0-9f20-e32001550d38")
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
                    createElement(context, diagram);
                    Diagram view = (Diagram) updateElement(context, diagram);
                    ModelioWalker.this.diagramFactory.createArchimateView(view, diagram);
                    if (diagram.getExtension().size() > 0) {
                        ViewpointType viewPoint = ModelioWalker.this.diagramFactory.createViewPoint(context, view, diagram);
                        if (viewPoint != null) {
                            view.setViewpointRef(viewPoint);
                        }
                    }
                }
            });
        }

    }

    @objid ("caa7e2e0-9399-42db-af59-8b8cf9800d0c")
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

    @objid ("220e614d-0818-4ae8-954e-df0c8080b477")
    private void updateRelationship(ModelType context, Concept concept) {
        for (Relationship relationship : concept.getRelatedTo()) {
            updateElement(context, relationship);
            updateRelationship(context, relationship);
        }

    }

    @objid ("5229ec52-abee-4125-8865-35ee6c932bbb")
    private Object updateElement(ModelType context, ModelElement element) {
        Object jaxElement = this.elementMap.get(element.getUuid().toString());
        return this.elementFactory.updateElement(context, jaxElement, element);
    }

}
