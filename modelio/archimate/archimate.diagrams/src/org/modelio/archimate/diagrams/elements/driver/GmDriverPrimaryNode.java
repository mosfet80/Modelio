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
package org.modelio.archimate.diagrams.elements.driver;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.driver.v0._GmDriver;
import org.modelio.archimate.metamodel.layers.motivation.Driver;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Driver}.
 */
@objid ("449414b4-fe38-47c1-bb2d-9eddc4c63cef")
public class GmDriverPrimaryNode extends GmArchiElementPrimaryNode<Driver> {
    @objid ("89d5b12c-5651-4ced-a871-50d017f3a18e")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("1f9b97ef-8e87-4028-87ce-b214811b9a39")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Driver is unmasked.
     * @param el the unmasked Driver.
     * @param ref a reference to the unmasked Driver.
     */
    @objid ("3a20b25f-26cd-4eb0-8886-f17af9f02efd")
    public GmDriverPrimaryNode(IGmDiagram diagram, Driver el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("1a8167be-a3ab-48e7-a38b-81f21ba1a3a5")
    public GmDriverPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("e1ba81d7-f9f3-4368-88c5-1361690b23a8")
    @Override
    public int getMajorVersion() {
        return GmDriverPrimaryNode.MAJOR_VERSION;
    }

    @objid ("375012ab-bde5-458e-96fc-5b254f703ce1")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmDriverPrimaryNode.");
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

    @objid ("35779925-b9ed-4dea-b0ef-1903ea3b8b8d")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmDriverPrimaryNode.", GmDriverPrimaryNode.MINOR_VERSION);

    }

    @objid ("393dbb0b-2f8f-42e7-8991-7df7756e81eb")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("be522075-9e25-4de8-b75b-ebc17f51fae6")
    GmDriverPrimaryNode(final _GmDriver oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

}
