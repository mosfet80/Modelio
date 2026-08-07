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
package org.modelio.archimate.diagrams.elements.businessservice;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessservice.v0._GmBusinessService;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessService;
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
 * Specialized class for {@link BusinessService}.
 */
@objid ("c6bf4d1d-0676-432e-83ed-047a0295083f")
public class GmBusinessService extends GmArchiElementPortContainer<BusinessService> {
    @objid ("f4d3b551-7105-4d81-b4a6-7df7397de815")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("0b813f07-7335-4c32-8c90-1db71f92f802")
    private static final int MINOR_VERSION = 0;

    @objid ("4b5acc24-18a5-42cc-9c98-91b7426bb52e")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmBusinessServiceImageStyleKeys();

    @objid ("60cd3e62-b001-49a3-aa29-4023b5f71844")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmBusinessServiceSimpleStyleKeys();

    @objid ("6a440dc2-45f6-4daf-8923-8bd35ee7eb59")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmBusinessServiceStructuredStyleKeys();

    @objid ("e3f1ad4e-d1de-4378-b48c-4f028a253a10")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmBusinessServiceUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessService is unmasked.
     * @param el the unmasked BusinessService.
     * @param ref a reference to the unmasked BusinessService.
     */
    @objid ("b1d99e8d-8d07-42b8-9882-212e0c449208")
    public GmBusinessService(IGmDiagram diagram, BusinessService el, MRef ref) {
        super(diagram, el, ref);

        GmBusinessServicePrimaryNode mainNode = new GmBusinessServicePrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("805d76ce-0548-4d18-a05e-04200a0b1506")
    public GmBusinessService() {
        // Nothing specific to do.
    }

    @objid ("aefe9ac8-fc28-492c-a72e-8d657bfae0bb")
    @Override
    public int getMajorVersion() {
        return GmBusinessService.MAJOR_VERSION;
    }

    @objid ("5f6d06f5-7748-4e87-b541-b00481e25f94")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmBusinessService.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmBusinessService.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmBusinessService.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmBusinessService.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmBusinessService.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("565f24f4-61d2-4314-a166-dfb5f1fd71d5")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmBusinessService.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmBusinessService.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmBusinessService.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmBusinessService.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmBusinessService.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("f6d24240-5965-4c2d-ac3f-39c7026b3c66")
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

    @objid ("dd28079e-f11e-4884-8b2c-bf97f500dfc3")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmBusinessService.", GmBusinessService.MINOR_VERSION);

    }

    @objid ("b2ddce3c-386e-4115-a3f7-5804a8a32eaa")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("2ae75f92-1b99-4bdd-aa3f-31ca37ba5baa")
    GmBusinessService(final _GmBusinessService oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmBusinessServicePrimaryNode primary = new GmBusinessServicePrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("7a0c1841-1f62-4fc1-ab36-fe7cbb171c30")
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
