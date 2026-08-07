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
package org.modelio.archimate.diagrams.elements.meaning.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.meaning.GmMeaningImageStyleKeys;
import org.modelio.archimate.diagrams.elements.meaning.GmMeaningSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.meaning.GmMeaningStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.meaning.GmMeaningUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.motivation.Meaning;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Meaning}.
 */
@objid ("7bc08978-c04b-40c1-b6dd-88b058526f2a")
public class _GmMeaning extends GmArchiElement<Meaning> {
    @objid ("32076a7a-4b08-4b5d-bc68-1123f551c85c")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("b9874ad1-9649-44a8-8eb2-8b95289fd30f")
    private static final int MINOR_VERSION = 0;

    @objid ("01c2d6d1-e038-4875-8b27-ca61ac977536")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmMeaningImageStyleKeys();

    @objid ("1f8c78e3-c848-4ea7-8d60-bbbdff8ab596")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmMeaningSimpleStyleKeys();

    @objid ("49b0f658-19d7-4e4d-ae85-4d4e3f97479c")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmMeaningStructuredStyleKeys();

    @objid ("beabd28c-9200-4d3f-abff-c9954d393d92")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmMeaningUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Meaning is unmasked.
     * @param el the unmasked Meaning.
     * @param ref a reference to the unmasked Meaning.
     */
    @objid ("63f4013d-9814-441f-9956-105040d00dd5")
    public _GmMeaning(IGmDiagram diagram, Meaning el, MRef ref) {
        super(diagram, el, ref);
        this.header.setShowMetaclassIcon(false);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("658f5683-962a-452e-af5b-30b42703743a")
    public _GmMeaning() {
        // Nothing specific to do.
    }

    @objid ("6b76a93f-a5e6-4851-ab4c-30f4ff1d1e50")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("06624232-7292-411c-b0de-c9c22b83b536")
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

    @objid ("d23e2d36-7c86-4794-93a0-f2fb59d9967b")
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

    @objid ("bffd4ee9-73f6-4293-a3f3-5f21a625f9c7")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmMeaning.");
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

    @objid ("dce3bf6e-86a1-41e0-b8af-444c1d4fe8ea")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("7705190a-e84e-4fb4-adb7-7bdcf046805f")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmMeaning.", MINOR_VERSION);

    }

}
