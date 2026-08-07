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
package org.modelio.archimate.diagrams.elements.viewpoint;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archiheader.GmArchiHeader;
import org.modelio.archimate.diagrams.plugin.ArchiDiagrams;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized header class for {@link ViewPoint}, displaying the owned diagram's count next to the ViewPoint's name.
 */
@objid ("1b3b7f14-2a8e-4da9-93c0-2508f2040ac3")
public class GmViewPointHeader extends GmArchiHeader {
    @objid ("ac0b61a6-74e5-4fb0-902a-5d89224e8b7e")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm. Defaults to 0.
     */
    @objid ("2c25bc87-ca4e-438a-86e1-7ec281d9395b")
    private static final int MINOR_VERSION = 0;

    @objid ("8aea074b-a22c-474e-949b-4b63f1feafc6")
    @Override
    public int getMajorVersion() {
        return GmViewPointHeader.MAJOR_VERSION;
    }

    @objid ("0829932a-26b7-452f-8c1a-4ecbbdba23c8")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmViewPointHeader.");
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

    @objid ("e74014df-0902-4165-a2a5-95ef63b6318c")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmViewPointHeader.", GmViewPointHeader.MINOR_VERSION);

    }

    @objid ("4c7b36f3-5555-4bae-b3c0-4feb1de596f8")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ViewPoint is unmasked.
     * @param ref a reference to the unmasked ViewPoint.
     */
    @objid ("e43a60c9-a1e1-47c9-80ca-036aa27fbe87")
    public GmViewPointHeader(IGmDiagram diagram, MRef ref) {
        super(diagram, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("48830912-4a77-4a59-9994-2aa72ea9b2f6")
    public GmViewPointHeader() {
        // Nothing specific to do.
    }

    @objid ("bc78b57b-5f32-4026-a4e7-25409ea62970")
    @Override
    public ViewPoint getRelatedElement() {
        return (ViewPoint) super.getRelatedElement();
    }

    @objid ("3d544e72-e122-4830-9f9d-2454ee63cb38")
    @Override
    public String getMainLabel() {
        String mainLabel = super.getMainLabel();

        ViewPoint relatedElement = getRelatedElement();
        if (relatedElement != null && relatedElement.isValid()) {
            return ArchiDiagrams.I18N.getMessage("GmViewPointHeader.mainlabel", mainLabel, relatedElement.getProduct().size());
        } else {
            return mainLabel;
        }

    }

}
