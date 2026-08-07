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
package org.modelio.archimate.diagrams.elements.technologycollaboration;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyCollaboration;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link TechnologyCollaboration}.
 */
@objid ("5a1a741a-7efb-46ae-aebd-0a581da54ef2")
public class GmTechnologyCollaborationPrimaryNode extends GmArchiElementPrimaryNode<TechnologyCollaboration> {
    @objid ("97cefd84-edf8-4f2b-9ea9-cc313808c30c")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("3c15421c-ab42-4886-a45d-4d21ac2e61ac")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the TechnologyCollaboration is unmasked.
     * @param el the unmasked TechnologyCollaboration.
     * @param ref a reference to the unmasked TechnologyCollaboration.
     */
    @objid ("543bf7c2-c4e8-4d97-8879-0d100d073ab8")
    public GmTechnologyCollaborationPrimaryNode(IGmDiagram diagram, TechnologyCollaboration el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("75b5b03a-9941-4240-9d4d-04998ccce1e0")
    public GmTechnologyCollaborationPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("42e2dfb2-48ae-466a-9d20-55a937065dde")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("9a7bf84f-242c-411c-ab4b-bc47bd7c5e33")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmTechnologyCollaboration.");
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

    @objid ("85aef560-a0e2-4344-a11b-f800fd79f44b")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmTechnologyCollaboration.", MINOR_VERSION);

    }

    @objid ("48ec104c-805b-46b2-a688-c3c1dd0836fd")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
