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
package org.modelio.bpmn.diagram.editor.elements.bpmnsequenceflow.migration;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.bpmn.diagram.editor.elements.bpmndataobject.dataobject.GmBpmnDataObject;
import org.modelio.bpmn.diagram.editor.elements.bpmnsequenceflow.GmBpmnEdgeGuard;
import org.modelio.bpmn.diagram.editor.elements.bpmnsequenceflow.GmBpmnSequenceFlow;
import org.modelio.bpmn.diagram.editor.elements.bpmnsequenceflow.GmBpmnSequenceFlowStyleKeys;
import org.modelio.diagram.elements.common.label.modelelement.GmDefaultModelElementLabel;
import org.modelio.diagram.elements.core.link.ExtensionLocation;
import org.modelio.diagram.elements.core.link.GmLink;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.metamodel.bpmn.flows.BpmnSequenceFlow;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Migration graphic model for {@link BpmnSequenceFlow} V0.
 * <p>
 *
 * @since 5.4.1 - 28/11/2023
 */
@objid ("2eeec9f3-5e4f-481b-ab32-36ab2d26e94b")
public class GmBpmnSequenceFlowV0 extends GmLink {
    /**
     * Current version of this Gm class. Defaults to 0.
     */
    @objid ("c8d06b85-2531-456b-84cd-f398598fe981")
    private static final int MINOR_VERSION = 0;

    @objid ("5b441722-f281-4be1-84cc-9974e75247c4")
    private static final int MAJOR_VERSION = 0;

    @objid ("d3aed197-44c2-41e1-b3c0-007c6a7590f8")
    public static final String ROLE_GUARD = "guard";

    @objid ("3fce9ebc-5518-436a-bff1-2fd1e441b5c9")
    public static final String ROLE_DATAOBJECT = "dataobject";

    @objid ("ae2633b6-f672-40b1-a2f7-d2cc578e1afc")
    private MObject element;

    @objid ("075d4be0-bc38-4459-b20b-d0fa0a926826")
    private static final GmBpmnSequenceFlowStyleKeys styleKeyProvider = new GmBpmnSequenceFlowStyleKeys();

    /**
     * Initialize a control flow graphic model.
     *
     * @param diagram The owning diagram
     * @param element The reference flow, may be null
     * @param ref The referenced flow reference, may not be null
     */
    @objid ("fe6ff5ab-bd94-4835-af4a-ea690456719b")
    public GmBpmnSequenceFlowV0(IGmDiagram diagram, BpmnSequenceFlow element, MRef ref) {
        super(diagram, ref);

        this.element = element;

        GmDefaultModelElementLabel extension = new GmDefaultModelElementLabel(diagram, ref);
        extension.setShowLabel(false);
        addExtension(ExtensionLocation.MiddleNW, IGmLink.ROLE_MAIN_LABEL, extension);
        addExtension(ExtensionLocation.SourceNW, GmBpmnSequenceFlowV0.ROLE_GUARD, new GmBpmnEdgeGuard(diagram, ref));

    }

    /**
     * For deserialization only.
     */
    @objid ("b6d97c3d-8ec9-4a9e-b79a-8739599a8bfa")
    public GmBpmnSequenceFlowV0() {
        // Nothing to do.
    }

    @objid ("2cccede3-eb38-4163-988d-18195a82a0b1")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        return GmBpmnSequenceFlowV0.styleKeyProvider.getStyleKey(metakey);
    }

    @objid ("d5a47556-25ca-458b-a4f5-d1da7cf83ab5")
    @Override
    public List<StyleKey> getStyleKeys() {
        return GmBpmnSequenceFlowV0.styleKeyProvider.getStyleKeys();
    }

    @objid ("cbebf6c4-1614-4853-81d1-02c4829a5691")
    @Override
    public MObject getFromElement() {
        return null;
    }

    @objid ("5fc18571-a8ac-4c8f-a5cb-c28eb5deb967")
    @Override
    public MObject getToElement() {
        return null;
    }

    @objid ("350d12c1-5de0-4490-a87c-fb1d549da02a")
    @Override
    public MObject getRepresentedElement() {
        return this.element;
    }

    @objid ("a5f703c6-6f08-4f6b-9fbb-8e65bcb73a2f")
    @Override
    public void readLink(IDiagramReader in) {
        super.readLink(in);
        this.element =  resolveRef(this.getRepresentedRef());

    }

    @objid ("03ee730b-1c01-4fab-9cf1-b85ffa7a8ccd")
    @Override
    public MObject getRelatedElement() {
        return this.element;
    }

    @objid ("5743e5b2-dfb2-403a-8d54-ecb18a7753ed")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmBpmnSequenceFlow.", GmBpmnSequenceFlowV0.MINOR_VERSION);

    }

    @objid ("6978718a-3784-4c46-a064-628f7664a72d")
    @Override
    public int getMajorVersion() {
        return GmBpmnSequenceFlowV0.MAJOR_VERSION;
    }

    @objid ("4d3211e4-73f9-4d1f-a8be-09f7cf08d9ca")
    @Override
    protected void read_GmLinkV0_roles() {
        for (GmNodeModel n : getExtensions()) {
            if (n instanceof GmBpmnDataObject) {
                n.setRoleInComposition(GmBpmnSequenceFlow.ROLE_DATAOBJECT);
            } else if (n instanceof GmBpmnEdgeGuard) {
                n.setRoleInComposition(GmBpmnSequenceFlow.ROLE_GUARD);
            } else if (n instanceof GmDefaultModelElementLabel) {
                n.setRoleInComposition(IGmLink.ROLE_MAIN_LABEL);
            }
        }

    }

}
