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
package org.modelio.archimate.diagrams.elements.resource;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.resource.v0._GmResource;
import org.modelio.archimate.metamodel.layers.strategy.structure.Resource;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Resource}.
 */
@objid ("1118c157-8210-4017-aae2-805dfd0081e1")
public class GmResourcePrimaryNode extends GmArchiElementPrimaryNode<Resource> {
    @objid ("01dc1446-8042-4972-8fbf-658f2c1a7a60")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("c9942317-8e89-4de7-ad56-80d3023d66f7")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Resource is unmasked.
     * @param el the unmasked Resource.
     * @param ref a reference to the unmasked Resource.
     */
    @objid ("954496f2-f4e0-4948-961d-603f82f52aaf")
    public GmResourcePrimaryNode(IGmDiagram diagram, Resource el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("9657d8d3-4cd8-4adc-92ba-4203c4f2a63d")
    public GmResourcePrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("57a30a66-4589-4187-b7a9-51f8d41f3ab0")
    @Override
    public int getMajorVersion() {
        return GmResourcePrimaryNode.MAJOR_VERSION;
    }

    @objid ("571c0690-c608-492e-a0be-34c0942dd74a")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmResourcePrimaryNode.");
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

    @objid ("3d7d54c0-243e-412b-a658-e24f7353597f")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmResourcePrimaryNode.", MINOR_VERSION);

    }

    @objid ("e23788df-f232-4907-97ef-bce4545df00a")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("135a5ae0-101e-498f-a6db-d6972e316feb")
    GmResourcePrimaryNode(final _GmResource oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

}
