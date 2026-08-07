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
package org.modelio.archimate.diagrams.elements.deliverable;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.deliverable.v0._GmDeliverable;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.Deliverable;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Deliverable}.
 */
@objid ("a0ab0180-6ac5-477e-a801-abc75bda5460")
public class GmDeliverablePrimaryNode extends GmArchiElementPrimaryNode<Deliverable> {
    @objid ("0f179094-70ed-4f27-a5b2-349d579a8a86")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("659710f8-424e-41c0-b055-5fefe47da588")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Deliverable is unmasked.
     * @param el the unmasked Deliverable.
     * @param ref a reference to the unmasked Deliverable.
     */
    @objid ("53624253-14e2-44e0-be27-c0a07b429632")
    public GmDeliverablePrimaryNode(IGmDiagram diagram, Deliverable el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("ecc8d7e5-86c7-4587-92bd-7f86e79c6015")
    public GmDeliverablePrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("389bb8c9-437f-4930-a7dc-e712f195fcbb")
    @Override
    public int getMajorVersion() {
        return GmDeliverablePrimaryNode.MAJOR_VERSION;
    }

    @objid ("c478ebf0-536f-402b-b9ea-9954f028a90f")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmDeliverablePrimaryNode.");
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

    @objid ("ea657c52-6d83-4925-b791-0bddd88982f6")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmDeliverablePrimaryNode.", GmDeliverablePrimaryNode.MINOR_VERSION);

    }

    @objid ("94c5baa6-812a-4699-ac7a-04fa4783ba85")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("45e18f45-791b-4135-8296-684b50cc690e")
    GmDeliverablePrimaryNode(final _GmDeliverable oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    @objid ("bc9a4aca-188c-48ef-8ac6-f562684f0808")
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
