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
package org.modelio.archimate.diagrams.elements.node;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.node.v0._GmNode;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Node;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Node}.
 */
@objid ("4681d5a5-9aad-4b46-a8f9-48dba0033494")
public class GmNodePrimaryNode extends GmArchiElementPrimaryNode<Node> {
    @objid ("35201f66-2f39-4625-837f-6073e3d90212")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("c00a784e-b4ff-4aec-8e7f-4670b82bb334")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Node is unmasked.
     * @param el the unmasked Node.
     * @param ref a reference to the unmasked Node.
     */
    @objid ("affadf08-9eb7-4d8f-b3c7-5b08f479d5c7")
    public GmNodePrimaryNode(IGmDiagram diagram, Node el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("a9080c43-a402-4d21-a148-0f09711afb87")
    public GmNodePrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("632fd0be-fc88-45aa-906e-60a42b68be1a")
    @Override
    public int getMajorVersion() {
        return GmNodePrimaryNode.MAJOR_VERSION;
    }

    @objid ("a7f4ec95-a575-4fca-8275-c0d20916ad27")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmNodePrimaryNode.");
        switch (readVersion) {
        case 0: {
            read_0(in);
            break;
        }
        default: {
            assert (false) : readVersion + " version number not covered!";
            // reading as last handled version: 0
            read_0(in);
            break;
        }
        }

    }

    @objid ("3ea28b7d-d259-44a8-a192-896bc6daa29a")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmNodePrimaryNode.", MINOR_VERSION);

    }

    @objid ("45d08664-230d-422d-af9e-d6f0097a7f2c")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("37682d77-e306-4bcd-8a1f-831205cd24ca")
    GmNodePrimaryNode(final _GmNode oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    @objid ("ff3e5af5-e5da-464e-aa3c-74a5a1ec81ef")
    @Override
    public List<GmNodeModel> getVisibleChildren() {
        List<GmNodeModel> visibleChildren = super.getVisibleChildren();
        if (getRepresentationMode() == RepresentationMode.SIMPLE) {
            // In simple mode, we do not want a floating label
            visibleChildren.add(this.header);
        }
        return visibleChildren;
    }

}
