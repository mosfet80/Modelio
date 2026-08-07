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
package org.modelio.archimate.diagrams.elements.resource;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.resource.v0._GmResource;
import org.modelio.archimate.metamodel.layers.strategy.structure.Resource;
import org.modelio.diagram.elements.common.portcontainer.GmPortContainer;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Resource}.
 */
@objid ("192857ef-d27c-4c33-8916-63af2a187f3b")
public class GmResource extends GmArchiElementPortContainer<Resource> {
    @objid ("c2bc464b-c514-4191-abb1-f5a45039986f")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("dbbaa99f-b09a-4f88-bf47-a218677d91b4")
    private static final int MINOR_VERSION = 0;

    @objid ("ac7cc76a-0564-431e-8044-a5b007a9f471")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmResourceImageStyleKeys();

    @objid ("2fff6be5-3f01-4b60-84ab-7b190e79f72c")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmResourceSimpleStyleKeys();

    @objid ("a7a11a03-12d6-4931-b287-e0f392444229")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmResourceStructuredStyleKeys();

    @objid ("183c5141-e083-4d2f-ba5e-04f6604fdf89")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmResourceUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Resource is unmasked.
     * @param el the unmasked Resource.
     * @param ref a reference to the unmasked Resource.
     */
    @objid ("c8a6161c-7131-43d7-af75-9e753bf99bd3")
    public GmResource(IGmDiagram diagram, Resource el, MRef ref) {
        super(diagram, el, ref);

        GmResourcePrimaryNode mainNode = new GmResourcePrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("79b51683-e2d2-46a9-973c-d8de4c493220")
    GmResource(final _GmResource oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmResourcePrimaryNode primary = new GmResourcePrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("b8a20181-cf54-47b7-87fe-c68b9e579625")
    @Override
    public int getMajorVersion() {
        return GmResource.MAJOR_VERSION;
    }

    @objid ("f45af317-d927-494b-967e-5f26668b5ba8")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmResource.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmResource.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmResource.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmResource.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmResource.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("62123297-4b55-44eb-95c7-de99e432f8ba")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmResource.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmResource.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmResource.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmResource.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmResource.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("38dcd843-2075-4b16-8078-b349ac03b7bf")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmResource.");
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

    @objid ("a5bc01b5-fdcc-4034-971a-7c54056a239e")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmResource.", MINOR_VERSION);

    }

    @objid ("6752fda8-1c64-4c9c-ad28-6ccf514028bc")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("66e80337-6e09-4ba7-8840-f07483d14cd3")
    public GmResource() {
        // Nothing specific to do.
    }

}
