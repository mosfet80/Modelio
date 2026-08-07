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
package org.modelio.archimate.diagrams.elements.gap.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.gap.GmGapImageStyleKeys;
import org.modelio.archimate.diagrams.elements.gap.GmGapSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.gap.GmGapStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.gap.GmGapUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.Gap;
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
 * Specialized class for {@link Gap}.
 */
@objid ("bd5ebdaa-6c5e-4252-a6ea-8fd53925a727")
public class _GmGap extends GmArchiElement<Gap> {
    @objid ("7b432984-39ed-403e-bc4d-5a84adfccc2c")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("4d61d1fd-df06-4c54-bb3e-60c90c3f5090")
    private static final int MINOR_VERSION = 0;

    @objid ("3d717116-7b6b-469a-a403-0d1b3b15961a")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmGapImageStyleKeys();

    @objid ("68d19ada-a103-4a92-ae8a-191161250019")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmGapSimpleStyleKeys();

    @objid ("37a06ca1-62d1-4ed5-8cf0-0d065917a475")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmGapStructuredStyleKeys();

    @objid ("ad120514-21bd-4224-9756-054e3ea545d8")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmGapUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Gap is unmasked.
     * @param el the unmasked Gap.
     * @param ref a reference to the unmasked Gap.
     */
    @objid ("df4f4247-87f0-4fca-8832-8e187bc16c9b")
    public _GmGap(IGmDiagram diagram, Gap el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("fab76caa-4c84-4a19-99a3-008d8e36175a")
    public _GmGap() {
        // Nothing specific to do.
    }

    @objid ("54bd0078-4c80-4012-9d80-8bc0440243c8")
    @Override
    public int getMajorVersion() {
        return _GmGap.MAJOR_VERSION;
    }

    @objid ("fd181992-830f-44ba-9810-af9d265e440c")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmGap.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmGap.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmGap.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmGap.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmGap.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("ed18caa2-a5bb-4ad1-a15f-42dc5892ef87")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmGap.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmGap.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmGap.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmGap.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmGap.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("6d064383-76c3-47d7-8f95-d8d505a2a9cd")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmGap.");
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

    @objid ("bd0091f3-4c2f-4749-b880-5668316de10a")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmGap.", _GmGap.MINOR_VERSION);

    }

    @objid ("b621e967-a7da-4962-9365-caf32431e814")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
