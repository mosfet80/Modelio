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
package org.modelio.archimate.diagrams.elements.applicationservice;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.applicationservice.v0._GmApplicationService;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationService;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link ApplicationService}.
 */
@objid ("f28753c5-4701-4a43-8301-14010726cafa")
public class GmApplicationServicePrimaryNode extends GmArchiElementPrimaryNode<ApplicationService> {
    @objid ("fd3c8e01-dd72-4983-8ee2-90542ff8a022")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("c4bbb28d-1f0a-41a5-8807-2212c53b8304")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ApplicationService is unmasked.
     * @param el the unmasked ApplicationService.
     * @param ref a reference to the unmasked ApplicationService.
     */
    @objid ("bc23ccbb-1071-4b0b-86da-9a5a3ba293e5")
    public GmApplicationServicePrimaryNode(IGmDiagram diagram, ApplicationService el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("edcf4c25-7151-4087-9791-1c8db21ac464")
    public GmApplicationServicePrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("c5ab135b-e6f3-444a-90d3-d45ded19d843")
    @Override
    public int getMajorVersion() {
        return GmApplicationServicePrimaryNode.MAJOR_VERSION;
    }

    @objid ("7f3b2e9d-906c-45cb-abea-22bf561a9610")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmApplicationServicePrimaryNode.");
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

    @objid ("4415995c-d596-4809-a7ba-2af805810289")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmApplicationServicePrimaryNode.", GmApplicationServicePrimaryNode.MINOR_VERSION);

    }

    @objid ("ccff44db-f389-46bb-9124-6a18ec29f721")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("bdd43d42-917f-418e-b0d2-01096d8d37cc")
    GmApplicationServicePrimaryNode(final _GmApplicationService oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    @objid ("7d9b4686-5e05-4d9a-b28f-6ba6d13dfd56")
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
