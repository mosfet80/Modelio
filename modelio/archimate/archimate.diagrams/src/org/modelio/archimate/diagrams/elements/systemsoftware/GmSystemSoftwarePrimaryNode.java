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
package org.modelio.archimate.diagrams.elements.systemsoftware;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.systemsoftware.v0._GmSystemSoftware;
import org.modelio.archimate.metamodel.layers.technology.structure.active.SystemSoftware;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link SystemSoftware}.
 */
@objid ("5c34b350-77dd-401b-8b96-1146dca3effd")
public class GmSystemSoftwarePrimaryNode extends GmArchiElementPrimaryNode<SystemSoftware> {
    @objid ("a7b203d0-904a-4f72-81a7-41a7893e66fd")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("5f557eb3-284a-4902-87d9-d926cd4c6b84")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the SystemSoftware is unmasked.
     * @param el the unmasked SystemSoftware.
     * @param ref a reference to the unmasked SystemSoftware.
     */
    @objid ("49cbf95a-0c71-4f66-9712-59603654f398")
    public GmSystemSoftwarePrimaryNode(IGmDiagram diagram, SystemSoftware el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("38a9ec5b-35ff-4ecf-97c4-7dd40b4578a4")
    public GmSystemSoftwarePrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("9ff56a7d-4be8-4090-aa40-1aca7e22a22b")
    @Override
    public int getMajorVersion() {
        return GmSystemSoftwarePrimaryNode.MAJOR_VERSION;
    }

    @objid ("3cd2d8c8-eca2-4c8b-9aa1-d06048e30286")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmSystemSoftwarePrimaryNode.");
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

    @objid ("1cd0d18c-45ba-4248-8719-50571dcee360")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmSystemSoftwarePrimaryNode.", MINOR_VERSION);

    }

    @objid ("9bbea557-82f8-4c08-90d8-048a5e48a5a4")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("9d7946fe-a6e3-4952-a3cc-973ead0a90c0")
    GmSystemSoftwarePrimaryNode(final _GmSystemSoftware oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

}
