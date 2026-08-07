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
package org.modelio.archimate.diagrams.elements.applicationcollaboration;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationCollaboration;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link ApplicationCollaboration}.
 */
@objid ("1da81293-7ec6-4b44-a208-0f847e08d092")
public class GmApplicationCollaboration extends GmArchiElementPortContainer<ApplicationCollaboration> {
    @objid ("0d4a5867-ec2e-41a0-ab1f-3111db28e634")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmApplicationCollaborationImageStyleKeys();

    @objid ("684fbd15-1d46-4562-ad64-3b4907003a48")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmApplicationCollaborationSimpleStyleKeys();

    @objid ("5007b5cd-a3ca-4893-a536-47dd45d40ac4")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmApplicationCollaborationStructuredStyleKeys();

    @objid ("ef92a153-ab3d-4aef-9792-e9bc161bca28")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmApplicationCollaborationUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ApplicationCollaboration is unmasked.
     * @param el the unmasked ApplicationCollaboration.
     * @param ref a reference to the unmasked ApplicationCollaboration.
     */
    @objid ("d2a110bf-5b85-4733-9285-851b54687991")
    public GmApplicationCollaboration(IGmDiagram diagram, ApplicationCollaboration el, MRef ref) {
        super(diagram, el, ref);

        GmApplicationCollaborationPrimaryNode mainNode = new GmApplicationCollaborationPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    @objid ("ec80c786-6015-47b1-8214-347a86c4251a")
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

    @objid ("cc64e173-285c-4abe-91b2-31ccc46de2ec")
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

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("89451753-5999-4eef-93a3-d2fcf2b31200")
    public GmApplicationCollaboration() {
        // Nothing specific to do.
    }

}
