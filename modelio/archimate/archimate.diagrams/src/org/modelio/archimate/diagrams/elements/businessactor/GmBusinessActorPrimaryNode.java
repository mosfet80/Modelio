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
package org.modelio.archimate.diagrams.elements.businessactor;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.business.structure.active.BusinessActor;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link BusinessActor}.
 */
@objid ("53c778a5-9153-4c7a-a685-7b57da2ab12b")
public class GmBusinessActorPrimaryNode extends GmArchiElementPrimaryNode<BusinessActor> {
    @objid ("60eb6fa5-e137-4834-bd19-85e4b26f357a")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("c5a4021a-f1e9-4f26-8ac3-8337b730daa2")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessActor is unmasked.
     * @param el the unmasked BusinessActor.
     * @param ref a reference to the unmasked BusinessActor.
     */
    @objid ("46c9f2f8-333d-4799-95cc-dd255ab4fc68")
    public GmBusinessActorPrimaryNode(IGmDiagram diagram, BusinessActor el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("2a2b9da4-16fb-43c2-8431-6905950ca07c")
    public GmBusinessActorPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("f76c6c2c-ba44-4faf-a9b9-4c75320010b2")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("2ef5d5df-c277-433d-b193-b3845f360e60")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmBusinessActor.");
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

    @objid ("e4faccde-1ec8-4ebf-ac4e-d2ec89d2252b")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmBusinessActor.", MINOR_VERSION);

    }

    @objid ("dc3b8ce0-68f5-4704-8112-10d941693058")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
