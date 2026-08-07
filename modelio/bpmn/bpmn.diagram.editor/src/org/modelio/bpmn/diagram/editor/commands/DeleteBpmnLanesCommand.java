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
package org.modelio.bpmn.diagram.editor.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.UpdateManager;
import org.eclipse.draw2d.geometry.PrecisionDimension;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.modelio.bpmn.diagram.editor.elements.bpmnlane.GmBpmnLane;
import org.modelio.bpmn.diagram.editor.elements.bpmnlane.hibridcontainer.GmBodyHybridContainer;
import org.modelio.bpmn.diagram.editor.elements.bpmnlanesetcontainer.GmBpmnLaneSetContainer;
import org.modelio.bpmn.diagram.editor.elements.workflow.GmWorkflow;
import org.modelio.diagram.elements.core.node.GmCompositeNode;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLane;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLaneSet;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Command that deletes BPMN lanes and move their content in the best place.
 * <p>
 * - If the lane has a parent lane, move the content to the parent lane.<br>
 * - If the lane has no parent lane but has a sibling lane, move the content to
 * the first sibling lane.<br>
 * - If the lane has no parent lane and no sibling lane, move the content to
 * the diagram.
 * </p>
 */
@objid ("8971228c-73b4-4460-b6d1-76a92f32164a")
public class DeleteBpmnLanesCommand extends Command {
    /**
     * Map of graphic nodes to reparent with their initial absolute bounds.
     */
    @objid ("46d518cb-1755-49d2-afe3-32d4f9083c76")
    private final Map<GmNodeModel, PrecisionRectangle> oldBounds;

    @objid ("5fef89ec-9f1b-4209-a397-b3d06a658c66")
    private final Set<GmBpmnLane> gmLanesToDelete;

    /**
     * Cached edit part registry.
     */
    @objid ("384a7995-2027-4556-938e-2272570ccbfd")
    private Map<Object, EditPart> epRegistry;

    @objid ("7ced052c-e009-4cc3-89e8-74478a296819")
    private UpdateManager figUpdateManager;

    @objid ("781065c3-f4e8-4688-95ae-fe4ade15b144")
    public DeleteBpmnLanesCommand() {
        this.oldBounds = new java.util.HashMap<>();
        this.gmLanesToDelete = new java.util.HashSet<>();
    }

    @objid ("deee05ae-877c-46c5-b04d-94a2dee210b1")
    public boolean isEmpty() {
        return this.gmLanesToDelete.isEmpty();
    }

    /**
     * Add a lane to delete.
     *
     * @param laneEditPart the edit part of the lane to delete.
     */
    @objid ("fb08c4ec-f1ad-4738-8f92-3d062ff92530")
    public void addLane(GraphicalEditPart laneEditPart) {
        GmBpmnLane laneModel = (GmBpmnLane) laneEditPart.getModel();

        if (this.epRegistry == null) {
            this.epRegistry = laneEditPart.getViewer().getEditPartRegistry();
            this.figUpdateManager = laneEditPart.getFigure().getUpdateManager();
        }

        // Record the lane to delete
        this.gmLanesToDelete.add(laneModel);

        recordLaneNodesOldBounds(laneModel);

        // Also record the absolute position of all nodes in the following lanes
        GmBpmnLaneSetContainer gmLaneSet = (GmBpmnLaneSetContainer) laneModel.getParent();
        if (gmLaneSet != null) {
            List<GmNodeModel> siblings = gmLaneSet.getChildren();
            List<GmNodeModel> nextSiblings = siblings.subList(siblings.indexOf(laneModel)+1, siblings.size());
            if (! nextSiblings.isEmpty()) {
                for (GmNodeModel aSibling : nextSiblings) {
                    recordLaneNodesOldBounds((GmBpmnLane) aSibling);
                }
            }
        }
    }

    @objid ("28e60ac1-3186-4572-8d67-30e8a031a327")
    private void recordLaneNodesOldBounds(GmBpmnLane gmLane) {
        List<GmNodeModel> content = gmLane.getBody().getChildren();
        for (GmNodeModel gmChild : content) {
             if (gmChild instanceof GmBpmnLaneSetContainer container) {
                 // Sub lanes, recurse
                 for (GmNodeModel subChild : container.getChildren()) {
                     if (subChild instanceof GmBpmnLane) {
                         recordLaneNodesOldBounds((GmBpmnLane) subChild);
                     }
                 }
             } else {
                 // Regular node, record its bounds
                 recordOldBounds(gmChild);
             }
        }
    }

    @objid ("8114641d-470c-4db1-9d08-aee0ba33a05f")
    private void recordOldBounds(GmNodeModel n) {
        GraphicalEditPart nodeEditPart = (GraphicalEditPart) this.epRegistry.get(n);
        if (nodeEditPart != null) {
            IFigure figure = nodeEditPart.getFigure();
            PrecisionRectangle absBounds = new PrecisionRectangle(figure.getBounds());
            figure.translateToAbsolute(absBounds);
            this.oldBounds.put(n, absBounds);
        }
    }

    /**
     * Move all content of the lane to delete to their new parent.
     * <p>
     * Updates the model then the graphic model.
     *
     * @param gmLaneToDelete the lane to delete
     */
    @objid ("57fcc379-90c3-4f9c-99c3-4f0446e4e3e6")
    private void moveLaneContent(GmBpmnLane gmLaneToDelete) {
        BpmnLane oldLaneEl = (BpmnLane) gmLaneToDelete.getRelatedElement();

        LaneTarget newParentForSubLanes = getNewParentforSubLanes(gmLaneToDelete);
        BpmnLaneSet targetLaneSetEl = newParentForSubLanes.target().getRepresentedElement();

        GmCompositeNode newParentForNodes = getNewParentForNodes(gmLaneToDelete);
        BpmnLane newLaneEl = null;
        if (newParentForNodes == null) {
            GmCompositeNode diagramAsNode = (GmCompositeNode) gmLaneToDelete.getDiagram();
            newParentForNodes =  diagramAsNode;
        } else {
            if (newParentForNodes.getRelatedElement() instanceof BpmnLane lane) {
                newLaneEl = lane;
            }
        }

        // Process all children of this lane
        GmBodyHybridContainer gmBody = gmLaneToDelete.getBody();
        for (GmNodeModel child : gmBody.getChildren()) {
            gmBody.removeChild(child);

            if (child instanceof GmBpmnLaneSetContainer) {
                // Handle sub-lanes
                GmBpmnLaneSetContainer laneSetContainer = (GmBpmnLaneSetContainer) child;

                // Get all sub-lanes, reverse the order to keep the same order when re-adding them
                List<GmBpmnLane> laneSetChildren = laneSetContainer.getLanes();
                Collections.reverse(laneSetChildren);

                for (GmBpmnLane gmSubLane : laneSetChildren) {
                    laneSetContainer.removeChild(gmSubLane);

                    // First updates the model represented by the graphic model now that we know the new parent
                    BpmnLane movedLaneEl = (BpmnLane) gmSubLane.getRelatedElement();

                    targetLaneSetEl.getLane().add(movedLaneEl);

                    // Now move the graphic model
                    newParentForSubLanes.target.addChild(gmSubLane, newParentForSubLanes.index);
                }
            } else {
                // Handle regular nodes (flow elements)

                // First update the model : Move flow elements to the new lane if any
                if (newLaneEl != null) {
                    newLaneEl.getFlowElementRef().addAll(oldLaneEl .getFlowElementRef());
                }

                // Now move the graphic model
                newParentForNodes.addChild(child);
            }
        }
    }

    /**
     * Returns a new parent for child nodes of this lane.
     * <p>
     * The new parent is :
     * <li>the previous child in the lane set,
     * <li>or the next child if gmLaneToDelete is the first child
     * <li>or the last leaf in first parent that is not deleted.
     * <p>
     * If no such parent exists, returns null.
     *
     * @return the new parent of this lane.
     */
    @objid ("80efa0d2-b73f-4365-9bc2-ea0ce456076b")
    private GmBodyHybridContainer getNewParentForNodes(GmBpmnLane gmLaneToDelete) {
        // Composition graph of a diagram with lanes is:
        // GmDiagram :
        //  \- GmBpmnLaneSetContainer (for top-level lanes)
        //      \- GmBpmnLane (top-level lane)
        //          \- GmBodyHybridContainer
        //              \- GmBpmnLaneSetContainer (for sub-lanes)
        //                  \- GmBpmnLane (sub-lane)
        //                  \- GmBpmnLane (sub-lane)
        //                      \- GmBodyHybridContainer
        //                           \- GmNodeModel (inner nodes)

        GmBpmnLane currentLane = gmLaneToDelete;

        for (int i=0; currentLane != null && i< 100; i++) { // Avoid infinite loops

            GmNodeModel lane = getPreviousSibling(currentLane);
            if (lane != null) {
                GmBpmnLane gmSiblingLane = (GmBpmnLane) lane;

                // Return the last leaf of this sibling lane
                return getLastLeafLane(gmSiblingLane).getBody();
            }
            currentLane =  currentLane.getParentLane();
            if (i==100)
                throw new IllegalStateException("Infinite loop detected in composition graph of "+ gmLaneToDelete);
        }

        return null;
    }

    /**
     * Returns the last leaf lane in the hierarchy of lanes under the given lane.
     * <p>
     * If the given lane has no sub-lanes, returns itself.
     *
     * @param gmLane the lane to inspect
     * @return the last leaf lane in the hierarchy of lanes under the given lane. If the given lane has no sub-lanes, returns itself.
     */
    @objid ("4abf0563-9d3e-4a76-8e84-4429b2b5d934")
    private static GmBpmnLane getLastLeafLane(GmBpmnLane gmLane) {
        GmBodyHybridContainer body = gmLane.getBody();

        // Look for a lane set container in the body's children
        GmBpmnLaneSetContainer subLaneSetContainer = null;
        for (GmNodeModel child : body.getChildren()) {
            if (child instanceof GmBpmnLaneSetContainer) {
                subLaneSetContainer = (GmBpmnLaneSetContainer) child;
                break;
            }
        }

        // If no sub-lanes exist, this lane is a leaf
        if (subLaneSetContainer == null) {
            return gmLane;
        }

        List<GmBpmnLane> subLanes = subLaneSetContainer.getLanes();
        if (subLanes.isEmpty())
            return gmLane;

        // Get the last lane from the sub-lanes
        GmBpmnLane lastSubLane = subLanes.get(subLanes.size() - 1);
        if (lastSubLane != null) {
            // Recurse into the last sub-lane to find the deepest leaf
            return getLastLeafLane(lastSubLane);
        }

        // Fallback: return the original lane if no valid sub-lane was found
        return gmLane;
    }

    /**
     * Gets the index of a lane within its parent lane set container.
     *
     * @param gmLane the lane to find the index for
     * @return the index of the lane in its parent, or -1 if not found
     */
    @objid ("83b1d2ce-803e-45ed-8c8c-4f97f0174605")
    private static int getIndexOfChildInParent(GmBpmnLane gmLane) {
        GmCompositeNode parent = gmLane.getParentNode();
        List<GmNodeModel> siblings = parent.getChildren();
        return siblings.indexOf(gmLane);
    }

    @objid ("106ca0b2-0ed6-4f64-87cc-c8d9f262567c")
    private static GmNodeModel getPreviousSibling(GmNodeModel child) {
        GmCompositeNode parent = child.getParentNode();
        List<GmNodeModel> siblings = parent.getChildren();
        int index = siblings.indexOf(child);

        // If the child was already the first, return the next instead.
        if (index == 0)
            if (siblings.size() > 1)
                return siblings.get(1);
            else
                return null;

        if (index > 0)
            return siblings.get(index - 1);
        else
            return null;
    }

    @objid ("24b02cd2-ee03-4d1e-b51a-a803ddc5a0be")
    private LaneTarget getNewParentforSubLanes(GmBpmnLane gmLaneToDelete) {
        GmBpmnLane currentChildLane = gmLaneToDelete;
        GmCompositeNode parent = gmLaneToDelete.getParentNode();
        for (int i=0; parent != null && i< 100; i++) { // Avoid infinite loops

            // If the parent is a lane set, return the first lane that is not deleted.
            if (parent instanceof GmBpmnLaneSetContainer container) {
                GmBpmnLane parentLane = container.getParentLane();
                if (parentLane != null) {
                    MObject relatedElement = parentLane.getRelatedElement();
                    if (relatedElement != null && !relatedElement.isDeleted() && !this.gmLanesToDelete.contains(parentLane))
                        return new LaneTarget(container, getIndexOfChildInParent(currentChildLane) );
                } else if (container.getParentNode() instanceof GmWorkflow) {
                    // The parent is the diagram, return the top-level lane set container
                    return new LaneTarget(container, getIndexOfChildInParent(currentChildLane) );
                }

                if (i==100)
                    throw new IllegalStateException("Infinite loop detected in composition graph of "+ gmLaneToDelete);

                currentChildLane = parentLane;
            }

            parent = parent.getParentNode(); // Go to parent level
        }

        return null;
    }

    @objid ("c33a21ab-e84e-46c0-895c-6d50a919c8a9")
    @Override
    public void execute() {
        // The proposed strategy is:
        // - delete all BpmnLane model elements
        // - delete all empty BpmnLaneSet model elements
        // - for each lane to delete, find the new parent lane for its content (if any)
        //   The best parent might be different depending on the lane contains nodes or lanes.
        // - reparent all GmNodes directly contained in the GmBodyHybridContainer of the lanes to delete to the a new parent lane GmBodyHybridContainer or to the diagram
        // - delete the GmBpmnLane graphic model. Call GmBpmnLane.delete()
        // - restore the absolute bounds of all reparented nodes by creating and executing ChangeBoundsRequest on their edit parts.

        // First, ensure no lane set remains with a single lane by adding such lanes to the deletion list.
        //addSingleLanesToDelete();


        // Delete all graphic lane models
        for (GmBpmnLane gmLane : this.gmLanesToDelete) {
            if (gmLane.isValid()) {
                GmBpmnLaneSetContainer parentGmLaneSet = (GmBpmnLaneSetContainer) gmLane.getParentNode();

                // Move the content of the lane to delete to their new parent
                moveLaneContent(gmLane);

                // Delete the lane model
                deleteLane((BpmnLane) gmLane.getRepresentedElement());

                // Delete the graphic model of the lane
                gmLane.delete();

                // Delete old parents if they are now empty
                // This allows GmBodyHybridContainer to switch to free zone mode.
                if (parentGmLaneSet != null && parentGmLaneSet.getChildren().isEmpty()) {
                    parentGmLaneSet.delete();
                }
            }
        }

        // Force a validation to update children figures bounds
        this.figUpdateManager.performValidation();

        // Then restore absolute bounds by creating and executing requests
        for (Entry<GmNodeModel, PrecisionRectangle> entry : this.oldBounds.entrySet()) {
            GmNodeModel oldGmModel = entry.getKey();
            if (!oldGmModel.isValid()) {
                // The model has been deleted, skip it.
                continue;
            }

            PrecisionRectangle neededBounds = entry.getValue();

            // oldEditPart has been dropped and replaced by another when moving the gm node. Find the new edit part.
            GraphicalEditPart newEditPart = (GraphicalEditPart) this.epRegistry.get(oldGmModel);
            if (newEditPart != null) {
                ChangeBoundsRequest req = buildChangeBoundsRequest(neededBounds, newEditPart);

                if (!req.getMoveDelta().equals(0,0) || !req.getSizeDelta().equals(0,0)) {
                    Command moveCmd = newEditPart.getCommand(req);
                    if (moveCmd != null && moveCmd.canExecute()) {
                        moveCmd.execute();
                    }
                }
            }
        }
    }

    @objid ("da3a1d8a-62b5-4995-9c9d-1ae2c18d6e9b")
    private void deleteLane(BpmnLane lane) {
        if (lane.isValid()) {
            BpmnLaneSet container = lane.getLaneSet();
            lane.delete();
            // Delete parents BpmnLaneSet if they are now empty
            if (container != null && container.getLane().isEmpty() && container.isValid()) {
                // Delete empty lane sets
                container.delete();
            }
        }
    }

    /**
     * Inspect all lanes to delete and add their sibling lane if it is the only remaining after all deletions.
     * <p>
     * This ensures that no lane set remains with a single lane, which would look odd.
     * <p>
     * This method iterates until no more single lane is found, to handle cases
     * where deleting a lane creates a single lane set, which when deleted creates another single lane
     * set, etc.
     */
    @objid ("51b770ad-0b56-4ab5-b7e0-de036eb7286b")
    private void addSingleLanesToDelete() {
        boolean found = true;
        // Iterate until no more single lane is found , with infinite loop guard rail.
        for (int i = this.gmLanesToDelete.size() * 2; found && i > 0; i--) {
            found = false;
            // Inspect all lanes to delete
            for (GmBpmnLane gmLaneToDelete : new ArrayList<>(this.gmLanesToDelete)) {
                GmCompositeNode parent = gmLaneToDelete.getParentNode();
                if (parent instanceof GmBpmnLaneSetContainer) {
                    // Check if this lane has a single sibling that is not deleted
                    List<GmNodeModel> remainingSiblings = new ArrayList<>(parent.getChildren());
                    remainingSiblings.removeAll(this.gmLanesToDelete);
                    if (remainingSiblings.size() == 1) {
                        // Found a single remaining sibling, add it to the lanes to delete
                        GmNodeModel onlyRemaining = remainingSiblings.get(0);
                        if (onlyRemaining instanceof GmBpmnLane) {
                            GraphicalEditPart laneEditPart = (GraphicalEditPart) this.epRegistry.get(onlyRemaining);
                            if (laneEditPart != null) {
                                addLane(laneEditPart);
                                found = true;
                            }
                        }
                    }
                }
            }
        }
    }

    @objid ("e1291313-a146-4431-acd2-9f0874e3022a")
    private ChangeBoundsRequest buildChangeBoundsRequest(PrecisionRectangle neededBounds, GraphicalEditPart newEditPart) {
        IFigure fig = newEditPart.getFigure();

        ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
        req.setEditParts(newEditPart);
        req.setLocation(neededBounds.getLocation());

        Rectangle curAbsBounds = new PrecisionRectangle(fig.getBounds());
        fig.translateToAbsolute(curAbsBounds);

        // Set the deltas to move and resize the figure.
        // The deltas are in PrecisionPoint and PrecisionDimension to avoid precision losses
        // when transforming from absolute to relative coordinates back and forth.
        req.setMoveDelta(neededBounds.getTopLeft().translate(-curAbsBounds.preciseX(), -curAbsBounds.preciseY()));
        req.setSizeDelta(new PrecisionDimension(
                neededBounds.preciseWidth() - curAbsBounds.preciseWidth(),
                neededBounds.preciseHeight() - curAbsBounds.preciseHeight()));
        return req;
    }

    @objid ("fa6f920c-6c85-492b-8416-f994a5f868b3")
    private record LaneTarget ( GmBpmnLaneSetContainer target,
            int index )  {
    }

}
