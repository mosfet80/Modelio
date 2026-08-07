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
package org.modelio.archimate.diagrams.elements.equipment;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.equipment.v0._GmEquipment;
import org.modelio.archimate.metamodel.layers.physical.structure.active.Equipment;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Equipment}.
 */
@objid ("9efe67d1-3f5a-4c3e-9f10-821759666252")
public class GmEquipmentPrimaryNode extends GmArchiElementPrimaryNode<Equipment> {
    @objid ("b33b2d53-3b66-4b4b-b832-ecaa83c6f817")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("ecfc625c-508c-49a6-9a44-11690816510f")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Equipment is unmasked.
     * @param el the unmasked Equipment.
     * @param ref a reference to the unmasked Equipment.
     */
    @objid ("36145a67-b55b-4c50-932a-d8564bee7a59")
    public GmEquipmentPrimaryNode(IGmDiagram diagram, Equipment el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("ccbfa671-192a-43ed-aa60-fc1b2ea122e7")
    public GmEquipmentPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("89da582e-2c06-4b96-b3f3-a90435672e52")
    @Override
    public int getMajorVersion() {
        return GmEquipmentPrimaryNode.MAJOR_VERSION;
    }

    @objid ("586321e4-54f2-49ad-b917-e4c5f0a14cd9")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmEquipmentPrimaryNode.");
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

    @objid ("399f640a-c193-4caa-bb57-51ad77c1fb4c")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmEquipmentPrimaryNode.", GmEquipmentPrimaryNode.MINOR_VERSION);

    }

    @objid ("4cc2dab4-7e37-4c55-9d15-fa154dfcca19")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("c65d2149-c0a9-4b73-9d15-41e82741bb8a")
    GmEquipmentPrimaryNode(final _GmEquipment oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

}
