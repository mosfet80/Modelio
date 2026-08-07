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
package org.modelio.archimate.diagrams.elements.orjunction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.relationships.other.OrJunction;
import org.modelio.diagram.elements.core.model.IEditableText;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNoStyleSimpleNode;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Represents an {@link OrJunction}.
 */
@objid ("d7d83c36-7f6d-49fa-ab88-2577eb41a5d1")
public final class GmOrJunctionPrimaryNode extends GmNoStyleSimpleNode {
    @objid ("194b5418-ed60-4aa5-a2be-2f34f3775fc7")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm. Defaults to 0.
     */
    @objid ("fe62d728-321e-4ef2-bdc1-26c22c29d510")
    private static final int MINOR_VERSION = 0;

    /**
     * Create an {@link OrJunction} graphic node.
     *
     * @param diagram The diagram
     * @param relatedRef The related element reference, may not be null.
     */
    @objid ("0f95e3f6-529c-4115-9fef-6715bcbc272e")
    public GmOrJunctionPrimaryNode(IGmDiagram diagram, MRef relatedRef) {
        super(diagram, relatedRef);
    }

    /**
     * Constructor for deserialization only.
     */
    @objid ("12019508-a0f9-4c43-967c-c0d302b18baf")
    public GmOrJunctionPrimaryNode() {
        // for the serialization
    }

    @objid ("79bcc46c-d79e-4a90-81df-9e9f5585739e")
    @Override
    public IEditableText getEditableText() {
        return new IEditableText() {
                    @Override
                    public String getText() {
                        return getRelatedElement().getName();
                    }

                    @Override
                    public void setText(String text) {
                        getRelatedElement().setName(text);
                    }

                };
    }

    @objid ("de685c92-1b18-4ebc-9b26-8037eef9a45b")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("d9e63d12-925b-4ab4-b58c-e1fb81f19d49")
    @Override
    public OrJunction getRelatedElement() {
        return (OrJunction) super.getRelatedElement();
    }

    /**
     * OrJunction is always in simple mode.
     */
    @objid ("5610142e-9573-4264-876e-1c01b288f43e")
    @Override
    public RepresentationMode getRepresentationMode() {
        return RepresentationMode.SIMPLE;
    }

    @objid ("04dda0de-7cf9-44bc-9279-3d076f7d7aa9")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmOrJunctionPrimaryNode.");
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

    @objid ("a06931a3-db28-438e-bb5d-cfc5b841dbaa")
    @Override
    public void refreshFromObModel() {
        if (getRelatedElement() != null) {
            firePropertyChange(PROPERTY_LABEL, null, getRelatedElement().getName());
        }
        // forcing visual refresh in case Image changed
        firePropertyChange(PROPERTY_LAYOUTDATA, null, getLayoutData());

    }

    @objid ("91ff7588-5edf-4aac-8a69-d10291fd22b3")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmOrJunctionPrimaryNode.", MINOR_VERSION);

    }

    @objid ("1f9c6fe2-8609-47cb-86cf-12e0f3081454")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
