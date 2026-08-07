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
package org.modelio.archimate.diagrams.elements.businessactor;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.business.structure.active.BusinessActor;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link BusinessActor}.
 */
@objid ("416b2470-cffb-4c14-be2a-bbe4cdc60b57")
public class GmBusinessActor extends GmArchiElementPortContainer<BusinessActor> {
    @objid ("518d0b4a-71da-4a42-bffc-2483a484d678")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmBusinessActorImageStyleKeys();

    @objid ("986f7941-afcc-41d7-a411-2cebb470bd75")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmBusinessActorSimpleStyleKeys();

    @objid ("4621e67d-f569-4401-8c83-5314c81f51d7")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmBusinessActorStructuredStyleKeys();

    @objid ("54c424bf-f50a-4556-931c-42b807135ed7")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmBusinessActorUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessActor is unmasked.
     * @param el the unmasked BusinessActor.
     * @param ref a reference to the unmasked BusinessActor.
     */
    @objid ("014c1e87-112d-43d8-b684-723d7777a080")
    public GmBusinessActor(IGmDiagram diagram, BusinessActor el, MRef ref) {
        super(diagram, el, ref);

        GmBusinessActorPrimaryNode mainNode = new GmBusinessActorPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("9253f31c-5c4e-4a12-8bfe-a52513989231")
    public GmBusinessActor() {
        // Nothing specific to do.
    }

    @objid ("5a7371f6-faa6-47c4-b04d-fa6dfac0c1f2")
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

    @objid ("b3ab3b36-d47a-4832-aaf6-e5fe02400042")
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
