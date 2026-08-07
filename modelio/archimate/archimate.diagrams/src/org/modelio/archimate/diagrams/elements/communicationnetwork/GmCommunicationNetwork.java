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
package org.modelio.archimate.diagrams.elements.communicationnetwork;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.technology.structure.active.CommunicationNetwork;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link CommunicationNetwork}.
 */
@objid ("bb500989-9461-442c-b4b2-4dc209916db6")
public class GmCommunicationNetwork extends GmArchiElementPortContainer<CommunicationNetwork> {
    @objid ("055cfa76-5e4a-40d4-935e-4f2d436cccf7")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmCommunicationNetworkImageStyleKeys();

    @objid ("8c9759b3-95b1-4f22-8c85-d81d99bb3bb1")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmCommunicationNetworkSimpleStyleKeys();

    @objid ("9bcf783e-4813-4ad6-bfce-c53a380807cf")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmCommunicationNetworkStructuredStyleKeys();

    @objid ("8aea21f6-f78b-4d7d-b57b-e0c978bf9bc8")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmCommunicationNetworkUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the CommunicationNetwork is unmasked.
     * @param el the unmasked CommunicationNetwork.
     * @param ref a reference to the unmasked CommunicationNetwork.
     */
    @objid ("0b533a41-ce0a-43db-a8fd-48ca71e49dbc")
    public GmCommunicationNetwork(IGmDiagram diagram, CommunicationNetwork el, MRef ref) {
        super(diagram, el, ref);
        GmCommunicationNetworkPrimaryNode mainNode = new GmCommunicationNetworkPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("825123fb-7f73-42da-b6e3-345229dff5b9")
    public GmCommunicationNetwork() {
        // Nothing specific to do.
    }

    @objid ("76bbb718-6677-455a-bebf-eb2db658743c")
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

    @objid ("5567a5cf-8346-48e8-9934-fa7227336db0")
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
