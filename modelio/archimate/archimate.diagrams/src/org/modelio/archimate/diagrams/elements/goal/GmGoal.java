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
package org.modelio.archimate.diagrams.elements.goal;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.goal.v0._GmGoal;
import org.modelio.archimate.metamodel.layers.motivation.Goal;
import org.modelio.diagram.elements.common.portcontainer.GmPortContainer;
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
 * Specialized class for {@link Goal}.
 */
@objid ("fafe1acc-dd04-4425-8b5b-763f4b61e8d6")
public class GmGoal extends GmArchiElementPortContainer<Goal> {
    @objid ("1dd3bdb8-d45e-4d0e-9e49-b5d2739f6724")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("0b92ba19-6fcd-4561-a14e-94eb278371a5")
    private static final int MINOR_VERSION = 0;

    @objid ("7c42a39d-d59a-452d-83c9-b38f01cc059d")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmGoalImageStyleKeys();

    @objid ("f99b8bf4-2446-4628-8c62-b1f33161df05")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmGoalSimpleStyleKeys();

    @objid ("5865e12c-2138-4725-aa33-232b751563f6")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmGoalStructuredStyleKeys();

    @objid ("f574cd85-2aa4-4296-aaa4-790566680f11")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmGoalUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Goal is unmasked.
     * @param el the unmasked Goal.
     * @param ref a reference to the unmasked Goal.
     */
    @objid ("ffac22d9-3992-49ef-b890-cde1bfbc0046")
    public GmGoal(IGmDiagram diagram, Goal el, MRef ref) {
        super(diagram, el, ref);

        GmGoalPrimaryNode mainNode = new GmGoalPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("706d8889-fc9d-4f13-8868-e578ab2d3e91")
    public GmGoal() {
        // Nothing specific to do.
    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("67230919-3dac-46b1-af6f-117dc381c419")
    GmGoal(final _GmGoal oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmGoalPrimaryNode primary = new GmGoalPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("b860a9c6-cc18-4fc3-9a8d-30dfb3b29ea0")
    @Override
    public int getMajorVersion() {
        return GmGoal.MAJOR_VERSION;
    }

    @objid ("2520c27f-25a5-4042-be87-5b008cd81a1b")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmGoal.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmGoal.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmGoal.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmGoal.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmGoal.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("fbf3915a-c453-4396-b07c-3b299381d259")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmGoal.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmGoal.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmGoal.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmGoal.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmGoal.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("214c8122-def3-4cac-b3a5-573680029e54")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmGoal.");
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

    @objid ("c37abc35-8f08-47ac-b999-2af13dac5585")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmGoal.", GmGoal.MINOR_VERSION);

    }

    @objid ("7f494949-da05-481d-a777-ba1927a93285")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
