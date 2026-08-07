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
package org.modelio.archimate.diagrams.elements.grouping.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.grouping.GmGroupingImageStyleKeys;
import org.modelio.archimate.diagrams.elements.grouping.GmGroupingSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.grouping.GmGroupingStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.grouping.GmGroupingUserImageStyleKeys;
import org.modelio.archimate.metamodel.core.generic.composite.Grouping;
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
 * Specialized class for {@link Grouping}.
 */
@objid ("390e63ec-ffb7-4e38-8b4d-a8474cdd7667")
public class _GmGrouping extends GmArchiElement<Grouping> {
    @objid ("5e860d35-4a38-41a4-a76d-c2bf1ea63dc0")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("3b8e26c5-42f5-4f7f-8add-2900f2cf28e9")
    private static final int MINOR_VERSION = 0;

    @objid ("7c8c04d0-ce15-4d95-a9d7-011444e02824")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmGroupingImageStyleKeys();

    @objid ("a2d007c4-67d6-4e50-a37e-bd297fa7822e")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmGroupingSimpleStyleKeys();

    @objid ("3dca3203-b5e0-4c11-9413-e06603d7435c")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmGroupingStructuredStyleKeys();

    @objid ("15aa9a6d-579b-4295-beb0-5253f7d43e54")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmGroupingUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Grouping is unmasked.
     * @param el the unmasked Grouping.
     * @param ref a reference to the unmasked Grouping.
     */
    @objid ("231dea98-931d-43f0-ac46-14c50687d721")
    public _GmGrouping(IGmDiagram diagram, Grouping el, MRef ref) {
        super(diagram, el, ref);
        this.header.setShowMetaclassIcon(false);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("1da83693-346f-4472-ba21-ad1e1bd0093a")
    public _GmGrouping() {
        // Nothing specific to do.
    }

    @objid ("166dc44b-2a9d-4f71-a4b7-520f2e23b45b")
    @Override
    public int getMajorVersion() {
        return _GmGrouping.MAJOR_VERSION;
    }

    @objid ("2c4391fb-c3bf-40fc-bfb8-b2e45dec2c5c")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmGrouping.");
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

    @objid ("c5a9c773-9b04-4dba-a01c-4d0dafc4886d")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmGrouping.", _GmGrouping.MINOR_VERSION);

    }

    @objid ("816683ca-a1f2-4c2c-aabd-7d356a3cb3e9")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("6144d1bd-c383-44d0-9ee9-5dd75ea9f868")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmGrouping.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmGrouping.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmGrouping.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmGrouping.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmGrouping.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("c8363b43-4701-4c51-9191-53185bf0e4c1")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmGrouping.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmGrouping.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmGrouping.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmGrouping.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmGrouping.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

}
