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
package org.modelio.archimate.diagrams.elements.stakeholder.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.stakeholder.GmStakeholderImageStyleKeys;
import org.modelio.archimate.diagrams.elements.stakeholder.GmStakeholderSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.stakeholder.GmStakeholderStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.stakeholder.GmStakeholderUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.motivation.Stakeholder;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Stakeholder}.
 */
@objid ("a6c572ae-eafe-415f-a8c0-ca19d9bd7b22")
public class _GmStakeholder extends GmArchiElement<Stakeholder> {
    @objid ("52d45aff-f553-45ce-ae64-b8c7bda0a980")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("73634074-fae1-4e9f-834e-4d0d5ab7bc23")
    private static final int MINOR_VERSION = 0;

    @objid ("4e6c90a5-e525-4d1c-99c4-e002c1ea9a65")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmStakeholderImageStyleKeys();

    @objid ("038315f6-b609-4bb1-bcc5-af8532d24333")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmStakeholderSimpleStyleKeys();

    @objid ("abb989cf-cdaf-4a08-bcc5-94a9ed7ae54d")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmStakeholderStructuredStyleKeys();

    @objid ("af1f5b19-f83f-4c73-84b2-47b7255dae57")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmStakeholderUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Stakeholder is unmasked.
     * @param el the unmasked Stakeholder.
     * @param ref a reference to the unmasked Stakeholder.
     */
    @objid ("30776288-f902-4f90-a1cd-b55cf53cf172")
    public _GmStakeholder(IGmDiagram diagram, Stakeholder el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("4e6e722a-e1d7-4e5d-b01e-097e2d87d942")
    public _GmStakeholder() {
        // Nothing specific to do.
    }

    @objid ("e098337f-4e09-4fae-820c-dc4301a09ee9")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("01489754-5871-4bc0-84ef-9d89413b6926")
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

    @objid ("05d3e0c8-31cb-42c7-8b93-8f9ad84c4dbe")
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

    @objid ("99c9b1f4-5cea-4973-abe1-197245e7dbbd")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmStakeholder.");
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

    @objid ("995d2719-1475-4d41-a668-587ea9993ffc")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmStakeholder.", MINOR_VERSION);

    }

    @objid ("9533b62f-f479-4eb0-b16e-34abeb66527e")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
