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
package org.modelio.archimate.diagrams.elements.businessobject.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessobject.GmBusinessObjectImageStyleKeys;
import org.modelio.archimate.diagrams.elements.businessobject.GmBusinessObjectSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.businessobject.GmBusinessObjectStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.businessobject.GmBusinessObjectUserImageStyleKeys;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.metamodel.layers.business.structure.passive.BusinessObject;
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
 * Specialized class for {@link BusinessObject}.
 */
@objid ("5c760f24-1e70-41e0-91f4-2e62d7291c0a")
public class _GmBusinessObject extends GmArchiElement<BusinessObject> {
    @objid ("cb6ab520-ee7c-4e6f-9948-9ea5a5636c0f")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     * <p>
     * History:
     * <ul>
     * <li>0 : initial
     * <li>1 : same as zero, should have stayed to zero but can't rollback now 3.7 is released.
     * </ul>
     */
    @objid ("8bef4051-0bef-4405-ab4a-9c3b2c902b99")
    private static final int MINOR_VERSION = 1;

    @objid ("1cb6f700-074f-45ab-aeec-26762149814e")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmBusinessObjectImageStyleKeys();

    @objid ("2b7eb682-8f09-495f-9abf-c89f4ce434e0")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmBusinessObjectSimpleStyleKeys();

    @objid ("d0325bb7-206d-4ade-b27c-ae487fbfb2b6")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmBusinessObjectStructuredStyleKeys();

    @objid ("4259d578-d1a5-4658-8b6d-999dce0c0ce4")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmBusinessObjectUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessObject is unmasked.
     * @param el the unmasked BusinessObject.
     * @param ref a reference to the unmasked BusinessObject.
     */
    @objid ("2c66ff47-607a-42b6-9050-bcd17c7ce49c")
    public _GmBusinessObject(IGmDiagram diagram, BusinessObject el, MRef ref) {
        super(diagram, el, ref);
        this.header.setShowMetaclassIcon(false);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("1dd381ae-5462-46b4-a813-ddbad7c2504d")
    public _GmBusinessObject() {
        // Nothing specific to do.
    }

    @objid ("417b1299-48c1-4ba7-a9e4-9483aacfcddd")
    @Override
    public int getMajorVersion() {
        return _GmBusinessObject.MAJOR_VERSION;
    }

    @objid ("0b805b20-8c13-493b-bc97-96a2512492eb")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmBusinessObject.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmBusinessObject.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmBusinessObject.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmBusinessObject.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmBusinessObject.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("727c3322-975b-4fcd-885d-169538e595fa")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmBusinessObject.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmBusinessObject.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmBusinessObject.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmBusinessObject.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmBusinessObject.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("b19cbd18-d70f-4651-8af8-bbc75333b548")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmBusinessObject.");
        switch (readVersion) {
        case 0:
        case 1:
            // version was wrongly at 1 instead of 0.
            read_0(in);
            break;

        default:
            assert (false) : readVersion + " version number not covered!";
            // reading as last handled version: 0
            read_0(in);
            break;

        }

    }

    @objid ("28516fde-e171-41c9-81c8-964ec093fe15")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmBusinessObject.", _GmBusinessObject.MINOR_VERSION);

    }

    @objid ("d064b25b-1884-476d-a368-185d24cf3688")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
