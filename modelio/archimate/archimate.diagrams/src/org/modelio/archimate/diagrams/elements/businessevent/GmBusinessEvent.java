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
package org.modelio.archimate.diagrams.elements.businessevent;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessevent.v0._GmBusinessEvent;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessEvent;
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
 * Specialized class for {@link BusinessEvent}.
 */
@objid ("98e9878a-6ba1-4d61-8f0b-5fa7d4e11a47")
public class GmBusinessEvent extends GmArchiElementPortContainer<BusinessEvent> {
    @objid ("6893cc9f-9bfe-477a-b8b1-877c5136e5b7")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("d7388fa9-ef43-4729-b4df-9b14acdbdf31")
    private static final int MINOR_VERSION = 0;

    @objid ("b9512c6e-c074-4d66-aac9-25d5d62d7fc9")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmBusinessEventImageStyleKeys();

    @objid ("2c29f3e0-1dd4-446b-92ef-cf204052d25a")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmBusinessEventSimpleStyleKeys();

    @objid ("2bd6c075-9ede-4ae8-a88c-7c1950ab219a")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmBusinessEventStructuredStyleKeys();

    @objid ("db595199-f0cf-4485-86f2-771d264fd5f5")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmBusinessEventUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessEvent is unmasked.
     * @param el the unmasked BusinessEvent.
     * @param ref a reference to the unmasked BusinessEvent.
     */
    @objid ("55b1a361-02e3-46b3-b6dc-40ace8894cff")
    public GmBusinessEvent(IGmDiagram diagram, BusinessEvent el, MRef ref) {
        super(diagram, el, ref);

        GmBusinessEventPrimaryNode mainNode = new GmBusinessEventPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("19aae238-e6da-4aaf-8b8f-c9b5c26a0952")
    GmBusinessEvent(final _GmBusinessEvent oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmBusinessEventPrimaryNode primary = new GmBusinessEventPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("536608da-c64f-4f65-96e4-d8de3272ca0e")
    public GmBusinessEvent() {
        // Nothing specific to do.
    }

    @objid ("6716cd64-70a6-4b70-adef-b6701fdc51b7")
    @Override
    public int getMajorVersion() {
        return GmBusinessEvent.MAJOR_VERSION;
    }

    @objid ("a969e19c-9315-4aab-aacd-0c0aca0fd332")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmBusinessEvent.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmBusinessEvent.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmBusinessEvent.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmBusinessEvent.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmBusinessEvent.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("05199f35-3c6e-42c8-9284-cd4980095924")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmBusinessEvent.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmBusinessEvent.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmBusinessEvent.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmBusinessEvent.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmBusinessEvent.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("1bd854f2-901a-4f69-aca9-9873703a4f0a")
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

    @objid ("44f66d91-1fa2-4dc3-ac91-ebae51fb8cb9")
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

    @objid ("ef9dd40a-206a-4f62-8c4f-7fb2109d8054")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmBusinessEvent.", GmBusinessEvent.MINOR_VERSION);

    }

    @objid ("24e703f0-72c9-40b0-a21a-7497a0c3887c")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
