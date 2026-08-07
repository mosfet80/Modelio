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
package org.modelio.archimate.diagrams.elements.principle;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.principle.v0._GmPrinciple;
import org.modelio.archimate.metamodel.layers.motivation.Principle;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Principle}.
 */
@objid ("c8265bc1-1f26-4c33-a488-63f6ca64f86a")
public class GmPrinciplePrimaryNode extends GmArchiElementPrimaryNode<Principle> {
    @objid ("50aadc50-0cf4-4a30-95d8-1be87f58ea0e")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("0209dc76-bb23-48ca-9322-9d0b4d8639fe")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Principle is unmasked.
     * @param el the unmasked Principle.
     * @param ref a reference to the unmasked Principle.
     */
    @objid ("89d94c2d-f60d-4156-8aa3-5be67aa4720b")
    public GmPrinciplePrimaryNode(IGmDiagram diagram, Principle el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("0f89bee8-b548-4952-9684-95895fafb224")
    public GmPrinciplePrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("3397eded-6dec-4da3-b825-b1e77a5ae00b")
    @Override
    public int getMajorVersion() {
        return GmPrinciplePrimaryNode.MAJOR_VERSION;
    }

    @objid ("a7055eaa-5ea5-4ad1-af9d-ce446a7be078")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmPrinciplePrimaryNode.");
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

    @objid ("300f81f9-c748-41c2-8382-583588ddfeb8")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("d577bfb7-8c6d-4907-bfc9-a6aaa082782c")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmPrinciplePrimaryNode.", MINOR_VERSION);

    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("a4a7c4a8-163c-4883-b8f3-b23ea0f7ed7e")
    GmPrinciplePrimaryNode(final _GmPrinciple oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

}
