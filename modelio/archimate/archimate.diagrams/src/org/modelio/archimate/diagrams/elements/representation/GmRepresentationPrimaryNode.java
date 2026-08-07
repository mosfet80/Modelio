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
package org.modelio.archimate.diagrams.elements.representation;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.representation.v0._GmRepresentation;
import org.modelio.archimate.metamodel.layers.business.structure.passive.Representation;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Representation}.
 */
@objid ("1548a653-c114-4c29-97ce-fea5a17ac296")
public class GmRepresentationPrimaryNode extends GmArchiElementPrimaryNode<Representation> {
    @objid ("a75108c1-2194-4084-8ca8-3e8dc98396dc")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("ac46ce86-2fca-483d-a216-536c0bf08be1")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Representation is unmasked.
     * @param el the unmasked Representation.
     * @param ref a reference to the unmasked Representation.
     */
    @objid ("05faed08-62a7-457b-9a53-b3038a9dfa3f")
    public GmRepresentationPrimaryNode(IGmDiagram diagram, Representation el, MRef ref) {
        super(diagram, el, ref);
        this.header.setShowMetaclassIcon(false);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("25e62e78-f2c7-4916-a786-a0d1fe4dda74")
    public GmRepresentationPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("b0572cf2-1b1e-44c3-8ce1-18232786d12b")
    @Override
    public int getMajorVersion() {
        return GmRepresentationPrimaryNode.MAJOR_VERSION;
    }

    @objid ("dff6ac1c-0783-4534-8959-bafcd208a439")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmRepresentationPrimaryNode.");
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

    @objid ("4ef36eaf-eb72-49e7-872d-709dd70538c4")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmRepresentationPrimaryNode.", MINOR_VERSION);

    }

    @objid ("4c46f670-9731-4755-8922-90183aa6e656")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("901161a6-c2e0-455d-bc90-fce71a7afcf4")
    GmRepresentationPrimaryNode(final _GmRepresentation oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    @objid ("2c748c9b-33b7-417a-b681-e99df10f72ae")
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
