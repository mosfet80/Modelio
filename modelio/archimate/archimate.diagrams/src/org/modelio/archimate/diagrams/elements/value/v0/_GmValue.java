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
package org.modelio.archimate.diagrams.elements.value.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.value.GmValueImageStyleKeys;
import org.modelio.archimate.diagrams.elements.value.GmValueSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.value.GmValueStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.value.GmValueUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.motivation.Value;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Value}.
 */
@objid ("cdc4ee2d-7ace-4c48-aa38-6ad57aeca499")
public class _GmValue extends GmArchiElement<Value> {
    @objid ("80ea220b-4c87-4e87-a874-6d92ac7464a5")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("f81ad945-3e2f-4b7f-9fa8-732bf68f8b19")
    private static final int MINOR_VERSION = 0;

    @objid ("f92ea9da-a378-43a9-b87d-54b278653203")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmValueImageStyleKeys();

    @objid ("0618582c-ab49-4e90-8c83-9ae8f89ca505")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmValueSimpleStyleKeys();

    @objid ("48f8179f-3b6e-4270-ab5e-8b3565d34a37")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmValueStructuredStyleKeys();

    @objid ("f92ab4dd-764a-4ac8-846e-a25fc51f4ee3")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmValueUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Value is unmasked.
     * @param el the unmasked Value.
     * @param ref a reference to the unmasked Value.
     */
    @objid ("259274da-232a-4e07-9c84-af5426aedc57")
    public _GmValue(IGmDiagram diagram, Value el, MRef ref) {
        super(diagram, el, ref);
        this.header.setShowMetaclassIcon(false);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("9e8e79c6-707c-4308-b86f-8162d302f7c4")
    public _GmValue() {
        // Nothing specific to do.
    }

    @objid ("4ff4a6d9-9e38-4453-813c-71615114567e")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("756843ea-eaec-48ba-90e1-dddaf098ea5d")
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

    @objid ("f93f4f8c-aff4-4f94-bc60-1fedae805d1f")
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

    @objid ("cfb0bd0a-d94e-4850-acfb-6338aadf340f")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmValue.");
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

    @objid ("2ba6bf9d-ec9f-489c-afeb-6b8c3758b664")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmValue.", MINOR_VERSION);

    }

    @objid ("1393a19e-8e23-4eab-89f2-cdcce101fdfa")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
