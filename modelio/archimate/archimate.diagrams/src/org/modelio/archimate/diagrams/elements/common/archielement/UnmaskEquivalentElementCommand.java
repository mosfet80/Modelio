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
package org.modelio.archimate.diagrams.elements.common.archielement;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.layers.motivation.Goal;
import org.modelio.archimate.metamodel.layers.motivation.Meaning;
import org.modelio.archimate.metamodel.layers.motivation.Requirement;
import org.modelio.archimate.metamodel.mmextensions.archimate.ArchimateLayerExpert;
import org.modelio.archimate.metamodel.mmextensions.archimate.IArchimateModelFactory;
import org.modelio.diagram.elements.core.commands.ModelioCreationContext;
import org.modelio.diagram.elements.core.model.GmModel;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Create an ArchiMate element with an equivalence to the unmasked element, and then unmask it in the diagram in its place.
 */
@objid ("b59a0864-fd58-4ca1-99d0-85d3dcc5bc7c")
public class UnmaskEquivalentElementCommand extends Command {
    @objid ("95c5ed4d-7d64-4e65-8a0a-9976d52eb5b6")
    private MObject unmaskedElement;

    @objid ("17509321-257d-4b06-a8a2-92849db97e6b")
    private Model parentModel;

    @objid ("b79d5da3-df99-4edc-840e-133149cb39d6")
    private EditPart editPart;

    @objid ("28219101-5a2c-43b0-a3db-121218dddeb5")
    private Point dropLocation;

    /**
     * Initialize the command.
     *
     * @param dropLocation The location of the element in the diagram
     * @param unmaskedElement The element being unmasked.
     * @param editPart The destination edit part that will own the call operation.
     * @param parentModel The archimate model that will own the created element.
     */
    @objid ("a68e2ac2-5f7a-456f-a605-331ee9dc640f")
    public UnmaskEquivalentElementCommand(Point dropLocation, MObject unmaskedElement, EditPart editPart, Model parentModel) {
        this.unmaskedElement = unmaskedElement;
        this.dropLocation = dropLocation;
        this.editPart = editPart;
        this.parentModel = parentModel;

    }

    @objid ("95bbb334-d927-49eb-8187-5790e11b7fec")
    @Override
    public void execute() {
        final GmModel gmModel = (GmModel) this.editPart.getModel();
        final IGmDiagram gmDiagram = gmModel.getDiagram();
        IArchimateModelFactory modelFactory = gmDiagram.getModelManager().getModelFactory().getFactory(IArchimateModelFactory.class);

        // Create the smart node
        final Concept newElement;
        if (this.unmaskedElement.getMClass().getQualifiedName().equals("Analyst.Goal")) {
            Goal goal = modelFactory.createGoal();
            goal.setName(this.unmaskedElement.getName());
            goal.setEquivalentRef(new MRef(this.unmaskedElement).toString());

            newElement = goal;
        } else if (this.unmaskedElement.getMClass().getQualifiedName().equals("Analyst.Requirement")) {
            Requirement requirement = modelFactory.createRequirement();
            requirement.setName(this.unmaskedElement.getName());
            requirement.setEquivalentRef(new MRef(this.unmaskedElement).toString());

            newElement = requirement;
        } else if (this.unmaskedElement.getMClass().getQualifiedName().equals("Analyst.Term")) {
            Meaning meaning = modelFactory.createMeaning();
            meaning.setName(this.unmaskedElement.getName());
            meaning.setEquivalentRef(new MRef(this.unmaskedElement).toString());

            newElement = meaning;
        } else {
            // Should never happen, do nothing
            return;
        }

        // Get appropriate layer
        Folder parentLayer = ArchimateLayerExpert.getLayerContainer(this.parentModel, newElement.getMClass());

        // Attach to parent
        newElement.setOwnerFolder(parentLayer);

        unmaskElement(newElement);

    }

    /**
     * Unmask the given element in the destination edit part.
     *
     * @param el The element to unmask
     */
    @objid ("c245fe35-fb81-483a-8daa-ab516b951533")
    private void unmaskElement(MObject el) {
        final ModelioCreationContext gmCreationContext = new ModelioCreationContext(el);

        final CreateRequest creationRequest = new CreateRequest();
        creationRequest.setLocation(this.dropLocation);
        creationRequest.setSize(new Dimension(-1, -1));
        creationRequest.setFactory(gmCreationContext);

        final Command cmd = this.editPart.getTargetEditPart(creationRequest).getCommand(creationRequest);
        if (cmd != null && cmd.canExecute()) {
            cmd.execute();
        }

    }

    @objid ("6b4adbec-c7de-4737-9eaa-df12ad152c84")
    @Override
    public boolean canExecute() {
        return this.parentModel != null && this.parentModel.isValid()
                        && this.unmaskedElement.getMClass().getOrigin().getName().equals("Analyst")
                        && (this.unmaskedElement.getMClass().getQualifiedName().equals("Analyst.Goal")
                                || this.unmaskedElement.getMClass().getQualifiedName().equals("Analyst.Requirement")
                                || this.unmaskedElement.getMClass().getQualifiedName().equals("Analyst.Term"));

    }

}
