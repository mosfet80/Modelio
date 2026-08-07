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
package org.modelio.archimate.diagrams.elements.deliverable;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.deliverable.v0._GmDeliverable;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.Deliverable;
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
 * Specialized class for {@link Deliverable}.
 */
@objid ("6d355d84-fba9-44e7-91c3-92eb53ea38f2")
public class GmDeliverable extends GmArchiElementPortContainer<Deliverable> {
    @objid ("594b364f-0e73-48d4-88fb-7a258e4d12d9")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("fb2687a6-d8dd-46f9-99d0-d4f2388c8e66")
    private static final int MINOR_VERSION = 0;

    @objid ("bfab52b2-b3a6-42b6-9b43-ce9a1297afa4")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmDeliverableImageStyleKeys();

    @objid ("dd17c2ee-60aa-4b73-b328-9bbbc4d083f9")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmDeliverableSimpleStyleKeys();

    @objid ("f51ae247-09b2-4abf-903b-0bad32b5bf66")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmDeliverableStructuredStyleKeys();

    @objid ("562a6ab3-c6f2-44a4-9885-5868f77019c5")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmDeliverableUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Deliverable is unmasked.
     * @param el the unmasked Deliverable.
     * @param ref a reference to the unmasked Deliverable.
     */
    @objid ("7359f71c-4901-4069-97f2-27bf0ceb241c")
    public GmDeliverable(IGmDiagram diagram, Deliverable el, MRef ref) {
        super(diagram, el, ref);

        GmDeliverablePrimaryNode mainNode = new GmDeliverablePrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("930441e2-b361-40fd-b612-b689c40e7e22")
    public GmDeliverable() {
        // Nothing specific to do.
    }

    @objid ("efd53add-0122-4342-b14d-a9dc93a054dd")
    @Override
    public int getMajorVersion() {
        return GmDeliverable.MAJOR_VERSION;
    }

    @objid ("f7bc1dd2-c06b-40a1-ac9c-dff959b0cf4b")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmDeliverable.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmDeliverable.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmDeliverable.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmDeliverable.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmDeliverable.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("9c20ebd4-f279-414f-9899-10a2100a5097")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmDeliverable.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmDeliverable.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmDeliverable.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmDeliverable.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmDeliverable.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("85d225e9-21bc-40e7-9226-17457ff16998")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmDeliverable.");
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

    @objid ("d95ad2b7-1419-4345-b3a8-c1004cfad6af")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmDeliverable.", GmDeliverable.MINOR_VERSION);

    }

    @objid ("718fa0bf-3f9c-4473-8811-e1f7e33107fb")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("6574d497-43f2-4b64-b3a4-c0c2b85cde35")
    GmDeliverable(final _GmDeliverable oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmDeliverablePrimaryNode primary = new GmDeliverablePrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("2c7d8c6d-e3f3-4716-9fd6-90c890983d82")
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
