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
package org.modelio.archimate.diagrams.elements.technologycollaboration;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyCollaboration;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link TechnologyCollaboration}.
 */
@objid ("bedcc6ee-0cf8-4120-ad4d-9b82d4358ff7")
public class GmTechnologyCollaboration extends GmArchiElementPortContainer<TechnologyCollaboration> {
    @objid ("bb49f7ac-ccf4-4629-9b74-1a12d0702114")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmTechnologyCollaborationImageStyleKeys();

    @objid ("168bde86-3d2c-4236-afb0-b263a98bf63c")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmTechnologyCollaborationSimpleStyleKeys();

    @objid ("ab144624-3536-4915-87b5-0edefaaa84f0")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmTechnologyCollaborationStructuredStyleKeys();

    @objid ("94a17df9-bce4-48fd-a520-c06e6337d35e")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmTechnologyCollaborationUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the TechnologyCollaboration is unmasked.
     * @param el the unmasked TechnologyCollaboration.
     * @param ref a reference to the unmasked TechnologyCollaboration.
     */
    @objid ("31f53f0f-1d0d-4a14-bc45-0aa25e8582f9")
    public GmTechnologyCollaboration(IGmDiagram diagram, TechnologyCollaboration el, MRef ref) {
        super(diagram, el, ref);
        GmTechnologyCollaborationPrimaryNode mainNode = new GmTechnologyCollaborationPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("0dae5b99-130b-429f-867d-779346cd6496")
    public GmTechnologyCollaboration() {
        // Nothing specific to do.
    }

    @objid ("62f2e8cf-a5bd-4202-b9fc-91762b6573ae")
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

    @objid ("c2366608-3ccb-486e-843f-582aaf5dee0b")
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
