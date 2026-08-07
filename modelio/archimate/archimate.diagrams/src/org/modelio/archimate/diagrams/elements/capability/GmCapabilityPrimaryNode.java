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
package org.modelio.archimate.diagrams.elements.capability;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.capability.v0._GmCapability;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.strategy.behavior.Capability;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Capability}.
 */
@objid ("46e44c4f-6315-4c80-858d-be8f5e638d9d")
public class GmCapabilityPrimaryNode extends GmArchiElementPrimaryNode<Capability> {
    @objid ("88bd22a3-54e4-43e5-9d53-de2e7d81b142")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("975be5cc-16b9-4d19-94b6-3f14a75164f4")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Capability is unmasked.
     * @param el the unmasked Capability.
     * @param ref a reference to the unmasked Capability.
     */
    @objid ("bd3d5e57-c615-4a79-89b0-40bd0b7a4ad7")
    public GmCapabilityPrimaryNode(IGmDiagram diagram, Capability el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("10cfa487-81e1-45f4-b2ed-af72921706ba")
    public GmCapabilityPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("bcf6965f-11d0-4342-8d58-d78ec13192ab")
    @Override
    public int getMajorVersion() {
        return GmCapabilityPrimaryNode.MAJOR_VERSION;
    }

    @objid ("2e448b82-ad17-40c6-b0e4-cd944082b7f7")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmCapabilityPrimaryNode.");
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

    @objid ("f3608821-5e60-4427-bf69-e4fe11933731")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmCapabilityPrimaryNode.", GmCapabilityPrimaryNode.MINOR_VERSION);

    }

    @objid ("908ed4e0-3a5d-4fb6-9732-d27844be133b")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("98585a71-cf38-482f-8db3-1fa332213d27")
    GmCapabilityPrimaryNode(final _GmCapability oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

}
