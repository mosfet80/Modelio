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
package org.modelio.archimate.diagrams.elements.location.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.location.GmLocationImageStyleKeys;
import org.modelio.archimate.diagrams.elements.location.GmLocationSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.location.GmLocationStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.location.GmLocationUserImageStyleKeys;
import org.modelio.archimate.metamodel.core.generic.composite.Location;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Location}.
 */
@objid ("ca15876a-008a-4326-bd40-3bb79ca59f32")
public class _GmLocation extends GmArchiElement<Location> {
    @objid ("ceb520ba-830a-45c6-8cb3-3ea5fc0fdbe7")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("79f4bfff-d980-4143-830a-7a7d9770c9c0")
    private static final int MINOR_VERSION = 0;

    @objid ("4581c136-7c8e-4f33-aef3-185f51c82c33")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmLocationImageStyleKeys();

    @objid ("37dc6084-a733-46ef-834f-20bbb4afe581")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmLocationSimpleStyleKeys();

    @objid ("4f965ff5-ac57-4f2f-bb1f-3af6bce8e29a")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmLocationStructuredStyleKeys();

    @objid ("2e28133a-b98a-49d4-a6d9-b1445465eb41")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmLocationUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Location is unmasked.
     * @param el the unmasked Location.
     * @param ref a reference to the unmasked Location.
     */
    @objid ("ca3eff55-990c-4d64-b4b5-55d8bcf73b7c")
    public _GmLocation(IGmDiagram diagram, Location el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("b63b51ed-b493-442f-a204-d8ebf09b27fb")
    public _GmLocation() {
        // Nothing specific to do.
    }

    @objid ("1361d957-1556-4673-9f55-b093d1ad4511")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("e9253766-7dac-47a7-9c5f-56061678a8e9")
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

    @objid ("73fe022a-1141-4aae-99f3-412fa7be26c3")
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

    @objid ("d35fd59e-452a-44e3-80b6-da35f48ba555")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmLocation.");
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

    @objid ("b73f2171-2f7c-44b6-8ffc-b648e1183b9e")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmLocation.", MINOR_VERSION);

    }

    @objid ("224446e5-7199-4f0b-b25f-469f891b5807")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
