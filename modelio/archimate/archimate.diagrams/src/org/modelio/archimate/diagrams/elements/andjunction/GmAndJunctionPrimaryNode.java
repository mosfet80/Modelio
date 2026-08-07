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
package org.modelio.archimate.diagrams.elements.andjunction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.relationships.other.AndJunction;
import org.modelio.diagram.elements.core.model.IEditableText;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNoStyleSimpleNode;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Represents an {@link AndJunction}.
 */
@objid ("5332311f-0b04-40aa-a208-ae234111474b")
public final class GmAndJunctionPrimaryNode extends GmNoStyleSimpleNode {
    @objid ("34971c74-676b-4710-8a53-67b4133439a2")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm. Defaults to 0.
     */
    @objid ("2d017b96-51b8-499e-8257-8f36ff2f99b8")
    private static final int MINOR_VERSION = 0;

    /**
     * Create an {@link AndJunction} graphic node.
     *
     * @param diagram The diagram
     * @param relatedRef The related element reference, may not be null.
     */
    @objid ("a1a60bea-c42c-461c-a8d5-a148968e3d9a")
    public GmAndJunctionPrimaryNode(IGmDiagram diagram, MRef relatedRef) {
        super(diagram, relatedRef);
    }

    /**
     * Constructor for deserialization only.
     */
    @objid ("86111278-cf16-4029-baf3-df7bf39a4137")
    public GmAndJunctionPrimaryNode() {
        // for the serialization
    }

    @objid ("5efa2cb2-1f0f-4b16-ae96-aab347e34c4f")
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

    @objid ("5d608453-60e3-470c-9f4f-3f5d75ebee5f")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("4e2f2b28-eee0-47d6-a685-e4101272fc6b")
    @Override
    public AndJunction getRelatedElement() {
        return (AndJunction) super.getRelatedElement();
    }

    /**
     * AndJunction is always in simple mode.
     */
    @objid ("29707c11-5d5c-4065-8f2e-b872efbab0ff")
    @Override
    public RepresentationMode getRepresentationMode() {
        return RepresentationMode.SIMPLE;
    }

    @objid ("eb054874-795a-444d-8e80-72b27c043a38")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmAndJunctionPrimaryNode.");
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

    @objid ("376483e7-9525-45f6-b737-a78b412b8b61")
    @Override
    public void refreshFromObModel() {
        if (getRelatedElement() != null) {
            firePropertyChange(PROPERTY_LABEL, null, getRelatedElement().getName());
        }
        // forcing visual refresh in case Image changed
        firePropertyChange(PROPERTY_LAYOUTDATA, null, getLayoutData());

    }

    @objid ("35d4c043-daac-4091-b69d-937608440017")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmAndJunctionPrimaryNode.", MINOR_VERSION);

    }

    @objid ("11f93dc1-11bc-44f2-97e3-474c938c60a6")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
