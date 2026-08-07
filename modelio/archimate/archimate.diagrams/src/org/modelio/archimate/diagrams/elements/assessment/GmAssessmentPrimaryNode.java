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
package org.modelio.archimate.diagrams.elements.assessment;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.assessment.v0._GmAssessment;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.motivation.Assessment;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Assessment}.
 */
@objid ("120921dd-4072-466b-b300-9004bfe55ce8")
public class GmAssessmentPrimaryNode extends GmArchiElementPrimaryNode<Assessment> {
    @objid ("28e8c54d-b970-4ac5-8314-b25c3fbdeee4")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("c4a6ba18-1343-4637-9005-8344e055c4c6")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Assessment is unmasked.
     * @param el the unmasked Assessment.
     * @param ref a reference to the unmasked Assessment.
     */
    @objid ("35efcb0f-8b4c-409a-8ea3-1314d24630a5")
    public GmAssessmentPrimaryNode(IGmDiagram diagram, Assessment el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("3807e293-a45a-472b-9ecc-fa1bd593b963")
    public GmAssessmentPrimaryNode() {
        // Nothing specific to do.
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("585dd4a4-9d60-4985-8a42-2a6a7d35aa22")
    GmAssessmentPrimaryNode(final _GmAssessment oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    @objid ("0ef9e17b-d463-44cd-9542-074c4f8ddbf5")
    @Override
    public int getMajorVersion() {
        return GmAssessmentPrimaryNode.MAJOR_VERSION;
    }

    @objid ("e03d5ca7-4a11-46e1-a9df-c1584c1fd91f")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmAssessmentPrimaryNode.");
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

    @objid ("ef38f508-274d-40b6-87fa-ca746f58dfd3")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmAssessmentPrimaryNode.", GmAssessmentPrimaryNode.MINOR_VERSION);

    }

    @objid ("de5687cf-d44a-4f7f-b717-5c32bbf25d3e")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
