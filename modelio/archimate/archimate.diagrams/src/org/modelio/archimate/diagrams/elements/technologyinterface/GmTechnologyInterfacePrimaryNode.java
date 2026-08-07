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
package org.modelio.archimate.diagrams.elements.technologyinterface;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyInterface;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link TechnologyInterface}.
 */
@objid ("a2f62a51-cf3b-4d59-b8eb-dd22f139a1dd")
public class GmTechnologyInterfacePrimaryNode extends GmArchiElementPrimaryNode<TechnologyInterface> {
    @objid ("9aa5899b-64a8-4b50-ad6b-7b23d820e3e1")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("17302af7-f4de-4eeb-88e0-c47d8f1c4200")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the TechnologyInterface is unmasked.
     * @param el the unmasked TechnologyInterface.
     * @param ref a reference to the unmasked TechnologyInterface.
     */
    @objid ("63542426-187c-4832-9623-f9d7132b466f")
    public GmTechnologyInterfacePrimaryNode(IGmDiagram diagram, TechnologyInterface el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("d9006161-a41a-482e-b4af-500a3bbbac8b")
    public GmTechnologyInterfacePrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("5f325663-13b9-40af-86bd-f628de7fa278")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("6e7a0620-7ab9-40af-b54e-704080fdccdb")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmTechnologyInterface.");
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

    @objid ("a762f3dd-0aa3-4182-95a3-333e8c3351a8")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmTechnologyInterface.", MINOR_VERSION);

    }

    @objid ("63acb56b-2ba1-4614-b16b-12c2c3072751")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
