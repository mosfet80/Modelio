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
package org.modelio.archimate.diagrams.elements.common.archiheader;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.diagram.elements.common.header.GmDefaultModelElementHeader;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Displays the represented element name as main label, with metaclass and stereotypes icons on the right.
 * <p>
 * Has no own style, depends on its parent element.
 * </p>
 */
@objid ("d2d9404e-4e5b-4fcf-b7d2-a8d2e1765606")
public class GmArchiHeader extends GmDefaultModelElementHeader {
    @objid ("e2dae959-1805-4ad3-beb8-99d3e33c62cb")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm. Defaults to 0.
     */
    @objid ("1e349393-fb8c-470a-aef4-386f4f280324")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram
     * @param relatedRef a reference to the element this GmModel is related to, must not be null.
     */
    @objid ("8ba36f91-6be3-4624-a77e-a7976afa7b99")
    public GmArchiHeader(IGmDiagram diagram, MRef relatedRef) {
        super(diagram, relatedRef);
    }

    /**
     * For deserialization only.
     */
    @objid ("662e154b-2aff-4f48-8d0a-f44e4b240679")
    public GmArchiHeader() {

    }

    @objid ("856ac96e-f3eb-4f12-a593-d0f11a6f6fa7")
    @Override
    public int getMajorVersion() {
        return GmArchiHeader.MAJOR_VERSION;
    }

    @objid ("fa5475b7-92ea-4b80-b5c4-385feaf1a4f9")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmArchiHeader.");
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

    @objid ("ee2ca4ec-8c25-4b41-ba6a-7ae42730c248")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmArchiHeader.", GmArchiHeader.MINOR_VERSION);

    }

    @objid ("06005839-d78d-4668-ace0-2ed6482b2177")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("a34049fc-73d3-4e20-8829-d280fbcd9d08")
    @Override
    public RepresentationMode getRepresentationMode() {
        return RepresentationMode.STRUCTURED;
    }

}
