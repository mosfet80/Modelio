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
package org.modelio.archimate.diagrams.elements.implementationevent;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.implementationevent.v0._GmImplementationEvent;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.ImplementationEvent;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link ImplementationEvent}.
 */
@objid ("b07dfaa0-5ab3-4c36-b850-e230c22b03d8")
public class GmImplementationEventPrimaryNode extends GmArchiElementPrimaryNode<ImplementationEvent> {
    @objid ("973219c5-d8d3-40cc-9ac1-1ee4079dba11")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("03bd08ef-d0c1-4cce-9a99-2dcf8fc6abc6")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ImplementationEvent is unmasked.
     * @param el the unmasked ImplementationEvent.
     * @param ref a reference to the unmasked ImplementationEvent.
     */
    @objid ("5e725cd1-880f-43dd-bedb-10570169d622")
    public GmImplementationEventPrimaryNode(IGmDiagram diagram, ImplementationEvent el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("18f847c9-a8b3-46f4-bc1b-6c69b49b54e6")
    public GmImplementationEventPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("47ec8fa2-9036-43e2-a41b-504b7ff97065")
    @Override
    public int getMajorVersion() {
        return GmImplementationEventPrimaryNode.MAJOR_VERSION;
    }

    @objid ("29b9d608-74c5-461d-bc6e-9f787cb3b321")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmImplementationEventPrimaryNode.");
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

    @objid ("a105fa33-d89a-49aa-a616-893f6363b4af")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmImplementationEventPrimaryNode.", GmImplementationEventPrimaryNode.MINOR_VERSION);

    }

    @objid ("ee4c8745-02e6-4062-b188-85542dfa26ed")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("c18ef3f9-dacd-4eec-a10e-fd551885aa60")
    GmImplementationEventPrimaryNode(final _GmImplementationEvent oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    @objid ("4ccb7c03-97cc-4b53-b0b1-87864eb36d17")
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
