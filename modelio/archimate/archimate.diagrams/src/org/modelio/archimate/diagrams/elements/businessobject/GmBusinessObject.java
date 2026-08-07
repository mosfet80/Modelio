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
package org.modelio.archimate.diagrams.elements.businessobject;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessobject.v0._GmBusinessObject;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.business.structure.passive.BusinessObject;
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
 * Specialized class for {@link BusinessObject}.
 */
@objid ("80232d3c-dbd4-43ff-970b-f1f50f50b58b")
public class GmBusinessObject extends GmArchiElementPortContainer<BusinessObject> {
    @objid ("27d906e8-aa49-41f5-9be5-accbc5e9106e")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     * <p>
     * History:
     * <ul>
     * <li>0 : initial
     * <li>1 : same as zero, should have stayed to zero but can't rollback now 3.7 is released.
     * </ul>
     */
    @objid ("dbc8f9c6-8136-4bd1-b1f0-33ec4ca70e98")
    private static final int MINOR_VERSION = 1;

    @objid ("aa619d19-f45d-4e6b-8239-7a196aea6ec7")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmBusinessObjectImageStyleKeys();

    @objid ("0da5749a-594f-4ffe-9f44-63f453fc78c4")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmBusinessObjectSimpleStyleKeys();

    @objid ("a7606650-64ec-468d-bd5c-343dfad8eb91")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmBusinessObjectStructuredStyleKeys();

    @objid ("c6e4ff90-a94c-456e-a8e3-fbc3929ef4ac")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmBusinessObjectUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessObject is unmasked.
     * @param el the unmasked BusinessObject.
     * @param ref a reference to the unmasked BusinessObject.
     */
    @objid ("67179ae8-44b2-4a97-83b4-8482359aecad")
    public GmBusinessObject(IGmDiagram diagram, BusinessObject el, MRef ref) {
        super(diagram, el, ref);

        GmBusinessObjectPrimaryNode mainNode = new GmBusinessObjectPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("f9d89e46-4480-495d-99ab-7a40b1b61220")
    public GmBusinessObject() {
        // Nothing specific to do.
    }

    @objid ("fc0cebb4-6465-4aa3-afcf-bc739f2400ea")
    @Override
    public int getMajorVersion() {
        return GmBusinessObject.MAJOR_VERSION;
    }

    @objid ("edd15d5a-5faf-47a9-8d5b-d4beb83c3954")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmBusinessObject.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmBusinessObject.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmBusinessObject.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmBusinessObject.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmBusinessObject.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("fde90572-f1a9-4b99-8926-223469aace16")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmBusinessObject.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmBusinessObject.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmBusinessObject.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmBusinessObject.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmBusinessObject.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("10e559dc-0775-46ef-a773-adfdf5a74aea")
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

    @objid ("6236a5da-c102-42b8-8c51-7bee8266357d")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmBusinessObject.", GmBusinessObject.MINOR_VERSION);

    }

    @objid ("bf65e61c-59e3-4f0c-9d06-2b5d1789d705")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("5e9c860d-017c-4071-a7e0-f6f96aa75d30")
    GmBusinessObject(final _GmBusinessObject oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmBusinessObjectPrimaryNode primary = new GmBusinessObjectPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("f9354a3f-5b87-43dc-b163-3b21648d5e0c")
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
