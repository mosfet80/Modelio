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
package org.modelio.archimate.diagrams.elements.businessevent.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessevent.GmBusinessEventImageStyleKeys;
import org.modelio.archimate.diagrams.elements.businessevent.GmBusinessEventSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.businessevent.GmBusinessEventStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.businessevent.GmBusinessEventUserImageStyleKeys;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessEvent;
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
 * Specialized class for {@link BusinessEvent}.
 */
@objid ("89a5fc89-6b73-4414-99e5-5147ab73685e")
public class _GmBusinessEvent extends GmArchiElement<BusinessEvent> {
    @objid ("b36de53f-678a-4134-b52d-fe0a17e85c2f")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("bd5727c8-e4c1-4238-b9c2-b011519fb872")
    private static final int MINOR_VERSION = 0;

    @objid ("459204eb-cdd3-48fd-8a7e-53155d4a3480")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmBusinessEventImageStyleKeys();

    @objid ("8e4bfbe3-5a65-404e-8ebd-6e627415a63b")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmBusinessEventSimpleStyleKeys();

    @objid ("4b6ae7df-a53a-4ebc-b4f0-d86a1e2d2eab")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmBusinessEventStructuredStyleKeys();

    @objid ("38d11d98-393c-4f49-bb2c-0d90d5402a3a")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmBusinessEventUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessEvent is unmasked.
     * @param el the unmasked BusinessEvent.
     * @param ref a reference to the unmasked BusinessEvent.
     */
    @objid ("482553b2-7f04-41da-92dd-05ecdb290ebf")
    public _GmBusinessEvent(IGmDiagram diagram, BusinessEvent el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("1dc211ea-2889-44c2-aefe-5ad9881a642a")
    public _GmBusinessEvent() {
        // Nothing specific to do.
    }

    @objid ("42757d62-4b9a-4b1f-b091-b149117fdc39")
    @Override
    public int getMajorVersion() {
        return _GmBusinessEvent.MAJOR_VERSION;
    }

    @objid ("366c8eb6-ab1a-4011-893f-51ff57d61276")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmBusinessEvent.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmBusinessEvent.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmBusinessEvent.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmBusinessEvent.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmBusinessEvent.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("71f9f8da-f929-44f3-9940-fe086654a147")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmBusinessEvent.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmBusinessEvent.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmBusinessEvent.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmBusinessEvent.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmBusinessEvent.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("da2a677e-aebe-43fa-97f4-dd1434eda73c")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmBusinessEvent.");
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

    @objid ("340ad523-0adb-4f0c-9f97-e15c47b01c4d")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmBusinessEvent.", _GmBusinessEvent.MINOR_VERSION);

    }

    @objid ("d90a341d-be5a-4dcd-9591-305748804009")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
