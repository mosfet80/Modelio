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
package org.modelio.archimate.diagrams.elements.businessrole;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessrole.v0._GmBusinessRole;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.business.structure.active.BusinessRole;
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
 * Specialized class for {@link BusinessRole}.
 */
@objid ("bfe04716-1717-41c6-997d-1f637533f33b")
public class GmBusinessRole extends GmArchiElementPortContainer<BusinessRole> {
    @objid ("41d4815b-f8cc-4db4-a24e-cf780015f101")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("f91a8a33-cd02-468b-9eed-24e3761e568e")
    private static final int MINOR_VERSION = 0;

    @objid ("01e82840-36e9-483b-aad2-84133a3b95c0")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmBusinessRoleImageStyleKeys();

    @objid ("56fd1464-7fbd-42b1-9d81-34e0bc91a3ae")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmBusinessRoleSimpleStyleKeys();

    @objid ("ce8e14b5-ae94-4838-83bd-d72d150a9993")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmBusinessRoleStructuredStyleKeys();

    @objid ("8e55ce31-46d7-4ed3-9d2d-b0bc86715332")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmBusinessRoleUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessRole is unmasked.
     * @param el the unmasked BusinessRole.
     * @param ref a reference to the unmasked BusinessRole.
     */
    @objid ("f30cbd03-add1-4945-8240-0080ed9dcbad")
    public GmBusinessRole(IGmDiagram diagram, BusinessRole el, MRef ref) {
        super(diagram, el, ref);

        GmBusinessRolePrimaryNode mainNode = new GmBusinessRolePrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("ed784b3f-263f-4309-a285-a4ed780e2f87")
    public GmBusinessRole() {
        // Nothing specific to do.
    }

    @objid ("f59392f0-2494-4874-9775-a853bae90a0b")
    @Override
    public int getMajorVersion() {
        return GmBusinessRole.MAJOR_VERSION;
    }

    @objid ("7810055b-5866-48c5-8e9f-836fa00ef08c")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmBusinessRole.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmBusinessRole.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmBusinessRole.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmBusinessRole.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmBusinessRole.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("382c1620-bfcf-4c72-875e-5228dc9f2e85")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmBusinessRole.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmBusinessRole.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmBusinessRole.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmBusinessRole.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmBusinessRole.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("7406aca0-10aa-4b80-97b9-87a644945c1e")
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

    @objid ("2263921d-bdc5-4223-b01e-3b1991461566")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmBusinessRole.", GmBusinessRole.MINOR_VERSION);

    }

    @objid ("b64bcd6c-d8d3-408c-a412-c075954487af")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("43b29ee2-278e-4cc8-a622-3a27a21cc383")
    GmBusinessRole(final _GmBusinessRole oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmBusinessRolePrimaryNode primary = new GmBusinessRolePrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("da9f69b6-1607-49ab-bc6a-555f6f6de5c1")
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
