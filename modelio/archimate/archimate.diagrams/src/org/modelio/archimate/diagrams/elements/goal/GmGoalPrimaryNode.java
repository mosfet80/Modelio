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
package org.modelio.archimate.diagrams.elements.goal;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.goal.v0._GmGoal;
import org.modelio.archimate.metamodel.layers.motivation.Goal;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Goal}.
 */
@objid ("c429b7a2-8540-4430-8a19-cd6b776d1c01")
public class GmGoalPrimaryNode extends GmArchiElementPrimaryNode<Goal> {
    @objid ("506fc558-7618-4dbf-8d38-b356bd7b7b03")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("c72efbed-13c0-4a9a-b35e-412ac97a5e2a")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Goal is unmasked.
     * @param el the unmasked Goal.
     * @param ref a reference to the unmasked Goal.
     */
    @objid ("e2b1b690-8b1e-4fea-9436-17bacdc450ee")
    public GmGoalPrimaryNode(IGmDiagram diagram, Goal el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("2099f565-85c8-4bb6-b457-852ed7c1e81b")
    public GmGoalPrimaryNode() {
        // Nothing specific to do.
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("cce6b6dd-157a-48f5-ba41-6d2a452ea99c")
    GmGoalPrimaryNode(final _GmGoal oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    @objid ("54310d94-fe0a-4fcd-9ee1-d86536362987")
    @Override
    public int getMajorVersion() {
        return GmGoalPrimaryNode.MAJOR_VERSION;
    }

    @objid ("956ebf5b-094d-4ecc-94ef-90f9624f731d")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmGoalPrimaryNode.");
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

    @objid ("06837e5c-710c-478d-8934-05013df7baf5")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmGoalPrimaryNode.", GmGoalPrimaryNode.MINOR_VERSION);

    }

    @objid ("24a005a9-1493-47d1-8814-4a9c3de22a6a")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
