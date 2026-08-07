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
package org.modelio.archimate.diagrams.elements.dataobject.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.dataobject.GmDataObjectImageStyleKeys;
import org.modelio.archimate.diagrams.elements.dataobject.GmDataObjectSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.dataobject.GmDataObjectStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.dataobject.GmDataObjectUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.application.structure.passive.DataObject;
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
 * Specialized class for {@link DataObject}.
 */
@objid ("1fec1059-29b9-4bd3-9342-2234212d8acc")
public class _GmDataObject extends GmArchiElement<DataObject> {
    @objid ("7ef9b55d-473c-4a39-8d5e-acd7a7878261")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("638c1dee-44da-49f3-8ca2-f451096fe4d7")
    private static final int MINOR_VERSION = 0;

    @objid ("63b07e83-9c66-4df1-aeed-8954438ffa3c")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmDataObjectImageStyleKeys();

    @objid ("a81a4d68-2072-47be-a742-43de226cb844")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmDataObjectSimpleStyleKeys();

    @objid ("16ce17bc-5c35-4ebb-84a3-4eb716f351ff")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmDataObjectStructuredStyleKeys();

    @objid ("f5ab39a7-875d-4c82-9619-6826432eed5d")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmDataObjectUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the DataObject is unmasked.
     * @param el the unmasked DataObject.
     * @param ref a reference to the unmasked DataObject.
     */
    @objid ("dbb3ce84-fad8-40ad-9f67-1031b2f0ba0b")
    public _GmDataObject(IGmDiagram diagram, DataObject el, MRef ref) {
        super(diagram, el, ref);
        this.header.setShowMetaclassIcon(false);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("1c41dbf1-60ea-4f0a-87c2-afc03cbbd119")
    public _GmDataObject() {
        // Nothing specific to do.
    }

    @objid ("49561a82-3c2a-4b6d-bb12-d001b01aa65f")
    @Override
    public int getMajorVersion() {
        return _GmDataObject.MAJOR_VERSION;
    }

    @objid ("c1c1180b-6c0e-4900-869f-e0098eec1be3")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmDataObject.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmDataObject.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmDataObject.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmDataObject.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmDataObject.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("bd9cda88-a427-4cc7-ba81-6a07a094d4d2")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmDataObject.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmDataObject.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmDataObject.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmDataObject.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmDataObject.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("657173ac-71f6-4d88-819d-45cc005f307b")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmDataObject.");
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

    @objid ("b938807e-0387-403a-9680-53bfbee76740")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmDataObject.", _GmDataObject.MINOR_VERSION);

    }

    @objid ("d740e10a-c376-4846-9c9d-5f0965089792")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
