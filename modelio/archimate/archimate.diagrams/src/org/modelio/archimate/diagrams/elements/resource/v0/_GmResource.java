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
package org.modelio.archimate.diagrams.elements.resource.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.resource.GmResourceImageStyleKeys;
import org.modelio.archimate.diagrams.elements.resource.GmResourceSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.resource.GmResourceStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.resource.GmResourceUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.strategy.structure.Resource;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Resource}.
 */
@objid ("36d11580-8578-4cae-8b9f-8b9f1f958a27")
public class _GmResource extends GmArchiElement<Resource> {
    @objid ("46f5849e-33f3-4d16-b4e2-f79befdf3944")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("b2f354e2-a86b-4b37-9f6a-117ea5a1aec2")
    private static final int MINOR_VERSION = 0;

    @objid ("8530e9c5-484d-4bdd-8877-7bd1d3e65548")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmResourceImageStyleKeys();

    @objid ("ff368eb2-b4fb-476a-9fa6-3b2c6d50ab07")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmResourceSimpleStyleKeys();

    @objid ("45b9bfed-dee6-4c65-91eb-d455cfcaf582")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmResourceStructuredStyleKeys();

    @objid ("0b03427c-095f-4139-bd05-c8a6ae118c4f")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmResourceUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Resource is unmasked.
     * @param el the unmasked Resource.
     * @param ref a reference to the unmasked Resource.
     */
    @objid ("30d54837-0dd7-49bd-9c7e-e5f9b2b67f14")
    public _GmResource(IGmDiagram diagram, Resource el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("b1b21fb8-8cb1-4172-85f4-3dd52778afa1")
    public _GmResource() {
        // Nothing specific to do.
    }

    @objid ("d6edcb80-47ce-4c5e-a2ae-b30efc6876d8")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("30c31d6d-789e-43d8-a8e5-1e3c8ad6efbd")
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

    @objid ("d0998b71-c1f9-4e2f-9c18-4593f0de7241")
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

    @objid ("05773de4-7b89-4b89-8339-52605afacf7a")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmResource.");
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

    @objid ("982fad57-39da-42dd-aeb0-1a52877d691a")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmResource.", MINOR_VERSION);

    }

    @objid ("42dc68c0-fa1f-4e35-ad08-9d6737cd6fa9")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
