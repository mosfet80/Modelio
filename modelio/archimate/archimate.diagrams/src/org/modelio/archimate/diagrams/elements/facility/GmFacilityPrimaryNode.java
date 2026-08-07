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
package org.modelio.archimate.diagrams.elements.facility;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.facility.v0._GmFacility;
import org.modelio.archimate.metamodel.layers.physical.structure.active.Facility;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Facility}.
 */
@objid ("44ebbf8f-06e6-4be1-b603-b6186428ef07")
public class GmFacilityPrimaryNode extends GmArchiElementPrimaryNode<Facility> {
    @objid ("ee6f8829-0c96-4ba6-b56a-6e9222618435")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("7a82fe32-8d4d-45cd-9b68-e1a1c963f268")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Facility is unmasked.
     * @param el the unmasked Facility.
     * @param ref a reference to the unmasked Facility.
     */
    @objid ("8a07e18f-cb04-48b2-8090-c8e6125e57db")
    public GmFacilityPrimaryNode(IGmDiagram diagram, Facility el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("725c7580-9bd2-4418-af1d-40fc6d67f860")
    public GmFacilityPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("8ebbb79a-6670-494f-a0fe-be61f9b1d61e")
    @Override
    public int getMajorVersion() {
        return GmFacilityPrimaryNode.MAJOR_VERSION;
    }

    @objid ("37b57f71-53b5-444b-a8ae-d4ac1718bcd8")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmFacilityPrimaryNode.");
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

    @objid ("17af11b1-8576-4cab-acf7-597c6c87aebc")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmFacilityPrimaryNode.", GmFacilityPrimaryNode.MINOR_VERSION);

    }

    @objid ("831255f3-e484-4e0a-bfe4-6d3d8e53e87f")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("7562e869-4cd3-47c2-93cb-9a569d883828")
    GmFacilityPrimaryNode(final _GmFacility oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

}
