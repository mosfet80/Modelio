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
package org.modelio.archimate.diagrams.elements.businesscollaboration;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.business.structure.active.BusinessCollaboration;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link BusinessCollaboration}.
 */
@objid ("e10dae38-b578-47ac-a758-a680be8a407b")
public class GmBusinessCollaborationPrimaryNode extends GmArchiElementPrimaryNode<BusinessCollaboration> {
    @objid ("009008f4-e2ad-4697-89ca-a4986d02cc02")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("ad7c9f8c-8c02-46b6-8bd9-59f4fc02a35f")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessCollaboration is unmasked.
     * @param el the unmasked BusinessCollaboration.
     * @param ref a reference to the unmasked BusinessCollaboration.
     */
    @objid ("ce9d67d2-f134-4aa5-b9d8-8905a70fcac1")
    public GmBusinessCollaborationPrimaryNode(IGmDiagram diagram, BusinessCollaboration el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("94287c06-09e0-47fb-a044-4fec54ad36d8")
    public GmBusinessCollaborationPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("c660581d-2792-4e8a-8f96-9a4f0932d1b0")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("8d7f1d3c-15ce-4313-b415-4140c39cc0a2")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmBusinessCollaboration.");
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

    @objid ("1a061649-d738-4381-9459-7e1f9cd4157a")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmBusinessCollaboration.", MINOR_VERSION);

    }

    @objid ("0ccc2810-3d9b-4d97-abbb-bc2fb39f906a")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
