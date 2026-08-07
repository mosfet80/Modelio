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
package org.modelio.archimate.diagrams.elements.applicationinterface;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationInterface;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link ApplicationInterface}.
 */
@objid ("91285af0-3154-4d5b-8e0f-69e5404f2cb0")
public class GmApplicationInterfacePrimaryNode extends GmArchiElementPrimaryNode<ApplicationInterface> {
    @objid ("22082375-8967-438f-a043-01ade01dfcbd")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("9476f5e2-4fff-4b9d-908d-b06aed46447a")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ApplicationInterface is unmasked.
     * @param el the unmasked ApplicationInterface.
     * @param ref a reference to the unmasked ApplicationInterface.
     */
    @objid ("a2ee7cfb-5d95-4428-a69b-6424d6d05cc2")
    public GmApplicationInterfacePrimaryNode(IGmDiagram diagram, ApplicationInterface el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("82bba27a-7954-4420-9b3a-99ec5444436c")
    public GmApplicationInterfacePrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("8c54ce51-46a2-4829-bae0-a2a06a6106b5")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("62043ead-b33a-48a0-83d5-a61950769fc6")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmApplicationInterface.");
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

    @objid ("2330ca7b-a712-420a-b136-13cad5e24ee8")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmApplicationInterface.", MINOR_VERSION);

    }

    @objid ("643e0a30-0c7f-429b-ba1d-3937944dec78")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
