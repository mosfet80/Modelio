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
package org.modelio.archimate.diagrams.elements.common.utils;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Display;
import org.modelio.api.modelio.model.scope.ElementScope;
import org.modelio.api.module.mda.IMdaExpert;
import org.modelio.archimate.diagrams.elements.common.archielement.typeselection.TypeSelectionModel;
import org.modelio.archimate.diagrams.elements.common.archielement.typeselection.TypeSelectionPopup;
import org.modelio.archimate.metamodel.core.Element;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.mmextensions.archimate.IArchimateModelFactory;
import org.modelio.archimate.metamodel.relationships.structural.StructuralRelationship;
import org.modelio.diagram.elements.core.model.IGmDiagram.IModelManager;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.elements.core.model.IGmLinkable;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.vcore.session.impl.CoreSession;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MExpert;
import org.modelio.vcore.smkernel.mapi.MMetamodel;

@objid ("1b691158-3b7a-4bc2-b57f-538b9edc5151")
public class RelationshipHelper {
    /**
     * Choose and optionally create a {@link StructuralRelationship} between two Archimate elements.
     *
     * @param modelManager tools to create the link.
     * @param from the new relationship's source.
     * @param to the new relationship's target.
     * @return a {@link StructuralRelationship} or <code>null</code>.
     */
    @objid ("2374164e-c244-4395-8417-c67f1097c796")
    @SuppressWarnings ("unchecked")
    public static StructuralRelationship createStructuralRelationship(IModelManager modelManager, Element from, Element to) {
        List<? extends StructuralRelationship> existingStructuralLinks = RelationshipHelper.getStructuralRelationships(modelManager, from, to, StructuralRelationship.class);
        if (existingStructuralLinks.size() == 1) {
            // No need to create a new link, return the first one
            return existingStructuralLinks.get(0);
        }

        ElementScope chosenRelationship = RelationshipHelper.chooseStructuralRelationshipToCreate(modelManager, from, to);
        if (chosenRelationship != null) {
            Class<? extends StructuralRelationship> javaInterface = (Class<? extends StructuralRelationship>) chosenRelationship.getMetaclass().getJavaInterface();
            existingStructuralLinks = RelationshipHelper.getStructuralRelationships(modelManager, from, to, javaInterface);
            if (existingStructuralLinks.size() > 0) {
                // No need to create a new link of the chosen type, return the first one
                return existingStructuralLinks.get(0);
            }

            // Create new link
            IArchimateModelFactory factory = modelManager.getModelFactory().getFactory(IArchimateModelFactory.class);
            StructuralRelationship link = factory.createElement(javaInterface);
            Stereotype stereotype = chosenRelationship.getStereotype();
            if (stereotype != null) {
                link.getExtension().add(stereotype);
            }
            link.setFrom(from);
            link.setTo(to);
            return link;
        }
        return null;
    }

    /**
     * Get the list of all {@link StructuralRelationship} between two Archimate elements.
     *
     * @param modelManager tools to create the link.
     * @param from the relationship's source.
     * @param to the relationship's target.
     * @param filter a metaclass filter for the relationship. Might be <code>null</code>.
     * @return a relationship list.
     */
    @objid ("6cd4a2e4-bea5-40ce-a95a-0ff9faa2c0e1")
    @SuppressWarnings ("unchecked")
    public static <T extends StructuralRelationship> List<T> getStructuralRelationships(IModelManager modelManager, Element from, Element to, Class<T> filter) {
        Class<? extends StructuralRelationship> actualFilter;
        if (filter == null) {
            actualFilter = StructuralRelationship.class;
        } else {
            actualFilter = filter;
        }

        List<T> ret = new ArrayList<>();
        if (!from.equals(to)) {
            for (Relationship link : from.getRelatedTo()) {
                if (actualFilter.isInstance(link) && to.equals(link.getTo())) {
                    ret.add((T) link);
                }
            }
        }
        return ret;
    }

    /**
     * Get the list of all {@link IGmLink} representing a {@link StructuralRelationship} between two GMs.
     *
     * @param fromNode the relationship's source.
     * @param toNode the relationship's target.
     * @return a relationship gm list.
     */
    @objid ("3f613213-cd0c-4932-ac86-76bd1ee3d536")
    public static List<IGmLink> getUnmaskedStructuralRelationships(IGmLinkable fromNode, IGmLinkable toNode) {
        List<IGmLink> ret = new ArrayList<>();
        for (IGmLink link : fromNode.getStartingLinks()) {
            if (link.getRelatedElement() instanceof StructuralRelationship && toNode.getRelatedElement().equals(link.getTo().getRelatedElement())) {
                ret.add(link);
            }
        }
        return ret;
    }

    /**
     * Choose which {@link StructuralRelationship} to create between two Archimate elements.
     *
     * @return a relationship type or <code>null</code> if no link has to be created.
     */
    @objid ("ec7d9085-872f-49f3-ae08-cbabf07b756b")
    private static ElementScope chooseStructuralRelationshipToCreate(IModelManager modelManager, Element from, Element to) {
        List<ElementScope> possibleLinks = RelationshipHelper.computePossibleLinks(modelManager, from, to);
        return RelationshipHelper.chooseRelationship(possibleLinks);
    }

    /**
     * Compute list of possible links between 'from' and 'to'.
     */
    @objid ("feefb038-6fed-488e-8e33-f5fef396b115")
    private static List<ElementScope> computePossibleLinks(IModelManager modelManager, Element from, Element to) {
        List<ElementScope> possibleLinks = new ArrayList<>();

        // Null is always possible
        possibleLinks.add(null);

        if (!from.equals(to)) {
            CoreSession session = CoreSession.getSession(from);

            MMetamodel metamodel = modelManager.getMetamodel();
            MExpert mExpert = metamodel.getMExpert();
            IMdaExpert mdaExpert = modelManager.getMdaExpert();
            for (MClass linkMClass : metamodel.getMClass(StructuralRelationship.class).getSub(true)) {
                if (mExpert.canLink(linkMClass, from, to)) {
                    possibleLinks.add(new ElementScope(linkMClass, false, null, false));
                }

                for (Stereotype ste : session.getModel().findByClass(Stereotype.class)) {
                    MClass steClass = metamodel.getMClass(ste.getBaseClassName());
                    if (steClass != null && linkMClass.hasBase(steClass) && mdaExpert.canLink(ste, linkMClass, from, to)) {
                        possibleLinks.add(new ElementScope(linkMClass, false, ste, false));
                    }
                }
            }
        }
        return possibleLinks;
    }

    /**
     * Choose one element from a list, making the user choose in non-trivial cases.
     */
    @objid ("6195f58a-64bb-4e1b-b368-279bae0904d4")
    private static ElementScope chooseRelationship(List<ElementScope> possibleLinks) {
        ElementScope chosenRelationship;
        if (possibleLinks.isEmpty()) {
            chosenRelationship = null;
        } else if (possibleLinks.size() == 1) {
            // Simplest case, just set the type of link to use.
            chosenRelationship = possibleLinks.get(0);
        } else {
            // Open disambiguation popup.
            TypeSelectionModel model = new TypeSelectionModel(possibleLinks);
            TypeSelectionPopup popup = new TypeSelectionPopup(Display.getDefault().getActiveShell(), model);
            popup.setBlockOnOpen(true);
            if (popup.open() == IDialogConstants.OK_ID) {
                // Set type of link to use then proceed.
                chosenRelationship = model.getSelectedType();
            } else {
                // User cancelled.
                throw new OperationCanceledException();
            }
        }
        return chosenRelationship;
    }

}
