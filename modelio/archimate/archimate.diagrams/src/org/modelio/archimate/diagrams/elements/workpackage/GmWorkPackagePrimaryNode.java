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
package org.modelio.archimate.diagrams.elements.workpackage;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.workpackage.v0._GmWorkPackage;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.WorkPackage;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link WorkPackage}.
 */
@objid ("bb3d3e73-53c3-44a3-bb37-8ca79f50fb53")
public class GmWorkPackagePrimaryNode extends GmArchiElementPrimaryNode<WorkPackage> {
    @objid ("4e8b1ffe-a38a-4363-b337-82b9a4f92854")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("f26e101b-9299-4df3-b60d-207af545514d")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the WorkPackage is unmasked.
     * @param el the unmasked WorkPackage.
     * @param ref a reference to the unmasked WorkPackage.
     */
    @objid ("e5a7b328-873c-416a-bc12-b6e85d171b3d")
    public GmWorkPackagePrimaryNode(IGmDiagram diagram, WorkPackage el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("6bcbd8cc-40ec-4ef2-86ee-236f84fc4f82")
    public GmWorkPackagePrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("7a25aa80-a6d3-43ce-86fb-7e7a1109b606")
    @Override
    public int getMajorVersion() {
        return GmWorkPackagePrimaryNode.MAJOR_VERSION;
    }

    @objid ("96408ad8-2a47-44f7-8b4b-298e39bde5de")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmWorkPackagePrimaryNode.");
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

    @objid ("027f1f2c-bceb-472a-9e5a-f46226963f92")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmWorkPackagePrimaryNode.", MINOR_VERSION);

    }

    @objid ("a15c08b7-a194-4631-b6d3-de582d684221")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("52be74f2-2850-49c9-baba-9ac8e66ca33c")
    GmWorkPackagePrimaryNode(final _GmWorkPackage oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

}
