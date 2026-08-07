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
package org.modelio.archimate.diagrams.elements.applicationevent;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.applicationevent.v0._GmApplicationEvent;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationEvent;
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
 * Specialized class for {@link ApplicationEvent}.
 */
@objid ("9969cd40-7615-4e4f-a556-9952b4580618")
public class GmApplicationEvent extends GmArchiElementPortContainer<ApplicationEvent> {
    @objid ("04f006c3-6081-4a51-b67b-3a51107ddf9a")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("8138ecaf-a765-434a-b242-912d7ba673cb")
    private static final int MINOR_VERSION = 0;

    @objid ("68e11885-8040-48a8-941e-e8bd6df3022f")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmApplicationEventImageStyleKeys();

    @objid ("4f0ef575-224b-44be-8e5b-05afb33d07a6")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmApplicationEventSimpleStyleKeys();

    @objid ("e9e05482-f9c6-4430-8216-9ad80192a64f")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmApplicationEventStructuredStyleKeys();

    @objid ("c81b63d4-2bba-4381-b1b7-efd92c5ec844")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmApplicationEventUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ApplicationEvent is unmasked.
     * @param el the unmasked ApplicationEvent.
     * @param ref a reference to the unmasked ApplicationEvent.
     */
    @objid ("98a3f978-823f-42a8-a8c3-8bf1c7ff65d1")
    public GmApplicationEvent(IGmDiagram diagram, ApplicationEvent el, MRef ref) {
        super(diagram, el, ref);

        GmApplicationEventPrimaryNode mainNode = new GmApplicationEventPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("135d2570-d3b4-437e-914f-804890940af1")
    GmApplicationEvent(final _GmApplicationEvent oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmApplicationEventPrimaryNode primary = new GmApplicationEventPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("e34c97ad-2aa9-4015-8b58-1ae594040a8c")
    public GmApplicationEvent() {
        // Nothing specific to do.
    }

    @objid ("adff6a48-1d2d-43d3-bba3-82a84dd85f1e")
    @Override
    public int getMajorVersion() {
        return GmApplicationEvent.MAJOR_VERSION;
    }

    @objid ("1d4d0e69-0438-4fc8-9bd8-676322575631")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmApplicationEvent.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmApplicationEvent.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmApplicationEvent.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmApplicationEvent.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmApplicationEvent.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("353453f3-698c-4735-bcdf-ec49833d77da")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmApplicationEvent.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmApplicationEvent.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmApplicationEvent.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmApplicationEvent.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmApplicationEvent.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("4c03e6fe-b77a-4ad8-86ff-f26dc72daef5")
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

    @objid ("7debe480-e6c6-41b5-a194-ced7adb44b91")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmApplicationEvent.");
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

    @objid ("642aaeb1-6217-47a9-b716-d70dac01e8fa")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmApplicationEvent.", GmApplicationEvent.MINOR_VERSION);

    }

    @objid ("efdacf4e-8bf1-45dd-b5bc-bb4430e2502c")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
