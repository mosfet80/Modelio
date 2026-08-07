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
package org.modelio.archimate.diagrams.elements.distributionnetwork;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.physical.structure.active.DistributionNetwork;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link DistributionNetwork}.
 */
@objid ("3a3d3a10-633b-40ae-8233-79c3f9013b6b")
public class GmDistributionNetworkPrimaryNode extends GmArchiElementPrimaryNode<DistributionNetwork> {
    @objid ("4cde4692-2c36-4ff6-9b1a-b5667b1c45c2")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("92194ed2-f278-4547-bacf-a5c4c4ea4b48")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the DistributionNetwork is unmasked.
     * @param el the unmasked DistributionNetwork.
     * @param ref a reference to the unmasked DistributionNetwork.
     */
    @objid ("1579bbaa-402d-4522-bec1-d20f8fab8706")
    public GmDistributionNetworkPrimaryNode(IGmDiagram diagram, DistributionNetwork el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("3c423d59-92a2-4c30-9a2e-67e4ccd6a360")
    public GmDistributionNetworkPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("dad7bceb-3db9-4f98-859f-d840455d44ae")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("df6f387c-7a20-433a-8fe9-11616275ea15")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmDistributionNetwork.");
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

    @objid ("6371956d-cb3a-4e7d-b315-41706e5c80c4")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmDistributionNetwork.", MINOR_VERSION);

    }

    @objid ("e9e87cc9-0d1c-49b6-a86f-f7f28959e385")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
