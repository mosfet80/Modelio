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
package org.modelio.archimate.diagrams.elements.product.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.product.GmProductImageStyleKeys;
import org.modelio.archimate.diagrams.elements.product.GmProductSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.product.GmProductStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.product.GmProductUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.business.composite.Product;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Product}.
 */
@objid ("d090e353-3b5e-4b0d-bc22-0131d17e9a8e")
public class _GmProduct extends GmArchiElement<Product> {
    @objid ("1288cca1-3b89-4e6e-b344-af176008e1c5")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("054428eb-cae7-40f1-aa60-a6d1c5c3e89d")
    private static final int MINOR_VERSION = 0;

    @objid ("953348a0-220a-468b-9efd-bd58be17d9a0")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmProductImageStyleKeys();

    @objid ("7131f435-1e08-497f-b3fa-bbea39162e96")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmProductSimpleStyleKeys();

    @objid ("9af6d737-95e0-48cc-81bf-f74cb8094db6")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmProductStructuredStyleKeys();

    @objid ("369f500f-3106-463f-ad54-27fa5e51533f")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmProductUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Product is unmasked.
     * @param el the unmasked Product.
     * @param ref a reference to the unmasked Product.
     */
    @objid ("8ff94b5b-a1f6-44fd-bba8-ff234070c6f6")
    public _GmProduct(IGmDiagram diagram, Product el, MRef ref) {
        super(diagram, el, ref);
        this.header.setShowMetaclassIcon(false);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("dcc9398e-18c4-4970-97f8-5c6760f23443")
    public _GmProduct() {
        // Nothing specific to do.
    }

    @objid ("3abb4360-c1a9-4e5e-a5b7-3d7a3640d3b3")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("3786e632-f923-407a-aef7-4894d9cb7b31")
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

    @objid ("64dfac98-9391-43b4-a12c-c0ec2c35f942")
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

    @objid ("81607804-7f28-4b99-9994-f64cf0871505")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmProduct.");
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

    @objid ("ee5ecbfc-4a80-4e7a-b49e-e9c238fa9687")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmProduct.", MINOR_VERSION);

    }

    @objid ("6dacf7ce-a750-4d1a-8a45-a8191c35ad82")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
