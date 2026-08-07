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
package org.modelio.archimate.diagrams.elements.technologyinterface;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyInterface;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link TechnologyInterface}.
 */
@objid ("6e12db4b-c7e9-4527-b9a6-13484c04de0c")
public class GmTechnologyInterface extends GmArchiElementPortContainer<TechnologyInterface> {
    @objid ("c66ff724-1d44-4f62-816e-1ea685f82195")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmTechnologyInterfaceImageStyleKeys();

    @objid ("937ebe4f-6d48-4a5a-9e66-9c209570b730")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmTechnologyInterfaceSimpleStyleKeys();

    @objid ("e0e99537-dc77-482a-838e-5ddbd2b26e9f")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmTechnologyInterfaceStructuredStyleKeys();

    @objid ("9825990c-4822-470a-96cf-54a00b82208b")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmTechnologyInterfaceUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the TechnologyInterface is unmasked.
     * @param el the unmasked TechnologyInterface.
     * @param ref a reference to the unmasked TechnologyInterface.
     */
    @objid ("c8ea6274-71bb-4209-84ab-8bd8b9ea9243")
    public GmTechnologyInterface(IGmDiagram diagram, TechnologyInterface el, MRef ref) {
        super(diagram, el, ref);
        GmTechnologyInterfacePrimaryNode mainNode = new GmTechnologyInterfacePrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("c3684b4d-6443-47e2-8d4c-19e5e879c064")
    public GmTechnologyInterface() {
        // Nothing specific to do.
    }

    @objid ("bba19793-7984-4c9c-87af-2ab882c7b704")
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

    @objid ("96f50e6f-779d-457b-84d5-356491d99347")
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
