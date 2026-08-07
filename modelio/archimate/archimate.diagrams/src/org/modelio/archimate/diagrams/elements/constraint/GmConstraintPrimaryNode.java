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
package org.modelio.archimate.diagrams.elements.constraint;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.constraint.v0._GmConstraint;
import org.modelio.archimate.metamodel.layers.motivation.Constraint;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Constraint}.
 */
@objid ("0c9354d0-261b-4184-9fe1-f6e1ddceaa16")
public class GmConstraintPrimaryNode extends GmArchiElementPrimaryNode<Constraint> {
    @objid ("017c08e2-2014-4cc7-9cda-ea9d7433e2c6")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("84046507-3907-448d-89c8-c6e6bbc3b1b3")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Constraint is unmasked.
     * @param el the unmasked Constraint.
     * @param ref a reference to the unmasked Constraint.
     */
    @objid ("2be86d5b-cf3e-4a1a-aafe-ce345a330e91")
    public GmConstraintPrimaryNode(IGmDiagram diagram, Constraint el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("ff8cf32b-bf16-4a96-b787-be62ec3b8720")
    public GmConstraintPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("3ce21bef-298a-411b-99cf-b73480771011")
    @Override
    public int getMajorVersion() {
        return GmConstraintPrimaryNode.MAJOR_VERSION;
    }

    @objid ("a43339e1-6a40-41f0-851f-f6af2972f26c")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmConstraintPrimaryNode.");
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

    @objid ("7ba09ddd-948c-4745-880f-da4021062628")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmConstraintPrimaryNode.", GmConstraintPrimaryNode.MINOR_VERSION);

    }

    @objid ("675f7c4b-51e6-45e0-9d67-3053f96bb24a")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("b01288bd-ce81-40cb-a371-a499df938e5a")
    GmConstraintPrimaryNode(final _GmConstraint oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    @objid ("7ef4bb15-424b-4a8b-a199-b74e993068c5")
    @Override
    public List<GmNodeModel> getVisibleChildren() {
        List<GmNodeModel> visibleChildren = super.getVisibleChildren();
        if (getRepresentationMode() == RepresentationMode.SIMPLE) {
            // In simple mode, we do not want a floating label
            visibleChildren.add(this.header);
        }
        return visibleChildren;
    }

}
