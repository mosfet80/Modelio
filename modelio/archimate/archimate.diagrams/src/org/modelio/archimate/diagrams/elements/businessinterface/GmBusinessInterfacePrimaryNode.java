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
package org.modelio.archimate.diagrams.elements.businessinterface;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.business.structure.active.BusinessInterface;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link BusinessInterface}.
 */
@objid ("802f9e3f-c654-40b3-871c-8e59538749e5")
public class GmBusinessInterfacePrimaryNode extends GmArchiElementPrimaryNode<BusinessInterface> {
    @objid ("fa355870-65fa-4193-9f52-3e710e0068c1")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("0ba040e1-c465-4c71-8a1d-3dfe9dbfe663")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessInterface is unmasked.
     * @param el the unmasked BusinessInterface.
     * @param ref a reference to the unmasked BusinessInterface.
     */
    @objid ("0d438490-4136-47d3-8a88-7ab50d37afb1")
    public GmBusinessInterfacePrimaryNode(IGmDiagram diagram, BusinessInterface el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("ee2df6bb-8ff9-4935-87f6-8fa599ec8066")
    public GmBusinessInterfacePrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("7923affc-ecd5-4991-9e0c-81c1152d0b31")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("d37f5dc7-4b00-4f52-b659-067e8a0162ab")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmBusinessInterface.");
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

    @objid ("9abd7163-ec7a-48ba-a851-c83f5ae23dfb")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmBusinessInterface.", MINOR_VERSION);

    }

    @objid ("08f0b841-cdf5-4f81-b56a-c44c2528e528")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
