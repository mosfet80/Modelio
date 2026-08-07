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
package org.modelio.archimate.diagrams.elements.equipment.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.equipment.GmEquipmentImageStyleKeys;
import org.modelio.archimate.diagrams.elements.equipment.GmEquipmentSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.equipment.GmEquipmentStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.equipment.GmEquipmentUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.physical.structure.active.Equipment;
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
 * Specialized class for {@link Equipment}.
 */
@objid ("4e66512c-7468-47e0-ad67-8b667ec6c80b")
public class _GmEquipment extends GmArchiElement<Equipment> {
    @objid ("f2e747ff-7dfd-4b62-8950-a6312d95d8fe")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("306a0ff4-cab1-4baf-949e-ba96081fd726")
    private static final int MINOR_VERSION = 0;

    @objid ("68596fb7-077b-4655-87df-78cce8744baa")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmEquipmentImageStyleKeys();

    @objid ("d5981aa0-0fc6-4123-ad77-884f66bdee4c")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmEquipmentSimpleStyleKeys();

    @objid ("96e6882b-3873-4807-a5e3-c237269f3074")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmEquipmentStructuredStyleKeys();

    @objid ("9638c51a-cfa6-4bad-8354-6a2ede18cf5a")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmEquipmentUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Equipment is unmasked.
     * @param el the unmasked Equipment.
     * @param ref a reference to the unmasked Equipment.
     */
    @objid ("a71eadfc-bae1-478a-a5da-4d2956bb1337")
    public _GmEquipment(IGmDiagram diagram, Equipment el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("74ad29c5-2670-4daa-9869-a5c412c7de54")
    public _GmEquipment() {
        // Nothing specific to do.
    }

    @objid ("5bdb1a44-d42c-4870-ab24-38ad8f080f72")
    @Override
    public int getMajorVersion() {
        return _GmEquipment.MAJOR_VERSION;
    }

    @objid ("a817baa3-f4b0-4ef9-b69f-4ef8948e3f35")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmEquipment.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmEquipment.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmEquipment.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmEquipment.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmEquipment.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("5470c425-69a5-4823-ab18-ae2df99e7b24")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmEquipment.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmEquipment.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmEquipment.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmEquipment.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmEquipment.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("64c56a70-5bc9-41a7-aa31-8805fc5e67cd")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmEquipment.");
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

    @objid ("43ede2cd-f12d-4912-8a09-7f54a9e49666")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmEquipment.", _GmEquipment.MINOR_VERSION);

    }

    @objid ("68c77d9d-115b-4a88-9440-01f60d0a4cf7")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
