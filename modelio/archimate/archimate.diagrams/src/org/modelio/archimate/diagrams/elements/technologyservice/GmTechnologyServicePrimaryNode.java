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
package org.modelio.archimate.diagrams.elements.technologyservice;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.technologyservice.v0._GmTechnologyService;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyService;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link TechnologyService}.
 */
@objid ("74e9270a-fb86-4453-a493-8c1f8bd6585c")
public class GmTechnologyServicePrimaryNode extends GmArchiElementPrimaryNode<TechnologyService> {
    @objid ("707cb867-3dae-4346-8465-7746eeb26b24")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("0cc8928a-d778-40de-8ec5-82eda3ebae1a")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the TechnologyService is unmasked.
     * @param el the unmasked TechnologyService.
     * @param ref a reference to the unmasked TechnologyService.
     */
    @objid ("f9223eba-ddb5-4865-81de-4a00108c0885")
    public GmTechnologyServicePrimaryNode(IGmDiagram diagram, TechnologyService el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("6cb6dec6-1182-46b2-8bc3-60e1bce79258")
    public GmTechnologyServicePrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("a29d4aaa-7ec2-4428-b581-4133e8ed6b70")
    @Override
    public int getMajorVersion() {
        return GmTechnologyServicePrimaryNode.MAJOR_VERSION;
    }

    @objid ("461d0e68-9442-4f90-b227-eb764d8c5806")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmTechnologyServicePrimaryNode.");
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

    @objid ("fc7adc0b-3540-4166-ac70-c1702e1e0925")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmTechnologyServicePrimaryNode.", MINOR_VERSION);

    }

    @objid ("e9d5f232-6ba7-4eea-bc55-d8523a9deeaa")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("9e184b67-bd2a-4283-ad72-e99193016281")
    GmTechnologyServicePrimaryNode(final _GmTechnologyService oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    @objid ("20872126-0ac7-4bd9-aa98-06e625b9c932")
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
