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
package org.modelio.archimate.diagrams.elements.dataobject;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.dataobject.v0._GmDataObject;
import org.modelio.archimate.metamodel.layers.application.structure.passive.DataObject;
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
 * Specialized class for {@link DataObject}.
 */
@objid ("62564a78-e4a1-4862-891e-9cce97327ce0")
public class GmDataObject extends GmArchiElementPortContainer<DataObject> {
    @objid ("545a96ac-faa2-46e6-8c7f-ca1e423323e3")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("298d7c2d-df5e-45ce-96b7-239be293e6d9")
    private static final int MINOR_VERSION = 0;

    @objid ("56da1c7f-ca0d-42a3-892f-d07cf1bab2b6")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmDataObjectImageStyleKeys();

    @objid ("d63f9cb3-3856-4915-812a-f10d159d0be9")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmDataObjectSimpleStyleKeys();

    @objid ("4474e86e-f94c-4114-afa3-9b05e1c4265c")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmDataObjectStructuredStyleKeys();

    @objid ("89589eb2-4ffa-40c1-a43f-cb5d66fb49b6")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmDataObjectUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the DataObject is unmasked.
     * @param el the unmasked DataObject.
     * @param ref a reference to the unmasked DataObject.
     */
    @objid ("1125f43a-52a4-4e25-8681-2e9b45b7121d")
    public GmDataObject(IGmDiagram diagram, DataObject el, MRef ref) {
        super(diagram, el, ref);

        GmDataObjectPrimaryNode mainNode = new GmDataObjectPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("e6045fef-f447-4a33-88bb-53f1ee4204ee")
    public GmDataObject() {
        // Nothing specific to do.
    }

    @objid ("8ad3d2a8-be56-4a76-9eae-f61ec3c27604")
    @Override
    public int getMajorVersion() {
        return GmDataObject.MAJOR_VERSION;
    }

    @objid ("ccb788e1-db6a-4a03-af38-47e103ac8dd9")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmDataObject.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmDataObject.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmDataObject.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmDataObject.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmDataObject.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("5eba2757-a85f-4f26-9ba6-59ac4aae8038")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmDataObject.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmDataObject.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmDataObject.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmDataObject.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmDataObject.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("1f7543f1-2e90-4181-8149-f622b2d252ac")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmDataObject.");
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

    @objid ("114db9a6-3fc0-4a4d-bd2b-885eba643bbf")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmDataObject.", GmDataObject.MINOR_VERSION);

    }

    @objid ("1bf61697-5910-4784-beae-c65df5b0e1e6")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("1bf9dd2f-72d3-481c-9fee-0b4689f7152f")
    GmDataObject(final _GmDataObject oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmDataObjectPrimaryNode primary = new GmDataObjectPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("bf561085-c252-4d2f-984b-7700b08b3c7a")
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
