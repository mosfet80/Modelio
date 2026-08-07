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
package org.modelio.archimate.diagrams.elements.businesscollaboration;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.business.structure.active.BusinessCollaboration;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link BusinessCollaboration}.
 */
@objid ("7b6dfe77-3c4e-487e-a392-66ad52dca1b4")
public class GmBusinessCollaboration extends GmArchiElementPortContainer<BusinessCollaboration> {
    @objid ("f8e242d4-fd48-41b8-8f53-db6159d64d97")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmBusinessCollaborationImageStyleKeys();

    @objid ("29aa6472-9cb0-4ea8-82c6-cd4718259209")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmBusinessCollaborationSimpleStyleKeys();

    @objid ("92bfa72d-3367-4d8b-818c-af6f89584e5d")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmBusinessCollaborationStructuredStyleKeys();

    @objid ("a6f8c2d5-f8a3-40ea-a994-21457d43464a")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmBusinessCollaborationUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessCollaboration is unmasked.
     * @param el the unmasked BusinessCollaboration.
     * @param ref a reference to the unmasked BusinessCollaboration.
     */
    @objid ("914a178f-4114-47f9-b57b-45ae7a2aca64")
    public GmBusinessCollaboration(IGmDiagram diagram, BusinessCollaboration el, MRef ref) {
        super(diagram, el, ref);
        GmBusinessCollaborationPrimaryNode mainNode = new GmBusinessCollaborationPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("8595026e-b778-4d49-877d-6ba084509c93")
    public GmBusinessCollaboration() {
        // Nothing specific to do.
    }

    @objid ("f4325774-34cf-49b1-9d12-437aa93e2c46")
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

    @objid ("d8544bc0-873a-4539-b12a-3cbeb73264d7")
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
