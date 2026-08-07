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
package org.modelio.archimate.diagrams.elements.courseofaction.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.courseofaction.GmCourseOfActionImageStyleKeys;
import org.modelio.archimate.diagrams.elements.courseofaction.GmCourseOfActionSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.courseofaction.GmCourseOfActionStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.courseofaction.GmCourseOfActionUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.strategy.behavior.CourseOfAction;
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
@objid ("1983594e-f6bc-4367-bb5d-9dad1cde635d")
public class _GmCourseOfAction extends GmArchiElement<CourseOfAction> {
    @objid ("6b89f702-672f-4a30-a8df-b514bcced52e")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("69b6c947-acbb-4af0-8912-24bfa291efa9")
    private static final int MINOR_VERSION = 0;

    @objid ("42474d3a-6e82-47fe-a0cc-8713b6adf406")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmCourseOfActionImageStyleKeys();

    @objid ("3583e2cf-8f69-4b48-9afe-2299e31e40fc")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmCourseOfActionSimpleStyleKeys();

    @objid ("717b4b57-ff28-45b3-83fd-9d0d1882962a")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmCourseOfActionStructuredStyleKeys();

    @objid ("ea80856e-3b81-4b6b-820f-0c360157328a")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmCourseOfActionUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the CourseOfAction is unmasked.
     * @param el the unmasked CourseOfAction.
     * @param ref a reference to the unmasked CourseOfAction.
     */
    @objid ("17f22f28-eef7-4ef3-b6ee-8be427794bea")
    public _GmCourseOfAction(IGmDiagram diagram, CourseOfAction el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("82a05f67-4678-4414-ab58-ef15ef7d9ff0")
    public _GmCourseOfAction() {
        // Nothing specific to do.
    }

    @objid ("ed5406a9-6a32-4ae0-b5ce-60b7ec458973")
    @Override
    public int getMajorVersion() {
        return _GmCourseOfAction.MAJOR_VERSION;
    }

    @objid ("3cbe82f5-b30e-4bd1-88f1-3a615955f19a")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmCourseOfAction.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmCourseOfAction.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmCourseOfAction.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmCourseOfAction.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmCourseOfAction.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("cb22b178-e308-4740-81df-7dfb9e375db7")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmCourseOfAction.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmCourseOfAction.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmCourseOfAction.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmCourseOfAction.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmCourseOfAction.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("ba3491f8-4a5f-4f76-9752-4e6e0ebf2720")
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

    @objid ("61a74767-7805-42df-a812-39b88d942951")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmCourseOfAction.", _GmCourseOfAction.MINOR_VERSION);

    }

    @objid ("6e4e92af-80a2-4e93-9899-e29c0ed3f1a8")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
