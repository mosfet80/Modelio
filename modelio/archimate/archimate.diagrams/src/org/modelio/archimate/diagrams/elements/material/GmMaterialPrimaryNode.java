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
package org.modelio.archimate.diagrams.elements.material;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.material.v0._GmMaterial;
import org.modelio.archimate.metamodel.layers.physical.structure.passive.Material;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Material}.
 */
@objid ("72819a3b-81b3-42e4-990b-0f55aaebaa89")
public class GmMaterialPrimaryNode extends GmArchiElementPrimaryNode<Material> {
    @objid ("46f5dc6a-3efd-474d-839f-cbe81aec89d9")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("9c97bd76-e0be-46d7-a7dd-d078bba76716")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Material is unmasked.
     * @param el the unmasked Material.
     * @param ref a reference to the unmasked Material.
     */
    @objid ("99f69e88-316e-4391-a73a-fc9792f3deec")
    public GmMaterialPrimaryNode(IGmDiagram diagram, Material el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("c547369b-3b20-4b38-8113-0b45f82bb3df")
    public GmMaterialPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("e3c7b09c-b746-420d-8e6b-b454dd7921d4")
    @Override
    public int getMajorVersion() {
        return GmMaterialPrimaryNode.MAJOR_VERSION;
    }

    @objid ("c0d7a871-5eca-4fbe-bf76-c62c93e61a37")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmMaterialPrimaryNode.");
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

    @objid ("71b4dbfa-3b14-4d0a-beb0-b757b6b8a22e")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmMaterialPrimaryNode.", MINOR_VERSION);

    }

    @objid ("90c540f0-348e-4d31-8674-dce4a64cf9d2")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("587cf4e6-2cc4-4703-9295-4d8d084cf27d")
    GmMaterialPrimaryNode(final _GmMaterial oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

}
