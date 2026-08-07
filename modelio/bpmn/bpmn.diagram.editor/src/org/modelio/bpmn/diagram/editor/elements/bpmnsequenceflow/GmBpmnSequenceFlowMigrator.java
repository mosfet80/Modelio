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
package org.modelio.bpmn.diagram.editor.elements.bpmnsequenceflow;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.bpmn.diagram.editor.elements.bpmnlane.v0.GmBpmnLaneV0;
import org.modelio.bpmn.diagram.editor.elements.bpmnmessageflow.GmBpmnMessageFlow;
import org.modelio.bpmn.diagram.editor.elements.bpmnsequenceflow.migration.GmBpmnSequenceFlowV0;
import org.modelio.bpmn.diagram.editor.elements.participant.GmBpmnParticipantPortContainer;
import org.modelio.diagram.elements.core.link.GmLink;
import org.modelio.diagram.elements.core.link.GmPath;
import org.modelio.diagram.elements.core.link.extensions.IGmLocator;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.persistence.PersistenceException;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.metamodel.bpmn.flows.BpmnMessageFlow;
import org.modelio.metamodel.bpmn.flows.BpmnSequenceFlow;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLane;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnParticipant;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * This class manages "major" migrations for {@link GmBpmnSequenceFlow} instances.
 * <p>
 * V0 corresponds to the Modelio 3.6 -> 3.7 changes, some {@link BpmnSequenceFlow} were transmuted to {@link BpmnMessageFlow}.
 * </p>
 */
@objid ("ad39e0e8-7f4b-4685-881b-aee5fb8a6d19")
public class GmBpmnSequenceFlowMigrator implements IPersistentMigrator {
    @objid ("e2883c64-c0d9-4dda-9ebb-f60239e7b57b")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new GmBpmnSequenceFlowV0();
        }
        default: {
            return null;
        }
        }

    }

    @objid ("6468b507-3d63-4df9-b54e-69de0c46f58e")
    @Override
    public IPersistent createInstanceOfMajorVersion(int majorVersionToInstantiate, IDiagramReader in) {
        switch (majorVersionToInstantiate) {
        case 0: {
            MRef relatedRef = (MRef) in.readProperty("relatedRef");
            if (BpmnSequenceFlow.MQNAME.equals(relatedRef.mc) || BpmnSequenceFlow.MNAME.equals(relatedRef.mc)) {
                // Still a sequence flow, instantiate the final Gm directly, no migration needed.
                return new GmBpmnSequenceFlow();
            } else {
                // related element transmuted, instantiate migration Gm
                return new GmBpmnSequenceFlowV0();
            }
        }
        default: {
            return null;
        }
        }

    }

    @objid ("419b810e-00cb-4fac-9693-f56ccf0f6eea")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate instanceof GmBpmnSequenceFlow) {
            // Nothing to do
            return instanceToMigrate;
        }

        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((GmBpmnSequenceFlowV0) instanceToMigrate);
        }

        throw new IllegalStateException(String.format("%s major version %d not supported", instanceToMigrate, instanceToMigrate.getMajorVersion()));

    }

    /**
     * In this migration, we have three cases :
     * <ul>
     * <li>{@link GmBpmnLaneV0} representing a {@link BpmnLane} are handled by {@link #migrateLaneToLane(GmBpmnLaneV0)}</li>
     * <li>{@link GmBpmnLaneV0} representing a {@link BpmnParticipant} or {@link NullPointerException} are handled by {@link #migrateLaneToParticipant(GmBpmnLaneV0)}</li>
     * </ul>
     *
     * @return the migrated gm, replacing the given one.
     * @throws PersistenceException if the lane do not represents a {@link BpmnLane} nor a {@link BpmnParticipant}.
     */
    @objid ("0c5121a8-0fc6-467c-8bf5-580417c5fc38")
    private IPersistent migrateFromV0(GmBpmnSequenceFlowV0 oldGmLink) throws PersistenceException {
        Class<? extends MObject> cls = oldGmLink.getRelatedMClass().getJavaInterface();
        if (BpmnMessageFlow.class.isAssignableFrom(cls)) {
            return migrateToMessageFlow(oldGmLink);
        } else if (BpmnSequenceFlow.class.isAssignableFrom(cls)) {
            return migrateToSequenceFlow(oldGmLink);
        } else {
            // Should never happen, maybe
            throw new PersistenceException("Unable to migrate " + oldGmLink);
        }

    }

    /**
     * Convert a {@link GmBpmnLaneV0} to a {@link GmBpmnParticipantPortContainer}, keeping its layout and contents.
     */
    @objid ("a38d7b7e-0e47-4577-b626-cc059b687416")
    private GmBpmnMessageFlow migrateToMessageFlow(GmBpmnSequenceFlowV0 oldGmLink) {
        IGmDiagram diagram = oldGmLink.getDiagram();

        BpmnMessageFlow participant = (BpmnMessageFlow) oldGmLink.getRepresentedElement();

        GmBpmnMessageFlow newGmLink = new GmBpmnMessageFlow(diagram, participant, oldGmLink.getRepresentedRef());

        // Keep cascaded style
        newGmLink.getPersistedStyle().setCascadedStyle(oldGmLink.getPersistedStyle().getCascadedStyle());

        // Keep local style changes, converting style keys
        for (StyleKey oldKey : oldGmLink.getPersistedStyle().getLocalKeys()) {
            Object oldValue = oldGmLink.getPersistedStyle().getProperty(oldKey);
            MetaKey metakey = oldKey.getMetakey();
            if (metakey == null)
                continue;

            StyleKey newKey = newGmLink.getStyleKey(metakey);
            if (newKey == null)
                continue;

            newGmLink.getPersistedStyle().setProperty(newKey, oldValue);
        }

        moveAll(oldGmLink, newGmLink);


        // Migration is done, delete old gm
        oldGmLink.delete();
        return newGmLink;
    }

    /**
     * Convert a {@link GmBpmnSequenceFlowV0} back to a {@link GmBpmnSequenceFlow}, keeping its layout and contents.
     */
    @objid ("925863f2-47a1-42b6-b469-113adc1c8eab")
    private GmBpmnSequenceFlow migrateToSequenceFlow(GmBpmnSequenceFlowV0 oldGmLink) {
        IGmDiagram diagram = oldGmLink.getDiagram();

        BpmnSequenceFlow participant = (BpmnSequenceFlow) oldGmLink.getRepresentedElement();

        GmBpmnSequenceFlow newGmLink = new GmBpmnSequenceFlow(diagram, participant, oldGmLink.getRepresentedRef());
        newGmLink.setLayoutData(oldGmLink.getLayoutData());

        // Keep cascaded style
        newGmLink.getPersistedStyle().setCascadedStyle(oldGmLink.getPersistedStyle().getCascadedStyle());

        // Keep local style changes, converting style keys
        for (StyleKey oldKey : oldGmLink.getPersistedStyle().getLocalKeys()) {
            Object oldValue = oldGmLink.getPersistedStyle().getProperty(oldKey);
            newGmLink.getPersistedStyle().setProperty(oldKey, oldValue);
        }

        moveAll(oldGmLink, newGmLink);

        // Migration is done, delete old gm
        oldGmLink.delete();
        return newGmLink;
    }

    /**
     * Move all stuff owned by oldGmLink to newGmLink
     *
     * @param oldGmLink the link to empty
     * @param newGmLink the link to fill
     */
    @objid ("7a66f5e5-e2a9-4c9f-a8dd-bb515190a32f")
    private void moveAll(GmLink oldGmLink, GmLink newGmLink) {
        // empty current extensions
        for (GmNodeModel gmExt : new ArrayList<>(newGmLink.getExtensions())) {
            newGmLink.removeExtension(gmExt);
        }

        // Move all extensions from old to new link
        for (GmNodeModel gmExt : new ArrayList<>(oldGmLink.getExtensions())) {
            IGmLocator layoutContraint = oldGmLink.getLayoutContraint(gmExt);
            String roleInComposition = gmExt.getRoleInComposition();
            newGmLink.addExtension(gmExt, roleInComposition, layoutContraint.copy());
        }

        // Plug the new link to matching nodes
        oldGmLink.getFrom().addStartingLink(newGmLink);
        oldGmLink.getTo().addEndingLink(newGmLink);
        newGmLink.setLayoutData(new GmPath(oldGmLink.getPath()));


        // Move links on the old link the the new one
        for (IGmLink otherLink : new ArrayList<>(oldGmLink.getStartingLinks())) {
            oldGmLink.removeStartingLink(otherLink);
            newGmLink.addStartingLink(otherLink);
        }

        for (IGmLink otherLink : new ArrayList<>(oldGmLink.getEndingLinks())) {
            oldGmLink.removeEndingLink(otherLink);
            newGmLink.addEndingLink(otherLink);
        }

    }

}
