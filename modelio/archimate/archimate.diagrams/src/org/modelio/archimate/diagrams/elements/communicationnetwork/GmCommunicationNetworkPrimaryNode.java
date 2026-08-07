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
package org.modelio.archimate.diagrams.elements.communicationnetwork;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.technology.structure.active.CommunicationNetwork;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link CommunicationNetwork}.
 */
@objid ("a5cc1446-910b-48b9-818a-addd15efa945")
public class GmCommunicationNetworkPrimaryNode extends GmArchiElementPrimaryNode<CommunicationNetwork> {
    @objid ("d9c51079-ef7c-46e2-8332-2003f49e11b9")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("029a6059-4d2c-495b-8d12-a504201fe3f2")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the CommunicationNetwork is unmasked.
     * @param el the unmasked CommunicationNetwork.
     * @param ref a reference to the unmasked CommunicationNetwork.
     */
    @objid ("d0bb2a0d-1403-4a3c-8cb6-3dc7ca08ed87")
    public GmCommunicationNetworkPrimaryNode(IGmDiagram diagram, CommunicationNetwork el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("4a486940-ef49-426e-9097-7756ea6e5962")
    public GmCommunicationNetworkPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("cde1ea47-5ea2-4646-8279-6fca958eca72")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("22609b6e-8a5a-4d5e-96b6-0e775918549f")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmCommunicationNetwork.");
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

    @objid ("fa44d89e-6318-4f04-88ca-1b9583b00beb")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmCommunicationNetwork.", MINOR_VERSION);

    }

    @objid ("816513cc-f115-4b03-81af-78288aebd778")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
