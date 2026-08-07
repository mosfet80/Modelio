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
package org.modelio.archimate.diagrams.elements.location;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.location.v0._GmLocation;
import org.modelio.archimate.metamodel.core.generic.composite.Location;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Location}.
 */
@objid ("2457c577-6afa-4fa2-9f29-e38a1d66bbf3")
public class GmLocationPrimaryNode extends GmArchiElementPrimaryNode<Location> {
    @objid ("ea216083-809b-48df-be66-6e739f674138")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("8052b4cc-023c-4705-ac33-2a95ae241e9e")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Location is unmasked.
     * @param el the unmasked Location.
     * @param ref a reference to the unmasked Location.
     */
    @objid ("e09526ec-97a4-4610-8aa3-508006ec5223")
    public GmLocationPrimaryNode(IGmDiagram diagram, Location el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("3c98eab6-7bc7-4baa-9f27-47eff75ca9bd")
    public GmLocationPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("f80c5dab-f155-4c91-af69-9b610da545cd")
    @Override
    public int getMajorVersion() {
        return GmLocationPrimaryNode.MAJOR_VERSION;
    }

    @objid ("a61bd9b8-dd13-480d-a01a-c962d779df98")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmLocationPrimaryNode.");
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

    @objid ("805647c3-166c-443a-9c22-5921bb6997db")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmLocationPrimaryNode.", MINOR_VERSION);

    }

    @objid ("ba58f307-ca0f-417c-a7ed-535559a2d25c")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("731973cd-2397-4fd8-a675-43fa491f2f56")
    GmLocationPrimaryNode(final _GmLocation oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

}
