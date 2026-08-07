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
package org.modelio.archimate.diagrams.elements.device;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.device.v0._GmDevice;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Device;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Device}.
 */
@objid ("19d0226a-fc00-4c6c-b8a0-afb8f9eb6e4b")
public class GmDevicePrimaryNode extends GmArchiElementPrimaryNode<Device> {
    @objid ("0df41e59-6c5f-4269-919d-6d40f4e3f335")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("cbbc9ce4-2fcd-498f-972a-ad1aa944dc85")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Device is unmasked.
     * @param el the unmasked Device.
     * @param ref a reference to the unmasked Device.
     */
    @objid ("10a451d6-4ac8-4658-bb6e-074889dc218c")
    public GmDevicePrimaryNode(IGmDiagram diagram, Device el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("5d02fd49-525d-49a4-9dfa-95e1f94711b4")
    public GmDevicePrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("f49d006f-0f82-4c75-863f-52303b17669b")
    @Override
    public int getMajorVersion() {
        return GmDevicePrimaryNode.MAJOR_VERSION;
    }

    @objid ("c90584b1-a78f-4648-91c1-1c932c4e1545")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmDevicePrimaryNode.");
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

    @objid ("2d681972-7d91-4c27-acb0-05426f8efeed")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmDevicePrimaryNode.", GmDevicePrimaryNode.MINOR_VERSION);

    }

    @objid ("a0cf8641-ecf2-49d8-89bf-773c021ca30f")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("7cc88ae8-3b0b-48e6-a40c-8b309f9a0bc1")
    GmDevicePrimaryNode(final _GmDevice oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    @objid ("f9e0d8e9-e345-4cf1-b82d-95f825d3ae9a")
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
