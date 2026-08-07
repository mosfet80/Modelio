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
package org.modelio.archimate.diagrams.elements.equipment;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.equipment.v0._GmEquipment;
import org.modelio.archimate.metamodel.layers.physical.structure.active.Equipment;
import org.modelio.diagram.elements.common.portcontainer.GmPortContainer;
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
@objid ("3e3b9fff-6a2a-438b-a225-f89547873ff1")
public class GmEquipment extends GmArchiElementPortContainer<Equipment> {
    @objid ("3482de0b-543f-446a-a829-1b0da8cc89ea")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("c4cc3793-3459-47e3-bb1b-848b19732cee")
    private static final int MINOR_VERSION = 0;

    @objid ("60b2dfa2-de0f-4e10-ac54-970da012fa20")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmEquipmentImageStyleKeys();

    @objid ("6c049b85-46cb-48ef-9ee5-7144872d773b")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmEquipmentSimpleStyleKeys();

    @objid ("c6f934c5-5e46-400d-b7a3-4fae305e3c66")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmEquipmentStructuredStyleKeys();

    @objid ("08e1464d-5477-48e3-bf3e-f3c5cd992a8d")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmEquipmentUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Equipment is unmasked.
     * @param el the unmasked Equipment.
     * @param ref a reference to the unmasked Equipment.
     */
    @objid ("a0001c0e-ccea-43f7-bf2c-ae048fb5e7a8")
    public GmEquipment(IGmDiagram diagram, Equipment el, MRef ref) {
        super(diagram, el, ref);

        GmEquipmentPrimaryNode mainNode = new GmEquipmentPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("c3ea9d61-89b3-42d8-8c4f-ac581a647a90")
    public GmEquipment() {
        // Nothing specific to do.
    }

    @objid ("88ac36bf-59c4-465d-844b-7d049b2ff6f2")
    @Override
    public int getMajorVersion() {
        return GmEquipment.MAJOR_VERSION;
    }

    @objid ("262e56c5-14b8-474f-b88a-75fe7d810003")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmEquipment.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmEquipment.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmEquipment.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmEquipment.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmEquipment.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("4551d900-d0ae-4d71-a8f2-44acd3bce6b1")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmEquipment.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmEquipment.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmEquipment.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmEquipment.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmEquipment.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("f67e3bd5-6749-4cb5-b36d-45a807fe4999")
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

    @objid ("4aed15fd-c108-4d97-bcff-5822e9c2536e")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmEquipment.", GmEquipment.MINOR_VERSION);

    }

    @objid ("c38ae1b0-dcf1-427d-b66c-f5f128b1fd70")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("1f959527-1f23-4740-ae82-02d2aedbe054")
    GmEquipment(final _GmEquipment oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmEquipmentPrimaryNode primary = new GmEquipmentPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

}
