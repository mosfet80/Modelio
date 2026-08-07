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
package org.modelio.archimate.diagrams.elements.applicationservice.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.applicationservice.GmApplicationServiceImageStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationservice.GmApplicationServiceSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationservice.GmApplicationServiceStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationservice.GmApplicationServiceUserImageStyleKeys;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationService;
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
 * Specialized class for {@link ApplicationService}.
 */
@objid ("c29e8248-8b5f-4172-b626-9b393d92e8c0")
public class _GmApplicationService extends GmArchiElement<ApplicationService> {
    @objid ("1e466325-aa09-471b-98e0-7f691afbfa9c")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("20339b51-3a20-4915-b614-d482b2567af9")
    private static final int MINOR_VERSION = 0;

    @objid ("6fcaf674-97f7-4dad-95a3-bbbc525b6e21")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmApplicationServiceImageStyleKeys();

    @objid ("dda47b32-172b-4cc3-ba23-0db37b2b11eb")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmApplicationServiceSimpleStyleKeys();

    @objid ("e1787888-032b-4799-951b-0806a899e8fe")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmApplicationServiceStructuredStyleKeys();

    @objid ("e12c059b-46c8-4ccc-bf55-44d9ffde008e")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmApplicationServiceUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ApplicationService is unmasked.
     * @param el the unmasked ApplicationService.
     * @param ref a reference to the unmasked ApplicationService.
     */
    @objid ("aba0b53f-5df7-4e7c-8496-e857498f1644")
    public _GmApplicationService(IGmDiagram diagram, ApplicationService el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("3b6bf1f9-9a9f-4d15-b3fe-05afe7d7c883")
    public _GmApplicationService() {
        // Nothing specific to do.
    }

    @objid ("5523b560-37c4-4568-b6a7-979654a91270")
    @Override
    public int getMajorVersion() {
        return _GmApplicationService.MAJOR_VERSION;
    }

    @objid ("4e0d8a83-8a76-4f60-87e8-5b6e11fe2fcb")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmApplicationService.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmApplicationService.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmApplicationService.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmApplicationService.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmApplicationService.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("f56d22a7-8341-45a8-8244-eb191c89335b")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmApplicationService.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmApplicationService.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmApplicationService.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmApplicationService.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmApplicationService.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("41e5a5ac-4d88-4340-97f9-b0db3aa7e67c")
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

    @objid ("4dd330ad-d349-432f-a7d4-ad3ed85b6072")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmApplicationService.", _GmApplicationService.MINOR_VERSION);

    }

    @objid ("dc1a51c0-f062-4bce-ae15-5954edf44455")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
