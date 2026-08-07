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
package org.modelio.archimate.diagrams.elements.systemsoftware.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.systemsoftware.GmSystemSoftwareImageStyleKeys;
import org.modelio.archimate.diagrams.elements.systemsoftware.GmSystemSoftwareSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.systemsoftware.GmSystemSoftwareStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.systemsoftware.GmSystemSoftwareUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.technology.structure.active.SystemSoftware;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link SystemSoftware}.
 */
@objid ("72999da3-fa9b-456f-9954-9ca152befd2b")
public class _GmSystemSoftware extends GmArchiElement<SystemSoftware> {
    @objid ("5f187677-bd24-4267-be10-c3f5e28653f9")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("6ae76262-4aef-434a-a23a-ef030c9a9e30")
    private static final int MINOR_VERSION = 0;

    @objid ("e44a4411-2884-423d-a5d8-baecedb6f81c")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmSystemSoftwareImageStyleKeys();

    @objid ("886443d9-857f-4c10-80d5-6112a5d22dd1")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmSystemSoftwareSimpleStyleKeys();

    @objid ("a3534557-a294-4535-a75f-292bd4305add")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmSystemSoftwareStructuredStyleKeys();

    @objid ("6d69c0ab-87f3-4543-9f99-7dcb72faa852")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmSystemSoftwareUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the SystemSoftware is unmasked.
     * @param el the unmasked SystemSoftware.
     * @param ref a reference to the unmasked SystemSoftware.
     */
    @objid ("c6396682-a7dc-45b6-aebb-cdd0b151eeff")
    public _GmSystemSoftware(IGmDiagram diagram, SystemSoftware el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("aeb0b61d-c915-406c-92cc-23ee6d7cfa71")
    public _GmSystemSoftware() {
        // Nothing specific to do.
    }

    @objid ("62bb5294-8c8e-458d-b70b-06758f547a03")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("54420998-0d7d-4485-8cd6-5a862d2d14e1")
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

    @objid ("3c428580-daa9-4ffb-b6a9-cf7542ea2013")
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

    @objid ("9f8bc569-5c94-4035-89f3-7f2a773318ee")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmSystemSoftware.");
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

    @objid ("65153f04-54c5-4d30-8d28-56179bbce8ab")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmSystemSoftware.", MINOR_VERSION);

    }

    @objid ("a25ecb41-00e5-4db3-9126-778bc04f40fd")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
