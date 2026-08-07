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
package org.modelio.archimate.diagrams.elements.facility.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.facility.GmFacilityImageStyleKeys;
import org.modelio.archimate.diagrams.elements.facility.GmFacilitySimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.facility.GmFacilityStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.facility.GmFacilityUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.physical.structure.active.Facility;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Facility}.
 */
@objid ("53d2d162-4d06-4b57-817d-f8573fba6b41")
public class _GmFacility extends GmArchiElement<Facility> {
    @objid ("487db2ee-bc7e-4809-9932-9fbae6361ae6")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("34af39a4-9060-432b-a0b6-17e9a90cf5ca")
    private static final int MINOR_VERSION = 0;

    @objid ("c77f4143-93bc-4e73-93e1-80f44c35f58d")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmFacilityImageStyleKeys();

    @objid ("b94ba988-86c9-4587-8eb5-d44178687db7")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmFacilitySimpleStyleKeys();

    @objid ("07cfd94e-03a0-469b-b24b-eb64a3ab282c")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmFacilityStructuredStyleKeys();

    @objid ("ed480a4d-9b6b-49e0-bbcc-873eba3dce0d")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmFacilityUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Facility is unmasked.
     * @param el the unmasked Facility.
     * @param ref a reference to the unmasked Facility.
     */
    @objid ("e3e45370-c4ab-4f1b-953b-903223ee922c")
    public _GmFacility(IGmDiagram diagram, Facility el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("cb550743-3e6f-4345-95bd-4857c9997cbd")
    public _GmFacility() {
        // Nothing specific to do.
    }

    @objid ("7febd112-96cc-45bb-969a-4fe60a0b76d6")
    @Override
    public int getMajorVersion() {
        return _GmFacility.MAJOR_VERSION;
    }

    @objid ("e59a7582-0d61-463c-a6fc-440d10c73780")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmFacility.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmFacility.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmFacility.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmFacility.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmFacility.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("83573da5-776e-4197-8245-898f4c1fde20")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmFacility.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmFacility.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmFacility.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmFacility.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmFacility.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("0146e621-624f-4523-a7a7-494ca9b15c43")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmFacility.");
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

    @objid ("ced5c11e-233f-44a7-9c4c-d8968443d570")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmFacility.", _GmFacility.MINOR_VERSION);

    }

    @objid ("dda5d2c7-b547-4db9-bd6b-46d619cda7ab")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
