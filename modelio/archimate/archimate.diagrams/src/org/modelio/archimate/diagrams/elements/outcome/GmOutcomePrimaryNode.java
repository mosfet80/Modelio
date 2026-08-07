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
package org.modelio.archimate.diagrams.elements.outcome;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.outcome.v0._GmOutcome;
import org.modelio.archimate.metamodel.layers.motivation.Outcome;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Outcome}.
 */
@objid ("d5c987d0-f931-40bc-b6f6-717a7604c375")
public class GmOutcomePrimaryNode extends GmArchiElementPrimaryNode<Outcome> {
    @objid ("0902de69-2059-4a37-a402-888a00198533")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("8ea4db4b-5f3b-44f2-9368-0fe931ebd702")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Outcome is unmasked.
     * @param el the unmasked Outcome.
     * @param ref a reference to the unmasked Outcome.
     */
    @objid ("782c099a-3b69-4e54-a548-d95652c9f0e1")
    public GmOutcomePrimaryNode(IGmDiagram diagram, Outcome el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("9c0570b7-97dc-419f-a85b-261c4f59d9aa")
    public GmOutcomePrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("b30efb8a-a91c-47a5-8519-fccd0d529a7b")
    @Override
    public int getMajorVersion() {
        return GmOutcomePrimaryNode.MAJOR_VERSION;
    }

    @objid ("de474399-e3fe-4300-b87a-471bb2880ade")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmOutcomePrimaryNode.");
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

    @objid ("0075c960-9478-4976-ba73-e8a9630eaaa3")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmOutcomePrimaryNode.", MINOR_VERSION);

    }

    @objid ("83c6d6ca-03a9-43d8-b12b-83ff46862bf1")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("c41e5709-c88f-4edb-bd4e-506bb75b7ecb")
    GmOutcomePrimaryNode(final _GmOutcome oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

}
