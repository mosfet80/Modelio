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
package org.modelio.archimate.diagrams.elements.technologyservice;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.technologyservice.v0._GmTechnologyService;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyService;
import org.modelio.diagram.elements.common.portcontainer.GmPortContainer;
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
 * Specialized class for {@link TechnologyService}.
 */
@objid ("083483a7-e666-4f15-a1eb-3f89299d84f7")
public class GmTechnologyService extends GmArchiElementPortContainer<TechnologyService> {
    @objid ("de876e1e-a389-492d-a314-960f6fc9da57")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("a2507115-cb11-4c7f-a7da-aa075090aa5c")
    private static final int MINOR_VERSION = 0;

    @objid ("da38f1b6-aea3-48cb-a1b7-0904e81d4cf9")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmTechnologyServiceImageStyleKeys();

    @objid ("fe842e33-3dbf-41e8-a720-524f3e9c4188")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmTechnologyServiceSimpleStyleKeys();

    @objid ("080f5cda-8771-480a-97df-5a1379f3f5b4")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmTechnologyServiceStructuredStyleKeys();

    @objid ("fc393471-53de-4a60-beda-0bc0f2382f0f")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmTechnologyServiceUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the TechnologyService is unmasked.
     * @param el the unmasked TechnologyService.
     * @param ref a reference to the unmasked TechnologyService.
     */
    @objid ("bc882f01-59a1-4d74-bb58-f17f102c3fee")
    public GmTechnologyService(IGmDiagram diagram, TechnologyService el, MRef ref) {
        super(diagram, el, ref);

        GmTechnologyServicePrimaryNode mainNode = new GmTechnologyServicePrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("068c69c4-e95f-4a5c-8d6d-56e664958468")
    GmTechnologyService(final _GmTechnologyService oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmTechnologyServicePrimaryNode primary = new GmTechnologyServicePrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("bbd84a3b-3e2b-48aa-bf2e-ea7649b4869b")
    @Override
    public int getMajorVersion() {
        return GmTechnologyService.MAJOR_VERSION;
    }

    @objid ("3e1b7c55-2168-401a-934b-2cfcdc72ed0c")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmTechnologyService.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmTechnologyService.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmTechnologyService.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmTechnologyService.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmTechnologyService.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("e7e35ebe-0511-4bd7-87df-a45a5362162a")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmTechnologyService.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmTechnologyService.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmTechnologyService.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmTechnologyService.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmTechnologyService.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("c8e8375d-0e78-4ca2-995f-dbb6b6db3ed9")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmTechnologyService.");
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

    @objid ("4dab2e6c-2afc-47ef-b1fc-3fc0867b001f")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmTechnologyService.", MINOR_VERSION);

    }

    @objid ("c7b2bd01-80ce-4892-a5ac-bde5a40b41a9")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("7a954837-596b-4804-9824-05779329edf8")
    public GmTechnologyService() {
        // Nothing specific to do.
    }

    @objid ("3326714a-3263-4fc6-bacf-4de2ceff88af")
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
