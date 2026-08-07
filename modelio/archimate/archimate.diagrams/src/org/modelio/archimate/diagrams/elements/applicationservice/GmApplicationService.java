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
package org.modelio.archimate.diagrams.elements.applicationservice;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.applicationservice.v0._GmApplicationService;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationService;
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
 * Specialized class for {@link ApplicationService}.
 */
@objid ("4cd92d75-aad9-48ba-b118-103754f8ba0a")
public class GmApplicationService extends GmArchiElementPortContainer<ApplicationService> {
    @objid ("c060ae6d-1119-4f70-b0f0-b143a344c3d5")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("aee1ee0a-b084-4688-90d9-cb262d9baf0b")
    private static final int MINOR_VERSION = 0;

    @objid ("3d2f80e7-cf72-4d8b-a06f-8d54541635b6")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmApplicationServiceImageStyleKeys();

    @objid ("3a0679b9-dc23-4014-b6d2-fcc7e1754bfd")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmApplicationServiceSimpleStyleKeys();

    @objid ("57576189-9313-43bc-b716-8beec11cadb3")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmApplicationServiceStructuredStyleKeys();

    @objid ("a2eb5d13-e341-412d-bab7-9babc9cb59b8")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmApplicationServiceUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ApplicationService is unmasked.
     * @param el the unmasked ApplicationService.
     * @param ref a reference to the unmasked ApplicationService.
     */
    @objid ("b3a3b2c4-dcdb-4828-b82e-a9f077b95749")
    public GmApplicationService(IGmDiagram diagram, ApplicationService el, MRef ref) {
        super(diagram, el, ref);

        GmApplicationServicePrimaryNode mainNode = new GmApplicationServicePrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("325220aa-52c2-47bf-83ee-dc71fc99e9b9")
    GmApplicationService(final _GmApplicationService oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmApplicationServicePrimaryNode primary = new GmApplicationServicePrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("b2ab10c4-a17c-46db-b1c0-144c55cea2f9")
    public GmApplicationService() {
        // Nothing specific to do.
    }

    @objid ("5b938634-7160-4443-96bf-2981d8e5d4b7")
    @Override
    public int getMajorVersion() {
        return GmApplicationService.MAJOR_VERSION;
    }

    @objid ("a52d573b-3c40-4b6f-9398-8a0358bdca1f")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmApplicationService.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmApplicationService.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmApplicationService.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmApplicationService.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmApplicationService.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("d1424b03-ad4e-4f8a-950b-7ab70341034b")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmApplicationService.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmApplicationService.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmApplicationService.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmApplicationService.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmApplicationService.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("e185e9a7-3701-469a-8dce-570b4da13825")
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

    @objid ("44cd441d-c466-4cdc-ae14-b39f85c50574")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmApplicationService.");
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

    @objid ("585eeae5-ade8-4b98-8ef0-e7dd904cbe4f")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmApplicationService.", GmApplicationService.MINOR_VERSION);

    }

    @objid ("5a9f4ef0-97fe-48ee-8f9b-1d80f182a1d3")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
