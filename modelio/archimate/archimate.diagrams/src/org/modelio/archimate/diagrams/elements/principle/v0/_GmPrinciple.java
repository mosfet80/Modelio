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
package org.modelio.archimate.diagrams.elements.principle.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.principle.GmPrincipleImageStyleKeys;
import org.modelio.archimate.diagrams.elements.principle.GmPrincipleSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.principle.GmPrincipleStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.principle.GmPrincipleUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.motivation.Principle;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Principle}.
 */
@objid ("62fbc5f2-6e9d-4d71-8a8e-2b55738893f3")
public class _GmPrinciple extends GmArchiElement<Principle> {
    @objid ("ad4ff99c-5e9c-4136-a07c-60c4e580e721")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("908d8fec-f26a-437e-8b83-4e0e29f55fce")
    private static final int MINOR_VERSION = 0;

    @objid ("aa70f722-2279-4259-821e-b3ccd4e80ea1")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmPrincipleImageStyleKeys();

    @objid ("efc668f0-2cc8-471f-bb18-f25743f34644")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmPrincipleSimpleStyleKeys();

    @objid ("2601e46e-284f-4cab-9149-d2d6127eb155")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmPrincipleStructuredStyleKeys();

    @objid ("1a44f5fe-0fdd-4894-8247-279c49ad4379")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmPrincipleUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Principle is unmasked.
     * @param el the unmasked Principle.
     * @param ref a reference to the unmasked Principle.
     */
    @objid ("55036df5-1488-4221-bfe3-2cc3e012f241")
    public _GmPrinciple(IGmDiagram diagram, Principle el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("0a2e75ed-1f89-481c-a6bc-f3c5267acb1b")
    public _GmPrinciple() {
        // Nothing specific to do.
    }

    @objid ("8ea860ac-1631-4b83-a0c3-8f0b24d1b8fa")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("6ad94188-3334-4e11-914c-a761f69aadbc")
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

    @objid ("02958f89-2a4c-4dc9-8eea-5b2ef153f68f")
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

    @objid ("6d89fee2-9cab-470b-9080-745d65c49150")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmPrinciple.");
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

    @objid ("8cf96c19-59bf-4db0-8071-59438223948e")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("9372354f-b470-4471-9672-101eb6086a3d")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmPrinciple.", MINOR_VERSION);

    }

}
