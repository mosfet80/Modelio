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
package org.modelio.archimate.diagrams.elements.technologyevent;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.technologyevent.v0._GmTechnologyEvent;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyEvent;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link TechnologyEvent}.
 */
@objid ("4a855727-f5ee-4a68-a45a-754db1176af2")
public class GmTechnologyEventPrimaryNode extends GmArchiElementPrimaryNode<TechnologyEvent> {
    @objid ("0124bfb7-a929-44fc-adc0-cd5208940ece")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("fdcdb965-caa2-47db-afae-a443f5389c89")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the TechnologyEvent is unmasked.
     * @param el the unmasked TechnologyEvent.
     * @param ref a reference to the unmasked TechnologyEvent.
     */
    @objid ("f93cd172-905a-4a36-903f-b4632b3332ca")
    public GmTechnologyEventPrimaryNode(IGmDiagram diagram, TechnologyEvent el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("8297e1e5-a1b6-40b7-8195-35b2c8fbdfad")
    public GmTechnologyEventPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("4d649d7d-925e-421e-8b93-d2f07f55c5a9")
    @Override
    public int getMajorVersion() {
        return GmTechnologyEventPrimaryNode.MAJOR_VERSION;
    }

    @objid ("f6971812-2857-4d84-a5e8-3f908f8452c9")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmTechnologyEventPrimaryNode.");
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

    @objid ("5dfac22a-3f57-4dbc-9cac-dc0ac38983c3")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmTechnologyEventPrimaryNode.", MINOR_VERSION);

    }

    @objid ("c9ea07a7-9630-4cfc-b225-292076fb7452")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("4aba449d-d2df-4b25-a41f-90aa0643a989")
    GmTechnologyEventPrimaryNode(final _GmTechnologyEvent oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    @objid ("9b0a97dc-f4ec-4adf-8dcf-e0edbdd24010")
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
