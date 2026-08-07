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
package org.modelio.archimate.diagrams.elements.dataobject;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.dataobject.v0._GmDataObject;
import org.modelio.archimate.metamodel.layers.application.structure.passive.DataObject;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link DataObject}.
 */
@objid ("89842121-d75b-4d35-a4dc-963fdd7d2509")
public class GmDataObjectPrimaryNode extends GmArchiElementPrimaryNode<DataObject> {
    @objid ("cf6c7c64-b91b-4e28-97f4-6ac210137026")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("c5b6979b-bf5b-482c-91f6-ba2d636d01ec")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the DataObject is unmasked.
     * @param el the unmasked DataObject.
     * @param ref a reference to the unmasked DataObject.
     */
    @objid ("d34c79ee-00fe-4ce5-b2fb-17043f0a5586")
    public GmDataObjectPrimaryNode(IGmDiagram diagram, DataObject el, MRef ref) {
        super(diagram, el, ref);
        this.header.setShowMetaclassIcon(false);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("1e072ccc-77af-4f5e-bef0-76737884c344")
    public GmDataObjectPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("11df74ff-04d0-42bf-b99a-f10afe59e877")
    @Override
    public int getMajorVersion() {
        return GmDataObjectPrimaryNode.MAJOR_VERSION;
    }

    @objid ("473c9586-8468-485e-9909-a144cc8bd019")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmDataObjectPrimaryNode.");
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

    @objid ("b2983a7e-cdb8-4509-b679-b242294393b9")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmDataObjectPrimaryNode.", GmDataObjectPrimaryNode.MINOR_VERSION);

    }

    @objid ("55eefa8c-05d1-4a5e-96c1-f71f56267f0e")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("46b8cf8a-4e78-4f09-b2a2-307f5420c03a")
    GmDataObjectPrimaryNode(final _GmDataObject oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    @objid ("2c2deb6a-827e-468d-bd45-86403ed82fb3")
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
