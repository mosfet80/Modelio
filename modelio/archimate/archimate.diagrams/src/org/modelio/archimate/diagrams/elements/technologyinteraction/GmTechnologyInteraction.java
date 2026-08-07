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
package org.modelio.archimate.diagrams.elements.technologyinteraction;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyInteraction;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link TechnologyInteraction}.
 */
@objid ("ad53714a-e2b9-4a0b-8707-755448dd3bca")
public class GmTechnologyInteraction extends GmArchiElementPortContainer<TechnologyInteraction> {
    @objid ("e8d8b00e-51e2-44a5-b9f7-1d989fe051bb")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmTechnologyInteractionImageStyleKeys();

    @objid ("e65c08ff-dba7-42c4-8593-1885ba1178d6")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmTechnologyInteractionSimpleStyleKeys();

    @objid ("ba663d49-18dd-425a-90b7-35ed48f58fc1")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmTechnologyInteractionStructuredStyleKeys();

    @objid ("89a945b8-dc24-4a0d-bd5c-65f6564ed386")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmTechnologyInteractionUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the TechnologyInteraction is unmasked.
     * @param el the unmasked TechnologyInteraction.
     * @param ref a reference to the unmasked TechnologyInteraction.
     */
    @objid ("e917e858-1a4c-4f71-8d3d-d28b9196f60e")
    public GmTechnologyInteraction(IGmDiagram diagram, TechnologyInteraction el, MRef ref) {
        super(diagram, el, ref);
        GmTechnologyInteractionPrimaryNode mainNode = new GmTechnologyInteractionPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("f93436dc-0145-4e64-9b55-fb1666adaa62")
    public GmTechnologyInteraction() {
        // Nothing specific to do.
    }

    @objid ("4791f358-bb43-4266-b6af-7dede0f42bb2")
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

    @objid ("cd6366f5-c0da-4dc3-81e8-c94d0c984109")
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
