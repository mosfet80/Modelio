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
package org.modelio.archimate.diagrams.elements.businessinteraction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessInteraction;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link BusinessInteraction}.
 */
@objid ("9989e3be-0cc8-42eb-8c1b-169e17d3e6c6")
public class GmBusinessInteractionPrimaryNode extends GmArchiElementPrimaryNode<BusinessInteraction> {
    @objid ("80fa241a-4d2e-4739-a121-49cca328c7db")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("c85fd454-f2a1-4f31-8a73-5f46b4b6d82a")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessInteraction is unmasked.
     * @param el the unmasked BusinessInteraction.
     * @param ref a reference to the unmasked BusinessInteraction.
     */
    @objid ("126f8a9d-e559-487f-8c93-23dfc9c55c47")
    public GmBusinessInteractionPrimaryNode(IGmDiagram diagram, BusinessInteraction el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("850c5c17-11c9-411e-852f-a520f733a74d")
    public GmBusinessInteractionPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("df0b857f-d188-4394-93d3-fd228dbf3265")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("669d965b-b0fe-473f-a72f-ab10dc28e189")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmBusinessInteraction.");
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

    @objid ("ec55e698-7665-433e-8ee0-fe58cfc4fd30")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmBusinessInteraction.", MINOR_VERSION);

    }

    @objid ("8d104e66-b751-47d9-b495-f24530c90d4c")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
