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
package org.modelio.archimate.diagrams.elements.applicationinteraction;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationInteraction;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link ApplicationInteraction}.
 */
@objid ("610fb974-405b-49ca-90b3-d98e9fb771af")
public class GmApplicationInteraction extends GmArchiElementPortContainer<ApplicationInteraction> {
    @objid ("4dcaba8d-b2d8-407a-8ed1-784ef376bb97")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmApplicationInteractionImageStyleKeys();

    @objid ("89e8cf2f-3818-4e3f-9436-4b21df773b6a")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmApplicationInteractionSimpleStyleKeys();

    @objid ("430d4cca-c1ff-4d82-8520-955e28240f73")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmApplicationInteractionStructuredStyleKeys();

    @objid ("8e162524-c7df-40e2-809f-feb16bb4d483")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmApplicationInteractionUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ApplicationInteraction is unmasked.
     * @param el the unmasked ApplicationInteraction.
     * @param ref a reference to the unmasked ApplicationInteraction.
     */
    @objid ("ce71c4e8-d292-4751-b86e-6ff3e951c023")
    public GmApplicationInteraction(IGmDiagram diagram, ApplicationInteraction el, MRef ref) {
        super(diagram, el, ref);
        GmApplicationInteractionPrimaryNode mainNode = new GmApplicationInteractionPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("ca49d951-42de-4cbd-b410-5598c80431c4")
    public GmApplicationInteraction() {
        // Nothing specific to do.
    }

    @objid ("865fddcd-a875-4bca-9daf-fd4174d5473c")
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

    @objid ("2ed1c91d-5961-4131-9c3e-3c9d07f108ff")
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
