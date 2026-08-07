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
package org.modelio.archimate.exchange.v30.exporter;

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
import org.modelio.archimate.exchange.v30.exporter.factory.IDiagramFactoryExport;
import org.modelio.archimate.exchange.v30.exporter.factory.IElementFactoryExport;
import org.modelio.archimate.exchange.v30.xmlmodel.Diagram;
import org.modelio.archimate.exchange.v30.xmlmodel.ModelType;
import org.modelio.archimate.exchange.v30.xmlmodel.ViewpointType;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.core.ViewPointDiagram;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.metamodel.uml.infrastructure.ModelElement;

@objid ("068fbd6c-2412-4306-8d6b-36346e4c286e")
public class ModelioWalker {
    @objid ("7b3b813c-f183-4670-b713-e7c113b157ab")
    private Set<String> exportedViews;

    @objid ("9cbc8953-77b5-4853-b594-09d9a25397f4")
    private IElementFactoryExport elementFactory;

    @objid ("92ecc4da-d806-4c8d-b1ac-c20660906f67")
    private IDiagramFactoryExport diagramFactory;

    @objid ("b3952bb1-3666-4108-a211-802a1ea3747f")
    private Map<String, Object> elementMap;

    @objid ("056b71ae-16fe-4741-a6bc-cf75d320209e")
    public ModelioWalker(IElementFactoryExport elementFactory, IDiagramFactoryExport diagramFactory) {
        this.elementFactory = elementFactory;
        this.diagramFactory = diagramFactory;
        this.exportedViews = new HashSet<>();
        this.elementMap = new HashMap<>();

    }

    @objid ("06456d73-9161-4e05-b5a9-a1da888d5b63")
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
        createElement(null,root);
        ModelType context =   (ModelType) updateElement(null,root);

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

    @objid ("aff32776-1ee5-4647-b9ca-14d91a6504a1")
    private void createRelationship(ModelType context, Concept concept) {
        for (Relationship relationship : concept.getRelatedTo()) {
            createElement(context, relationship);
            createRelationship(context, relationship);
        }

    }

    @objid ("6fd521e6-313a-402a-baba-8ab7b422f34f")
    private List<Folder> getModels(Folder owner) {
        List<Folder> models = new ArrayList<>();
        models.add(owner);
        for (Folder sub : owner.getFolder()) {
            models.addAll(getModels(sub));
        }
        return models;
    }

    @objid ("a470bdf9-5d72-44c7-8c01-e10b5def6cd2")
    private void createViewPoint(ModelType context, ViewPoint viewpoint, SubMonitor monitor) {
        for (AbstractDiagram diagram : viewpoint.getProduct()) {
            if(!(diagram instanceof ViewPointDiagram)) {
                createView(context, diagram, monitor);
            }
        }

        for (ViewPoint child : viewpoint.getChild()) {
            createViewPoint(context, child, monitor);
        }

    }

    @objid ("c5c1901d-0b89-4163-8c63-7103f6157ca6")
    private void createElement(ModelType context, ModelElement element) {
        Object jaxElement = this.elementFactory.createElement(element);
        this.elementMap.put(element.getUuid().toString(), jaxElement);

    }

    @objid ("3590af97-6175-481f-a011-d1fd2a1b7344")
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
                    if(diagram.getExtension().size() > 0){
                        ViewpointType  viewPoint = ModelioWalker.this.diagramFactory.createViewPoint(context,view,diagram);
                        if(viewPoint != null){
                            view.setViewpointRef(viewPoint);
                        }
                    }
                }
            });
        }

    }

    @objid ("38f61662-04be-4f3e-b53a-1a9ee1fa9c23")
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

    @objid ("02c78c83-dffc-4bdf-bf56-d4bccd1ed0ed")
    private void updateRelationship(ModelType context, Concept concept) {
        for (Relationship relationship : concept.getRelatedTo()) {
            updateElement(context, relationship);
            updateRelationship(context, relationship);
        }

    }

    @objid ("bdb2bfcd-e5ce-4c42-b4f3-b411b9869334")
    private Object updateElement(ModelType context, ModelElement element) {
        Object jaxElement = this.elementMap.get(element.getUuid().toString());
        return this.elementFactory.updateElement(context, jaxElement, element);
    }

}
