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
package org.modelio.archimate.diagrams.elements.businessinterface;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.business.structure.active.BusinessInterface;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link BusinessInterface}.
 */
@objid ("2c378113-05d1-41af-a684-3ba986d71864")
public class GmBusinessInterface extends GmArchiElementPortContainer<BusinessInterface> {
    @objid ("928da12f-2476-440b-b393-2b5009ed2cd3")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmBusinessInterfaceImageStyleKeys();

    @objid ("197127db-3df2-4855-b00a-c3c65630f6cd")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmBusinessInterfaceSimpleStyleKeys();

    @objid ("d53d9050-77b2-4a9e-938c-f6cf704c36ae")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmBusinessInterfaceStructuredStyleKeys();

    @objid ("24517b9d-edf1-4c36-ad8f-bee8e5495e0e")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmBusinessInterfaceUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessInterface is unmasked.
     * @param el the unmasked BusinessInterface.
     * @param ref a reference to the unmasked BusinessInterface.
     */
    @objid ("0fe3fb5a-d419-44f3-a226-7acbdd1b660c")
    public GmBusinessInterface(IGmDiagram diagram, BusinessInterface el, MRef ref) {
        super(diagram, el, ref);
        GmBusinessInterfacePrimaryNode mainNode = new GmBusinessInterfacePrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("dd985b0a-57c2-44eb-8332-3010d8031c25")
    public GmBusinessInterface() {
        // Nothing specific to do.
    }

    @objid ("c85e0ee1-dc27-4d8e-bcf9-81aa6c946cbe")
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

    @objid ("db2de641-e1f5-4c80-93a8-9c6ab0a88a31")
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
