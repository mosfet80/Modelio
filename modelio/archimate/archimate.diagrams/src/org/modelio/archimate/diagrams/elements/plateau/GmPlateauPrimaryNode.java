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
package org.modelio.archimate.diagrams.elements.plateau;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.plateau.v0._GmPlateau;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.Plateau;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Plateau}.
 */
@objid ("f17c556b-1c37-4db2-ad89-ac9bbf341177")
public class GmPlateauPrimaryNode extends GmArchiElementPrimaryNode<Plateau> {
    @objid ("9de392a9-87dc-42af-9c59-608e958c516f")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("32c52886-ee59-49b4-87bd-3aaff2aedd62")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Plateau is unmasked.
     * @param el the unmasked Plateau.
     * @param ref a reference to the unmasked Plateau.
     */
    @objid ("e63d2065-a1a7-4b89-9499-59a5caa63c6d")
    public GmPlateauPrimaryNode(IGmDiagram diagram, Plateau el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("8f77661c-c580-4eae-9b00-51dd78e6d266")
    public GmPlateauPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("4a344943-7f48-422b-a598-fae9fdae2947")
    @Override
    public int getMajorVersion() {
        return GmPlateauPrimaryNode.MAJOR_VERSION;
    }

    @objid ("3a315c5b-ad84-42c7-8e9f-84f190f7e20f")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmPlateauPrimaryNode.");
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

    @objid ("c25ca708-62c6-4a17-a74e-9a794b85140a")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmPlateauPrimaryNode.", MINOR_VERSION);

    }

    @objid ("b3d6209c-b150-4dd9-bd87-484aecd84dfe")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("2be8d22c-82e7-4276-932c-b8af09aec028")
    GmPlateauPrimaryNode(final _GmPlateau oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

}
