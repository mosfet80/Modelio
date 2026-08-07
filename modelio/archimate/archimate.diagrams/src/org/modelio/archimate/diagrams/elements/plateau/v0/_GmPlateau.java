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
package org.modelio.archimate.diagrams.elements.plateau.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.plateau.GmPlateauImageStyleKeys;
import org.modelio.archimate.diagrams.elements.plateau.GmPlateauSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.plateau.GmPlateauStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.plateau.GmPlateauUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.Plateau;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Plateau}.
 */
@objid ("9d26c79a-41b4-4d17-bd0a-8b8b30736d7a")
public class _GmPlateau extends GmArchiElement<Plateau> {
    @objid ("66ebd113-233e-4157-8749-d286e592106b")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("1e947839-9fbf-4088-b0cc-9b35b016ae3e")
    private static final int MINOR_VERSION = 0;

    @objid ("c3f50cf3-a949-4629-b28a-a97334f52173")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmPlateauImageStyleKeys();

    @objid ("23fb312e-4780-4c9b-b30a-ef0939be184d")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmPlateauSimpleStyleKeys();

    @objid ("6e8815c8-f70e-4bec-84f3-6f4e9540b911")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmPlateauStructuredStyleKeys();

    @objid ("f283ccb6-fcf1-4211-bec7-a497b66f2a04")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmPlateauUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Plateau is unmasked.
     * @param el the unmasked Plateau.
     * @param ref a reference to the unmasked Plateau.
     */
    @objid ("2dce1b8a-4d97-4d7d-8809-07d88ce894b5")
    public _GmPlateau(IGmDiagram diagram, Plateau el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("82d8705b-edd4-4f01-8fa5-ec76ab8eed56")
    public _GmPlateau() {
        // Nothing specific to do.
    }

    @objid ("07bca155-d3fe-4ca2-8652-bf0d97286be7")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("4ca96b22-66da-49b1-966f-864aecf8a1ae")
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

    @objid ("ec37cdd1-b0f6-4ae5-a6fb-0c2ab161d4c8")
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

    @objid ("80a3f7b0-0217-4bc4-92b9-341f34972130")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmPlateau.");
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

    @objid ("ef6343fb-3646-4164-a652-a8849fd55b4c")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmPlateau.", MINOR_VERSION);

    }

    @objid ("659878e6-2efb-45b2-9fe8-488a3970e887")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
