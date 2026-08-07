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
package org.modelio.archimate.diagrams.elements.requirement.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.requirement.GmRequirementImageStyleKeys;
import org.modelio.archimate.diagrams.elements.requirement.GmRequirementSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.requirement.GmRequirementStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.requirement.GmRequirementUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.motivation.Requirement;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Requirement}.
 */
@objid ("8f9e4a47-6ec2-4404-927e-f5f9391ef64c")
public class _GmRequirement extends GmArchiElement<Requirement> {
    @objid ("3c3af247-a0e3-46f3-8451-10273ab443aa")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("2ae5e368-3c82-42ef-b0eb-c139a27f7ee9")
    private static final int MINOR_VERSION = 0;

    @objid ("127b2ee9-27ea-4490-b961-0718d1d4b2fc")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmRequirementImageStyleKeys();

    @objid ("e45b675e-3d48-4166-90f2-39ed97c8503d")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmRequirementSimpleStyleKeys();

    @objid ("d39a6b89-5c00-4d01-98b8-887f53a5bd9f")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmRequirementStructuredStyleKeys();

    @objid ("5e11837f-ff9b-49c8-8887-458459903734")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmRequirementUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Requirement is unmasked.
     * @param el the unmasked Requirement.
     * @param ref a reference to the unmasked Requirement.
     */
    @objid ("b80528e6-37f9-4e17-9191-135c38ba2b40")
    public _GmRequirement(IGmDiagram diagram, Requirement el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("10ae02b9-f824-4001-858b-f4a39d3978e6")
    public _GmRequirement() {
        // Nothing specific to do.
    }

    @objid ("38441b82-f4e1-467f-aa7a-bef8653aa534")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("e1478603-be46-44d8-a3f4-52bd1e0c68fb")
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

    @objid ("1303e199-6b38-4e4d-a462-35bf20298961")
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

    @objid ("3cd8bc0c-ca4a-4ce5-b65d-324adaf06bb6")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmRequirement.");
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

    @objid ("f8ec54f9-8e20-495a-ae8a-1a40a64a4154")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmRequirement.", MINOR_VERSION);

    }

    @objid ("e1f6c1bd-a3c2-4ca2-b47c-2e8ac78fbd05")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
