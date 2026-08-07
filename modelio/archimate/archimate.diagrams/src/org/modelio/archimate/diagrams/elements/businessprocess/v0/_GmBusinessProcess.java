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
package org.modelio.archimate.diagrams.elements.businessprocess.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessprocess.GmBusinessProcessImageStyleKeys;
import org.modelio.archimate.diagrams.elements.businessprocess.GmBusinessProcessSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.businessprocess.GmBusinessProcessStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.businessprocess.GmBusinessProcessUserImageStyleKeys;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessProcess;
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
 * Specialized class for {@link BusinessProcess}.
 */
@objid ("9c5b8d02-3bbd-41b7-9b4d-d09b745b70dc")
public class _GmBusinessProcess extends GmArchiElement<BusinessProcess> {
    @objid ("29912565-480d-444e-bf2b-4f3c9c700111")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("19b9eeb2-f797-4e78-926d-fee0cb37e551")
    private static final int MINOR_VERSION = 0;

    @objid ("5b9e5051-3f57-4e14-8441-975c43325ec4")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmBusinessProcessImageStyleKeys();

    @objid ("c81f61fa-d1c9-4389-b1dc-d03091f48554")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmBusinessProcessSimpleStyleKeys();

    @objid ("c55a6709-cff0-4507-8a9f-f0b23b463be2")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmBusinessProcessStructuredStyleKeys();

    @objid ("b81c1fca-31fc-45ae-baa4-54a66680f62a")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmBusinessProcessUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessProcess is unmasked.
     * @param el the unmasked BusinessProcess.
     * @param ref a reference to the unmasked BusinessProcess.
     */
    @objid ("89142889-0451-4ba0-b80e-8eec167d3b72")
    public _GmBusinessProcess(IGmDiagram diagram, BusinessProcess el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("4ca13261-b50c-463e-b484-fb39c808f365")
    public _GmBusinessProcess() {
        // Nothing specific to do.
    }

    @objid ("4bb94db5-3597-4371-8c40-8a7237bfe2b3")
    @Override
    public int getMajorVersion() {
        return _GmBusinessProcess.MAJOR_VERSION;
    }

    @objid ("a719f9b7-7afa-47fe-bdc0-2aaf9a7435c0")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmBusinessProcess.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmBusinessProcess.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmBusinessProcess.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmBusinessProcess.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmBusinessProcess.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("eba63020-17df-4c7c-934b-5daad4fd273c")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmBusinessProcess.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmBusinessProcess.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmBusinessProcess.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmBusinessProcess.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmBusinessProcess.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("7e825a97-8a19-43c8-b100-c607a26bc950")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmBusinessProcess.");
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

    @objid ("e5e74917-562d-4bff-89ea-27be5cb5c8da")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmBusinessProcess.", _GmBusinessProcess.MINOR_VERSION);

    }

    @objid ("4d2ec40e-4d84-4399-82fe-17cfe7eb0183")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
