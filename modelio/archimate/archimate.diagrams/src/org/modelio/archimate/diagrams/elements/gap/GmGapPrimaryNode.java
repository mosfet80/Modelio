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
package org.modelio.archimate.diagrams.elements.gap;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.gap.v0._GmGap;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.Gap;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Gap}.
 */
@objid ("ea04d259-2392-4d99-8e55-6d0c163f785a")
public class GmGapPrimaryNode extends GmArchiElementPrimaryNode<Gap> {
    @objid ("eee4183d-fd16-47b5-9985-52bf1a52f2b5")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("5b5a2c78-6373-43ff-b5dc-f76ffe5d9454")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Gap is unmasked.
     * @param el the unmasked Gap.
     * @param ref a reference to the unmasked Gap.
     */
    @objid ("d31a2173-e821-4096-a3c9-84ea709863a8")
    public GmGapPrimaryNode(IGmDiagram diagram, Gap el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("a8816d89-4dab-404f-97d4-13cb41864781")
    public GmGapPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("8681892e-436e-4092-b796-e96abd772e86")
    @Override
    public int getMajorVersion() {
        return GmGapPrimaryNode.MAJOR_VERSION;
    }

    @objid ("19ce2c38-ec87-42fd-9ef1-f2e8053cd3b0")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmGapPrimaryNode.");
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

    @objid ("bf9209f5-fb4f-46c1-89bc-89e692b32e4d")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmGapPrimaryNode.", GmGapPrimaryNode.MINOR_VERSION);

    }

    @objid ("de520de6-224e-4da1-b2ca-b61cf0a8d64b")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("6fa22cba-d57f-4712-8169-0c36412c2c70")
    GmGapPrimaryNode(final _GmGap oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

}
