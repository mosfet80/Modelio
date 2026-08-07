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
package org.modelio.archimate.diagrams.elements.businessrole.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessrole.GmBusinessRoleImageStyleKeys;
import org.modelio.archimate.diagrams.elements.businessrole.GmBusinessRoleSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.businessrole.GmBusinessRoleStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.businessrole.GmBusinessRoleUserImageStyleKeys;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.metamodel.layers.business.structure.active.BusinessRole;
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
 * Specialized class for {@link BusinessRole}.
 */
@objid ("3f0ce1f9-05fc-41ea-9faa-c0fc14070172")
public class _GmBusinessRole extends GmArchiElement<BusinessRole> {
    @objid ("93074ea2-bbc9-4ece-a035-16260538be8d")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("05c9a954-3650-4fde-9223-6cc0f7cc36d2")
    private static final int MINOR_VERSION = 0;

    @objid ("02d76709-35cf-4e86-bc91-5ffcc9b0ee10")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmBusinessRoleImageStyleKeys();

    @objid ("dea4a171-cca9-4c0a-b0e8-b663743d18e8")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmBusinessRoleSimpleStyleKeys();

    @objid ("1b3a72b2-0b67-47fa-a650-83e361f8ef14")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmBusinessRoleStructuredStyleKeys();

    @objid ("8410a512-5aef-4389-ba13-1c7cf4770b17")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmBusinessRoleUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessRole is unmasked.
     * @param el the unmasked BusinessRole.
     * @param ref a reference to the unmasked BusinessRole.
     */
    @objid ("c59981e2-dc37-49f6-a407-e4e1e1fe2b5b")
    public _GmBusinessRole(IGmDiagram diagram, BusinessRole el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("97856697-aac7-4cf0-b9f4-1ee6a4bf5cfd")
    public _GmBusinessRole() {
        // Nothing specific to do.
    }

    @objid ("db0907d3-e023-471c-a351-1ba0acb93e98")
    @Override
    public int getMajorVersion() {
        return _GmBusinessRole.MAJOR_VERSION;
    }

    @objid ("11a0eb0a-6da2-4c9f-8c58-c811e323b8c6")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmBusinessRole.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmBusinessRole.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmBusinessRole.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmBusinessRole.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmBusinessRole.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("f6af4ab5-f16d-4a5e-a6e1-2dbbbe2aa8a9")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmBusinessRole.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmBusinessRole.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmBusinessRole.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmBusinessRole.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmBusinessRole.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("f011758f-de18-48d1-92ef-43d2f0aa1134")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmBusinessRole.");
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

    @objid ("70129ef1-f8b2-4575-af03-86f8c288f71b")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmBusinessRole.", _GmBusinessRole.MINOR_VERSION);

    }

    @objid ("68daa27a-9e3a-457d-9b8c-8646c051c80d")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
