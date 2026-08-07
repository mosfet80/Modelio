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
package org.modelio.archimate.diagrams.elements.applicationcollaboration;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationCollaboration;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link ApplicationCollaboration}.
 */
@objid ("c00c87d3-402c-4bcb-bdcc-28130bebf87a")
public class GmApplicationCollaborationPrimaryNode extends GmArchiElementPrimaryNode<ApplicationCollaboration> {
    @objid ("217e7cfb-18a7-403b-b92a-83b7c5755b4f")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("3cb2e526-cf39-4595-b939-1afd7695b422")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ApplicationCollaboration is unmasked.
     * @param el the unmasked ApplicationCollaboration.
     * @param ref a reference to the unmasked ApplicationCollaboration.
     */
    @objid ("5aed4c80-4026-438b-b94e-da9d734884f2")
    public GmApplicationCollaborationPrimaryNode(IGmDiagram diagram, ApplicationCollaboration el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("207480c1-a695-42e2-ad22-543a12640c66")
    public GmApplicationCollaborationPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("4b7b0313-d5c4-4bfb-af04-e3fedda060a5")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("c0342874-3ef0-4fa1-a9f9-7ce5e0b27b45")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmApplicationCollaboration.");
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

    @objid ("e92b5e39-9653-4b17-acbf-6b854ef64246")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmApplicationCollaboration.", MINOR_VERSION);

    }

    @objid ("0df7ed83-aa12-4d53-9028-09833cf90ba2")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
