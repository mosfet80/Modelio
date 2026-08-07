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
package org.modelio.archimate.diagrams.elements.device;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.device.v0._GmDevice;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Device;
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
 * Specialized class for {@link Device}.
 */
@objid ("3d2522ef-af56-42be-a44b-855831d9bdd5")
public class GmDevice extends GmArchiElementPortContainer<Device> {
    @objid ("094cf9a1-5a49-45c8-a124-d0e2e18fbc54")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("ce476cfa-1927-4c1a-8890-ca4052611aa3")
    private static final int MINOR_VERSION = 0;

    @objid ("076ed8ed-1843-4696-9a7c-e46a794aac10")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmDeviceImageStyleKeys();

    @objid ("53b7a483-d17f-4d29-b8dc-e29e316fe9c3")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmDeviceSimpleStyleKeys();

    @objid ("e8bf1b8a-59bb-4137-8d2d-e29040829bbe")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmDeviceStructuredStyleKeys();

    @objid ("ad2a914e-6916-46f3-8b90-d9448579e26b")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmDeviceUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Device is unmasked.
     * @param el the unmasked Device.
     * @param ref a reference to the unmasked Device.
     */
    @objid ("132fda54-8593-48ba-bf59-7e0378f6f801")
    public GmDevice(IGmDiagram diagram, Device el, MRef ref) {
        super(diagram, el, ref);

        GmDevicePrimaryNode mainNode = new GmDevicePrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("0ba28c2a-0fa0-4738-8a7e-6e548988bc72")
    public GmDevice() {
        // Nothing specific to do.
    }

    @objid ("6b6a7e95-6e94-4b40-b054-a49798efad79")
    @Override
    public int getMajorVersion() {
        return GmDevice.MAJOR_VERSION;
    }

    @objid ("db034fd0-3d79-4c27-ba23-621b75dba0f4")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmDevice.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmDevice.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmDevice.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmDevice.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmDevice.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("99ad4159-eb3d-4b71-a545-1e1a539ac9f3")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmDevice.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmDevice.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmDevice.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmDevice.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmDevice.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("2ca89d4d-9ed4-4468-98b2-d87fc6e3c1f0")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmDevice.");
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

    @objid ("4b8688c9-75a1-4848-9d11-2c9027e17df3")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmDevice.", GmDevice.MINOR_VERSION);

    }

    @objid ("1307be70-f7b7-4318-b0ec-6beec99b7e6a")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("f0430063-b394-4293-bcdc-dc8ef000bfe1")
    GmDevice(final _GmDevice oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmDevicePrimaryNode primary = new GmDevicePrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("899aea32-4ff0-442b-aeba-e5bbe00543d7")
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
