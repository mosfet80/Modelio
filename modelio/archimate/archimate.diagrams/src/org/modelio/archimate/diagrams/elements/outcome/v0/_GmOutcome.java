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
package org.modelio.archimate.diagrams.elements.outcome.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.outcome.GmOutcomeImageStyleKeys;
import org.modelio.archimate.diagrams.elements.outcome.GmOutcomeSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.outcome.GmOutcomeStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.outcome.GmOutcomeUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.motivation.Outcome;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Outcome}.
 */
@objid ("5f8dac3b-c3ed-4213-bbe4-6e3251ce6e5f")
public class _GmOutcome extends GmArchiElement<Outcome> {
    @objid ("6ca0d32f-0237-4b00-975d-b1e18e34fc90")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("3d271ec0-17f6-4475-82dc-afa323b94bb5")
    private static final int MINOR_VERSION = 0;

    @objid ("3a257b8c-1eff-4028-8a20-724c35b7373c")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmOutcomeImageStyleKeys();

    @objid ("d4260f4b-f718-437e-8054-99c15489eae0")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmOutcomeSimpleStyleKeys();

    @objid ("e24b7b04-502c-4970-a807-e2902ec0451b")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmOutcomeStructuredStyleKeys();

    @objid ("15e4cf9a-ba1f-4048-8fcd-510ae1bffa7d")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmOutcomeUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Outcome is unmasked.
     * @param el the unmasked Outcome.
     * @param ref a reference to the unmasked Outcome.
     */
    @objid ("79d68a48-591f-423f-af16-6479244d4a59")
    public _GmOutcome(IGmDiagram diagram, Outcome el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("984e680a-f12e-4eff-8aac-fcb5ac37e05f")
    public _GmOutcome() {
        // Nothing specific to do.
    }

    @objid ("ecef39a2-7407-4b8b-8273-02ef1db6704f")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("535060ac-dad9-4605-b9dc-8bce1211ca68")
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

    @objid ("bb2e2322-1c93-4515-831b-2fa5596cc8d7")
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

    @objid ("607c1c90-2dba-4c8d-8613-dbd1c55b1e97")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmOutcome.");
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

    @objid ("de6d94ae-8722-477b-bdf3-8f9531c62699")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmOutcome.", MINOR_VERSION);

    }

    @objid ("038be172-bb57-456f-a254-14f32b27bcf4")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
