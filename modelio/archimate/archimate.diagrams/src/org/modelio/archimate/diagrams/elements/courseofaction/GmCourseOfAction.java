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
package org.modelio.archimate.diagrams.elements.courseofaction;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.courseofaction.v0._GmCourseOfAction;
import org.modelio.archimate.metamodel.layers.strategy.behavior.CourseOfAction;
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
 * Specialized class for {@link CourseOfAction}.
 */
@objid ("b888169b-efe0-4500-85d7-7956bd832004")
public class GmCourseOfAction extends GmArchiElementPortContainer<CourseOfAction> {
    @objid ("9b72ef32-8899-47fd-98f6-433f9d3401fb")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("424bb7ad-7127-4709-b229-0bf81e23d38d")
    private static final int MINOR_VERSION = 0;

    @objid ("7a9e137f-821d-41ae-ba5a-73d71cc590e6")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmCourseOfActionImageStyleKeys();

    @objid ("0757cd01-527e-4203-afae-c4bea306fd74")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmCourseOfActionSimpleStyleKeys();

    @objid ("7cc283c9-1102-43c8-bdb4-8395d98d0363")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmCourseOfActionStructuredStyleKeys();

    @objid ("6b9abb8b-7476-4f7e-9719-12372e7586c3")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmCourseOfActionUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the CourseOfAction is unmasked.
     * @param el the unmasked CourseOfAction.
     * @param ref a reference to the unmasked CourseOfAction.
     */
    @objid ("0ac578fe-2b04-4959-8608-5f189b0900c9")
    public GmCourseOfAction(IGmDiagram diagram, CourseOfAction el, MRef ref) {
        super(diagram, el, ref);

        GmCourseOfActionPrimaryNode mainNode = new GmCourseOfActionPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("ef6c28ba-5dfe-4d32-872a-4bdaf11fefab")
    public GmCourseOfAction() {
        // Nothing specific to do.
    }

    @objid ("d4cbc5e4-5467-40ae-8970-66bc1c59a207")
    @Override
    public int getMajorVersion() {
        return GmCourseOfAction.MAJOR_VERSION;
    }

    @objid ("80077a3d-38f0-40e4-8100-bc110c10f2b1")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmCourseOfAction.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmCourseOfAction.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmCourseOfAction.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmCourseOfAction.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmCourseOfAction.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("a15c2370-0c25-4149-865f-dda82106e7e8")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmCourseOfAction.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmCourseOfAction.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmCourseOfAction.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmCourseOfAction.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmCourseOfAction.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("9ada3a1c-ced2-4ca8-a958-c40753989761")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmCourseOfAction.");
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

    @objid ("d5551c76-bf7e-4d03-8ae0-4728c320bd82")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmCourseOfAction.", GmCourseOfAction.MINOR_VERSION);

    }

    @objid ("79ad350e-6e40-49c5-8677-bf116f525f8f")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("10d7e21c-1c0c-4268-8e9f-b8fea35cba7a")
    GmCourseOfAction(final _GmCourseOfAction oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmCourseOfActionPrimaryNode primary = new GmCourseOfActionPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

}
