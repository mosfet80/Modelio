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
package org.modelio.archimate.diagrams.elements.applicationevent;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.applicationevent.v0._GmApplicationEvent;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationEvent;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link ApplicationEvent}.
 */
@objid ("f05fbff9-f894-4036-b16d-2450554e0103")
public class GmApplicationEventPrimaryNode extends GmArchiElementPrimaryNode<ApplicationEvent> {
    @objid ("1a85fb65-9b15-4960-814f-7d3d7b2cb241")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("7a407769-5d5b-4f25-83da-0ac69e60404e")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ApplicationEvent is unmasked.
     * @param el the unmasked ApplicationEvent.
     * @param ref a reference to the unmasked ApplicationEvent.
     */
    @objid ("e457503f-30df-4b5d-b454-0386f49777fb")
    public GmApplicationEventPrimaryNode(IGmDiagram diagram, ApplicationEvent el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("33775036-86a4-4e60-902e-ea962c539cee")
    GmApplicationEventPrimaryNode(final _GmApplicationEvent oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("0c00956c-8ff2-48bb-90f7-21748eb3d668")
    public GmApplicationEventPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("c3b9a969-1e81-44fa-aebd-80e01e8480eb")
    @Override
    public int getMajorVersion() {
        return GmApplicationEventPrimaryNode.MAJOR_VERSION;
    }

    @objid ("7d261280-9d3b-4068-ad65-bd47c55ae7b1")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmApplicationEventPrimaryNode.");
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

    @objid ("e3b48c06-af85-4a15-9c61-d415a975fee9")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmApplicationEventPrimaryNode.", GmApplicationEventPrimaryNode.MINOR_VERSION);

    }

    @objid ("7f69de4d-cecd-4af9-b766-efd8b0d9af51")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("9915c35c-5cdd-4cbc-9d8f-bd85b7f26545")
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
