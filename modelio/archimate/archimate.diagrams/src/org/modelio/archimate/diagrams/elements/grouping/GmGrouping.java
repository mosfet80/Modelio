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
package org.modelio.archimate.diagrams.elements.grouping;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.grouping.v0._GmGrouping;
import org.modelio.archimate.metamodel.core.generic.composite.Grouping;
import org.modelio.diagram.elements.common.portcontainer.GmPortContainer;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Grouping}.
 */
@objid ("6e102541-883d-450d-b242-564951c6c431")
public class GmGrouping extends GmArchiElementPortContainer<Grouping> {
    @objid ("38af5005-60dc-43f7-a21f-30d27a8c4115")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("523cdde2-6a38-4d58-ba23-db4eafb9de84")
    private static final int MINOR_VERSION = 0;

    @objid ("b19b90b2-c181-4850-9fbb-f43fecc359b4")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmGroupingImageStyleKeys();

    @objid ("ab644d44-30f2-4e22-aba8-ddb605ce53cf")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmGroupingSimpleStyleKeys();

    @objid ("516cabb2-353c-489b-8d3c-6c90e220ad44")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmGroupingStructuredStyleKeys();

    @objid ("a08767c0-4fc2-4647-ab96-1889277fb184")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmGroupingUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Grouping is unmasked.
     * @param el the unmasked Grouping.
     * @param ref a reference to the unmasked Grouping.
     */
    @objid ("257d7a8d-6fe3-4d12-a0ee-5cbfb1101a7c")
    public GmGrouping(IGmDiagram diagram, Grouping el, MRef ref) {
        super(diagram, el, ref);
        GmGroupingPrimaryNode mainNode = new GmGroupingPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("89e20bfe-de40-4502-b005-e6942f1710b1")
    public GmGrouping() {
        // Nothing specific to do.
    }

    @objid ("8ab444cc-1bb4-46a8-a8e8-8501428239f6")
    @Override
    public int getMajorVersion() {
        return GmGrouping.MAJOR_VERSION;
    }

    @objid ("61b06983-408f-4166-aa75-e2e4c843393e")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmGrouping.");
        switch (readVersion) {
        case 0: {
            read_0(in);
            break;
        }
        default: {
            assert (false) : readVersion + " version number not covered!";
            // reading as last handled version: 0
            read_0(in);
            break;
        }
        }

    }

    @objid ("708d13b9-71d1-4ea9-854e-226c114e7341")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmGrouping.", GmGrouping.MINOR_VERSION);

    }

    @objid ("4bc3f61e-9ead-4257-973c-86bc8e8b57be")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("f08147c2-dc4d-44c4-8a15-f6d20d6db67e")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmGrouping.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmGrouping.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmGrouping.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmGrouping.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmGrouping.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("c51f3299-5681-4946-a0ce-e06410e1f234")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmGrouping.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmGrouping.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmGrouping.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmGrouping.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmGrouping.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("0b76e3eb-ce72-4531-b494-31a0b1ef1116")
    GmGrouping(final _GmGrouping oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmGroupingPrimaryNode primary = new GmGroupingPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("31e69e7a-1d0e-4618-b69c-498cd9e989bb")
    @Override
    public List<GmNodeModel> getVisibleChildren() {
        List<GmNodeModel> ret = super.getVisibleChildren();

        GmNodeModel firstChild = getMainNode();
        if (firstChild != null && firstChild.getRepresentationMode() == RepresentationMode.SIMPLE) {
            // In simple mode, remove the floating label: a proper label is provider by the primary node
            ret.remove(getFirstChild(GmPortContainer.SATELLITE_ROLE));
        }
        return ret;
    }

}
