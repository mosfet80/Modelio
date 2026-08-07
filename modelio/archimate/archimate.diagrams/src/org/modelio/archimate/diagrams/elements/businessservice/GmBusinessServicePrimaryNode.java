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
package org.modelio.archimate.diagrams.elements.businessservice;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessservice.v0._GmBusinessService;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessService;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link BusinessService}.
 */
@objid ("24e2a11a-4f49-4acd-8d95-c31af1132179")
public class GmBusinessServicePrimaryNode extends GmArchiElementPrimaryNode<BusinessService> {
    @objid ("de903f11-0cd6-480c-9373-f42b58f92c4e")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("38a22b5f-ed95-4508-985e-dd9d897f2ad4")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessService is unmasked.
     * @param el the unmasked BusinessService.
     * @param ref a reference to the unmasked BusinessService.
     */
    @objid ("70f9d446-d597-4a2c-adf9-ac0e6d4373ca")
    public GmBusinessServicePrimaryNode(IGmDiagram diagram, BusinessService el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("43b9f72b-f91f-47fb-9419-64a1963933a1")
    GmBusinessServicePrimaryNode(final _GmBusinessService oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("b0fc11b3-e301-443a-ace6-52bdfe0b4eed")
    public GmBusinessServicePrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("f58b0cdd-35f5-4291-b529-4fdda70fa791")
    @Override
    public int getMajorVersion() {
        return GmBusinessServicePrimaryNode.MAJOR_VERSION;
    }

    @objid ("e6c3833b-6b76-4513-a5ec-22fd078e6277")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmBusinessServicePrimaryNode.");
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

    @objid ("a9ded2d1-9a70-4166-8371-710657a2081b")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmBusinessServicePrimaryNode.", GmBusinessServicePrimaryNode.MINOR_VERSION);

    }

    @objid ("def89adc-8ddf-4da4-8370-f1b13e524dd1")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("b5e4f8ac-eb3a-4d3d-a97f-31ce0a410bdc")
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
