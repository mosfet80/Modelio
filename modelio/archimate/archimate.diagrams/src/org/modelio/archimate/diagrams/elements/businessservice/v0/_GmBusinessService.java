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
package org.modelio.archimate.diagrams.elements.businessservice.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessservice.GmBusinessServiceImageStyleKeys;
import org.modelio.archimate.diagrams.elements.businessservice.GmBusinessServiceSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.businessservice.GmBusinessServiceStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.businessservice.GmBusinessServiceUserImageStyleKeys;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessService;
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
 * Specialized class for {@link BusinessService}.
 */
@objid ("80b4ff0e-895e-49eb-a3c3-62a27b8e69a4")
public class _GmBusinessService extends GmArchiElement<BusinessService> {
    @objid ("883671c3-638c-42c2-a890-2d746a12ca99")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("20b8a9eb-70be-4a28-aee0-ea41da27363a")
    private static final int MINOR_VERSION = 0;

    @objid ("9139aac0-d90b-411a-b8cb-19eef3385701")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmBusinessServiceImageStyleKeys();

    @objid ("0f9cda35-81a2-4559-96ba-756bf6959322")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmBusinessServiceSimpleStyleKeys();

    @objid ("a538154e-3462-4b09-b30a-636dbb48a127")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmBusinessServiceStructuredStyleKeys();

    @objid ("e8ee9d93-3702-44a0-8ae9-bfc63c06c042")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmBusinessServiceUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessService is unmasked.
     * @param el the unmasked BusinessService.
     * @param ref a reference to the unmasked BusinessService.
     */
    @objid ("e8b6d369-fce1-453a-97f6-f75e9a5e5973")
    public _GmBusinessService(IGmDiagram diagram, BusinessService el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("2ee0b8e7-9673-4419-8e80-aad1fdee202e")
    public _GmBusinessService() {
        // Nothing specific to do.
    }

    @objid ("4977c1ff-aa93-4dc4-834f-f80c0389ec02")
    @Override
    public int getMajorVersion() {
        return _GmBusinessService.MAJOR_VERSION;
    }

    @objid ("8ae808f6-0556-4862-bd1d-8c10e482e067")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmBusinessService.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmBusinessService.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmBusinessService.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmBusinessService.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmBusinessService.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("3e48e83e-24a7-4582-8d6b-345b934da276")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmBusinessService.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmBusinessService.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmBusinessService.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmBusinessService.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmBusinessService.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("d6b9a68c-da8b-4151-9ca9-196076263ba2")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmBusinessService.");
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

    @objid ("8405bd22-c148-4f63-8062-f1ca67356ad8")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmBusinessService.", _GmBusinessService.MINOR_VERSION);

    }

    @objid ("c6578b9d-a048-4fa1-9e5f-472e344fa1d0")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
