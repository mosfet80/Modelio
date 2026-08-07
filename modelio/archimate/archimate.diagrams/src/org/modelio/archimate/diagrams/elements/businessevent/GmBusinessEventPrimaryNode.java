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
package org.modelio.archimate.diagrams.elements.businessevent;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessevent.v0._GmBusinessEvent;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessEvent;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link BusinessEvent}.
 */
@objid ("812b5209-137a-45d7-8fc5-da6095a7d9ba")
public class GmBusinessEventPrimaryNode extends GmArchiElementPrimaryNode<BusinessEvent> {
    @objid ("9b7c91c3-1f96-4d33-8c05-600b10874f44")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("6b79bcda-5543-4ef8-9626-15d52aaf5c8b")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessEvent is unmasked.
     * @param el the unmasked BusinessEvent.
     * @param ref a reference to the unmasked BusinessEvent.
     */
    @objid ("a3e3c99a-4490-4ce1-ad1c-6f53fd042e71")
    public GmBusinessEventPrimaryNode(IGmDiagram diagram, BusinessEvent el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("c68fdc03-dea4-478d-a69a-2839349efca7")
    GmBusinessEventPrimaryNode(final _GmBusinessEvent oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("a7929e76-e998-4e16-bb3c-6c25f075ce24")
    public GmBusinessEventPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("4a9b3097-b783-4176-8790-ac8c78968246")
    @Override
    public int getMajorVersion() {
        return GmBusinessEventPrimaryNode.MAJOR_VERSION;
    }

    @objid ("4057cbc5-1928-4b16-af2c-01acca94c8a9")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmBusinessEventPrimaryNode.");
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

    @objid ("ad50e350-5b87-45e3-94b3-1d640559d54b")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmBusinessEventPrimaryNode.", GmBusinessEventPrimaryNode.MINOR_VERSION);

    }

    @objid ("b76a6440-8f9c-4e5a-9720-824be55b2032")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("df6cd793-4e7f-486c-a3a7-f13c0176eeee")
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
