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
package org.modelio.archimate.diagrams.elements.applicationinterface;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationInterface;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link ApplicationInterface}.
 */
@objid ("a171774f-381c-4346-8d83-ecf902b8b22e")
public class GmApplicationInterface extends GmArchiElementPortContainer<ApplicationInterface> {
    @objid ("9ef25ea4-95ce-4e43-a939-4c6bc6f21a5b")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmApplicationInterfaceImageStyleKeys();

    @objid ("d2f26b63-2eea-408a-b342-6bbf28d3d6d8")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmApplicationInterfaceSimpleStyleKeys();

    @objid ("be28a8d1-515c-48f0-b732-10fe29678b60")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmApplicationInterfaceStructuredStyleKeys();

    @objid ("b2237ae6-06ba-4a85-b6aa-a14b12e7f741")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmApplicationInterfaceUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ApplicationInterface is unmasked.
     * @param el the unmasked ApplicationInterface.
     * @param ref a reference to the unmasked ApplicationInterface.
     */
    @objid ("3b23b109-763d-44f3-ba74-31969c1a5144")
    public GmApplicationInterface(IGmDiagram diagram, ApplicationInterface el, MRef ref) {
        super(diagram, el, ref);
        GmApplicationInterfacePrimaryNode mainNode = new GmApplicationInterfacePrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("24675aca-9e5e-4fea-a95c-3ef3b4f6b176")
    public GmApplicationInterface() {
        // Nothing specific to do.
    }

    @objid ("b6ad818f-bed8-4f3b-aa44-56e7fe4668f5")
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

    @objid ("2d99630e-545c-4fe9-82c1-0408d791bafd")
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

}
