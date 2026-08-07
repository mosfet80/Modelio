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
package org.modelio.archimate.diagrams.elements.businessrole;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessrole.v0._GmBusinessRole;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.business.structure.active.BusinessRole;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link BusinessRole}.
 */
@objid ("26c0f70c-5797-444a-bbcb-7a3bee9dbfd8")
public class GmBusinessRolePrimaryNode extends GmArchiElementPrimaryNode<BusinessRole> {
    @objid ("a999933d-4c62-4cd0-ae37-dc396e663958")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("964a9dec-b2ec-47d3-a258-e825e4230bba")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessRole is unmasked.
     * @param el the unmasked BusinessRole.
     * @param ref a reference to the unmasked BusinessRole.
     */
    @objid ("b639b160-302f-4426-949b-058b22d5bee2")
    public GmBusinessRolePrimaryNode(IGmDiagram diagram, BusinessRole el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("c632b7e3-237f-4595-aa75-eb71f6fedd36")
    GmBusinessRolePrimaryNode(final _GmBusinessRole oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("0cb1b941-b3a2-4938-934d-f69c2a760b13")
    public GmBusinessRolePrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("5d40a508-577c-4983-9d49-2cb7e8f177c1")
    @Override
    public int getMajorVersion() {
        return GmBusinessRolePrimaryNode.MAJOR_VERSION;
    }

    @objid ("436b7823-93c2-4a47-bed0-bad305b94396")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmBusinessRolePrimaryNode.");
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

    @objid ("d11b3266-beb7-4cf5-92b6-4efd8380bdc7")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmBusinessRolePrimaryNode.", GmBusinessRolePrimaryNode.MINOR_VERSION);

    }

    @objid ("0ad4851c-ed56-4e3b-8112-ead6485f9dda")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("97b5f732-d2b9-485d-a851-a74f1ee9f4af")
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
