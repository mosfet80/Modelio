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
package org.modelio.archimate.diagrams.elements.representation.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.representation.GmRepresentationImageStyleKeys;
import org.modelio.archimate.diagrams.elements.representation.GmRepresentationSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.representation.GmRepresentationStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.representation.GmRepresentationUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.business.structure.passive.Representation;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Representation}.
 */
@objid ("1af2ec82-d557-4340-ad99-b45182762b84")
public class _GmRepresentation extends GmArchiElement<Representation> {
    @objid ("bbdc294e-272a-48a0-baa3-a386d0eadb85")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("b1887a00-c3e8-4593-bd9b-dbf3c21da80e")
    private static final int MINOR_VERSION = 0;

    @objid ("205fc1e7-4cfe-44d2-9fed-587532efd77c")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmRepresentationImageStyleKeys();

    @objid ("fe2a04ec-85b7-4683-927b-f940d667abb3")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmRepresentationSimpleStyleKeys();

    @objid ("6a8691b9-cb40-4d2c-9aba-9963ea093ade")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmRepresentationStructuredStyleKeys();

    @objid ("5d25d881-3862-48b2-8f55-28d4c6d99b8a")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmRepresentationUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Representation is unmasked.
     * @param el the unmasked Representation.
     * @param ref a reference to the unmasked Representation.
     */
    @objid ("85f1be43-51e4-4dab-8f13-d1071883e5ae")
    public _GmRepresentation(IGmDiagram diagram, Representation el, MRef ref) {
        super(diagram, el, ref);
        this.header.setShowMetaclassIcon(false);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("6ba9ec4c-fad7-4b98-a464-a4b17f38700b")
    public _GmRepresentation() {
        // Nothing specific to do.
    }

    @objid ("48d391c4-ed26-46e7-a3e1-ce88433f6851")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("97793248-9303-42bc-9911-2b295e804c32")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("c3a9c664-e85e-4be8-8ff4-e1061184fb9d")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("1baa2482-4cac-4d42-8d50-ef605e476824")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmRepresentation.");
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

    @objid ("77eeca72-b005-4a93-b2db-94788b43c2ab")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmRepresentation.", MINOR_VERSION);

    }

    @objid ("768d44d4-2123-43bd-b0be-2d54c05127b0")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
