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
package org.modelio.archimate.diagrams.elements.distributionnetwork;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.physical.structure.active.DistributionNetwork;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link DistributionNetwork}.
 */
@objid ("a847504d-6d14-4400-8558-57b26453475b")
public class GmDistributionNetwork extends GmArchiElementPortContainer<DistributionNetwork> {
    @objid ("f3df32b6-512e-423a-94cc-dfa119ac18ed")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmDistributionNetworkImageStyleKeys();

    @objid ("1d55a67e-d4aa-488b-9e4e-04deb4b656ec")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmDistributionNetworkSimpleStyleKeys();

    @objid ("55133d9d-fc5a-4bba-a473-a0ac692785b9")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmDistributionNetworkStructuredStyleKeys();

    @objid ("e3662a6b-c9ce-4422-aa3d-012864f9cafb")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmDistributionNetworkUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the DistributionNetwork is unmasked.
     * @param el the unmasked DistributionNetwork.
     * @param ref a reference to the unmasked DistributionNetwork.
     */
    @objid ("d2d9a8bb-6b13-4c52-9585-125d22913be4")
    public GmDistributionNetwork(IGmDiagram diagram, DistributionNetwork el, MRef ref) {
        super(diagram, el, ref);
        GmDistributionNetworkPrimaryNode mainNode = new GmDistributionNetworkPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("d07cb174-fb0b-4761-9ecf-bb183cefe5e0")
    public GmDistributionNetwork() {
        // Nothing specific to do.
    }

    @objid ("d43c553f-f58b-49b4-b370-6c903314aaf7")
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

    @objid ("66d11bd5-34a8-4dd7-a7cc-4ae18b56f90a")
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
