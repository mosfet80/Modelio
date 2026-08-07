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
package org.modelio.archimate.diagrams.elements.path;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Path;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Path}.
 */
@objid ("972d36a2-e57d-4944-838b-7e7f8f4fc2aa")
public class GmPath extends GmArchiElementPortContainer<Path> {
    @objid ("04b46bed-799e-4a4c-be39-1bb9f52b59ed")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmPathImageStyleKeys();

    @objid ("1dec2e71-48c9-4f80-8878-baecd8b153a6")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmPathSimpleStyleKeys();

    @objid ("04cccde6-b242-4cc8-b6e8-4dc3feb0d309")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmPathStructuredStyleKeys();

    @objid ("55650821-aeb5-4ba1-939f-7d50829455df")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmPathUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Path is unmasked.
     * @param el the unmasked Path.
     * @param ref a reference to the unmasked Path.
     */
    @objid ("43d4e66f-1ac2-4a81-bc0e-6c0a5c3aff14")
    public GmPath(IGmDiagram diagram, Path el, MRef ref) {
        super(diagram, el, ref);
        GmPathPrimaryNode mainNode = new GmPathPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("aa7f3a2e-f9c7-479e-9361-5a01068881b1")
    public GmPath() {
        // Nothing specific to do.
    }

    @objid ("55b661ad-dabe-434d-a18a-1d5d7cc20ed7")
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

    @objid ("64c20c84-8bb7-4300-b9d3-e7f6c76bc34d")
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
