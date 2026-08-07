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
package org.modelio.archimate.diagrams.elements.capability.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.capability.GmCapabilityImageStyleKeys;
import org.modelio.archimate.diagrams.elements.capability.GmCapabilitySimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.capability.GmCapabilityStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.capability.GmCapabilityUserImageStyleKeys;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.metamodel.layers.strategy.behavior.Capability;
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
 * Specialized class for {@link Capability}.
 */
@objid ("15e82d80-9974-47ba-b36d-aed9fcafb484")
public class _GmCapability extends GmArchiElement<Capability> {
    @objid ("8fa449ba-519a-4b50-9e1a-f577a32ed9b2")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("6f6fdb01-5a65-4e62-8780-cee46e333029")
    private static final int MINOR_VERSION = 0;

    @objid ("1619b3a5-f74c-46ac-9502-9b9d0ff1aada")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmCapabilityImageStyleKeys();

    @objid ("51232461-e18c-4b28-adce-38112892ce1c")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmCapabilitySimpleStyleKeys();

    @objid ("f096f386-20b1-4e60-a595-2fcb0a9adf8e")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmCapabilityStructuredStyleKeys();

    @objid ("c86460cf-2a5d-4956-88d6-30a555f23c2a")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmCapabilityUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Capability is unmasked.
     * @param el the unmasked Capability.
     * @param ref a reference to the unmasked Capability.
     */
    @objid ("75d0b601-a34f-4dfd-a824-61f3301fb339")
    public _GmCapability(IGmDiagram diagram, Capability el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("9ae96403-5764-4e1d-b666-0d90549d4542")
    public _GmCapability() {
        // Nothing specific to do.
    }

    @objid ("cca14c82-0efb-45e1-a69f-218e14dd52e2")
    @Override
    public int getMajorVersion() {
        return _GmCapability.MAJOR_VERSION;
    }

    @objid ("b58b8125-ace0-4868-ae50-ea070d18d5c9")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmCapability.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmCapability.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmCapability.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmCapability.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmCapability.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("f4cb71e3-fee3-42d5-9066-a23d487e3b23")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmCapability.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmCapability.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmCapability.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmCapability.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmCapability.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("575e32ba-7972-402c-bfcc-ba84fcb1383f")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmCapability.");
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

    @objid ("ca873d18-7b34-47e2-972e-47568267396e")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmCapability.", _GmCapability.MINOR_VERSION);

    }

    @objid ("a39290a4-b5ef-45dc-a23c-a2b24589a345")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
