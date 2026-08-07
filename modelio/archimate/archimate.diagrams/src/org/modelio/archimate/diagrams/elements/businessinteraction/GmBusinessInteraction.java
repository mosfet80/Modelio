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
package org.modelio.archimate.diagrams.elements.businessinteraction;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessInteraction;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link BusinessInteraction}.
 */
@objid ("e186c613-0bc4-4454-b765-5c0d153bb50a")
public class GmBusinessInteraction extends GmArchiElementPortContainer<BusinessInteraction> {
    @objid ("59560333-c490-4c02-82b6-6d918254616c")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmBusinessInteractionImageStyleKeys();

    @objid ("4e41a7af-b6e1-43ba-8ac9-43a8f06f650d")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmBusinessInteractionSimpleStyleKeys();

    @objid ("7b5171c0-12d2-4007-89f6-2eb7c37e380d")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmBusinessInteractionStructuredStyleKeys();

    @objid ("8fa5bbef-8079-4274-8d70-1035e76e845d")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmBusinessInteractionUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessInteraction is unmasked.
     * @param el the unmasked BusinessInteraction.
     * @param ref a reference to the unmasked BusinessInteraction.
     */
    @objid ("c8cf2a54-fb6f-4884-b5ff-5d4872b38263")
    public GmBusinessInteraction(IGmDiagram diagram, BusinessInteraction el, MRef ref) {
        super(diagram, el, ref);

        GmBusinessInteractionPrimaryNode mainNode = new GmBusinessInteractionPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("72db4ffc-bc44-48e7-a901-c814dc6953a1")
    public GmBusinessInteraction() {
        // Nothing specific to do.
    }

    @objid ("0b650f42-e0b4-45d6-bac3-dd830caa4dea")
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

    @objid ("764a9061-1eda-45c3-b6d0-e0d5cd0eb116")
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
