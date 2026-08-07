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
package org.modelio.archimate.diagrams.elements.courseofaction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.courseofaction.v0._GmCourseOfAction;
import org.modelio.archimate.metamodel.layers.strategy.behavior.CourseOfAction;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link CourseOfAction}.
 */
@objid ("edf7401c-2a4b-4da4-8d3c-c0d4bc48f877")
public class GmCourseOfActionPrimaryNode extends GmArchiElementPrimaryNode<CourseOfAction> {
    @objid ("99da8827-1004-4003-a557-2a9be426a63a")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("2a7264a0-19c4-4886-85d8-facc7c3e1db3")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the CourseOfAction is unmasked.
     * @param el the unmasked CourseOfAction.
     * @param ref a reference to the unmasked CourseOfAction.
     */
    @objid ("a9296d61-2bd4-4777-84c7-1e24a96585a4")
    public GmCourseOfActionPrimaryNode(IGmDiagram diagram, CourseOfAction el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("778e5bac-ce00-4855-87ca-a24a21a5850f")
    public GmCourseOfActionPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("df39f91d-a996-49df-bdca-c25ea2b00a20")
    @Override
    public int getMajorVersion() {
        return GmCourseOfActionPrimaryNode.MAJOR_VERSION;
    }

    @objid ("77600e33-dbb7-43e9-a5f0-c897ab74afa2")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmCourseOfAction.");
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

    @objid ("08271627-3c22-466a-bd32-9d04d5d8186e")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmCourseOfAction.", GmCourseOfActionPrimaryNode.MINOR_VERSION);

    }

    @objid ("e613185a-9e9e-4494-8c02-a4326bce8445")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("fd11159f-d61b-4ebe-a616-3bbe165bfc65")
    GmCourseOfActionPrimaryNode(final _GmCourseOfAction oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

}
