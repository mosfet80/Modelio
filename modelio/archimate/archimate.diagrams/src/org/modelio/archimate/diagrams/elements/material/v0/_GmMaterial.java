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
package org.modelio.archimate.diagrams.elements.material.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.material.GmMaterialImageStyleKeys;
import org.modelio.archimate.diagrams.elements.material.GmMaterialSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.material.GmMaterialStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.material.GmMaterialUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.physical.structure.passive.Material;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Material}.
 */
@objid ("0bd7178d-b326-4f1d-9707-30f87b220a23")
public class _GmMaterial extends GmArchiElement<Material> {
    @objid ("09ef84b0-fbc1-4696-b745-a3c2d8d7bcd5")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("bb92368f-5c52-46e7-8782-99b4c2cfa8ab")
    private static final int MINOR_VERSION = 0;

    @objid ("6af1f030-f2da-4ab3-9145-a5b119857a14")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmMaterialImageStyleKeys();

    @objid ("d05ace05-6b92-4b31-b49f-12e0248a4325")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmMaterialSimpleStyleKeys();

    @objid ("435ba02f-d8dc-4517-8b77-7f199fe36cbd")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmMaterialStructuredStyleKeys();

    @objid ("bfa026b1-7bf6-4e8a-bb19-e757ce0ab972")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmMaterialUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Material is unmasked.
     * @param el the unmasked Material.
     * @param ref a reference to the unmasked Material.
     */
    @objid ("dcac1d04-ef51-4c1e-9a08-14f0665f7609")
    public _GmMaterial(IGmDiagram diagram, Material el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("a901216b-61a4-4156-b3f8-b1e63e57ff80")
    public _GmMaterial() {
        // Nothing specific to do.
    }

    @objid ("ed2c3136-69cd-40d2-9068-6565cd4f100c")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("27eaa96e-78c1-40ef-b2a2-a1232a56a0e0")
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

    @objid ("7dd8ed1d-9760-4dcb-bba1-82e1c0fe95f6")
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

    @objid ("cce6913e-e476-4cec-8e9c-cc4c2a6600cf")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmMaterial.");
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

    @objid ("cb0083b3-ad1f-4c66-8101-869172c9ae47")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmMaterial.", MINOR_VERSION);

    }

    @objid ("7604796a-5fd3-4f4d-b087-4091af3454c6")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
