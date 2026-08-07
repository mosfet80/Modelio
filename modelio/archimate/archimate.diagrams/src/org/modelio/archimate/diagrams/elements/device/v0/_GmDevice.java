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
package org.modelio.archimate.diagrams.elements.device.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.device.GmDeviceImageStyleKeys;
import org.modelio.archimate.diagrams.elements.device.GmDeviceSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.device.GmDeviceStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.device.GmDeviceUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Device;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
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
@objid ("07953f2c-723b-4a8e-9d37-528f8eeac775")
public class _GmDevice extends GmArchiElement<Device> {
    @objid ("ed63cec1-aeb8-4cca-a16d-c6c914293bb3")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("ef07e0e0-30d2-4f4f-95d7-ec463187a8b3")
    private static final int MINOR_VERSION = 0;

    @objid ("0d581e47-c749-4baf-9441-c3b056e41a01")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmDeviceImageStyleKeys();

    @objid ("d13a73ec-f1fa-479d-b20c-46a98801e0d4")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmDeviceSimpleStyleKeys();

    @objid ("1603a9e1-f640-4e92-8885-b3dd57369711")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmDeviceStructuredStyleKeys();

    @objid ("51365e2a-66ba-49c9-ab52-628987459f4d")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmDeviceUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Device is unmasked.
     * @param el the unmasked Device.
     * @param ref a reference to the unmasked Device.
     */
    @objid ("c6f934b4-aa65-4a27-bec7-e12beaca0080")
    public _GmDevice(IGmDiagram diagram, Device el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("3b6635fa-3f56-44f8-a6ec-260331cf859f")
    public _GmDevice() {
        // Nothing specific to do.
    }

    @objid ("87ad167c-b6eb-44c3-be3f-bd1820965d30")
    @Override
    public int getMajorVersion() {
        return _GmDevice.MAJOR_VERSION;
    }

    @objid ("e9be1f17-69fa-486d-8c38-eb9848e52ea2")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmDevice.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmDevice.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmDevice.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmDevice.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmDevice.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("d3771c53-15fb-400d-85ab-f573e3f92462")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmDevice.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmDevice.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmDevice.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmDevice.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmDevice.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("e91fb6e7-f71d-45d7-9c0b-c14c532068dd")
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

    @objid ("7aa4f347-9023-456b-93fb-ff2578c0387a")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmDevice.", _GmDevice.MINOR_VERSION);

    }

    @objid ("d39075a2-4419-4ad2-97c8-46960530b3da")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
