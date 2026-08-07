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
package org.modelio.archimate.diagrams.elements.goal.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.goal.GmGoalImageStyleKeys;
import org.modelio.archimate.diagrams.elements.goal.GmGoalSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.goal.GmGoalStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.goal.GmGoalUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.motivation.Goal;
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
@objid ("23b11070-169a-478f-a5e1-4a42fcead8b8")
public class _GmGoal extends GmArchiElement<Goal> {
    @objid ("03ca84da-b38c-469f-b88c-f723b752ad43")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("6e949708-2366-46a7-a6a9-a3edcec7204f")
    private static final int MINOR_VERSION = 0;

    @objid ("82f14462-7978-4176-9d3f-8c8f7160065c")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmGoalImageStyleKeys();

    @objid ("55e5ee01-b511-4dcf-8ec6-122897a0e6f2")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmGoalSimpleStyleKeys();

    @objid ("973eab42-ec1a-46bd-b831-c61d323c528a")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmGoalStructuredStyleKeys();

    @objid ("7de772f3-bbe3-47d3-b601-42e7e559c2f0")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmGoalUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Goal is unmasked.
     * @param el the unmasked Goal.
     * @param ref a reference to the unmasked Goal.
     */
    @objid ("9d02c1c8-5ba8-42af-93d6-a4c762589fcb")
    public _GmGoal(IGmDiagram diagram, Goal el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("1c312a53-d2c1-4195-b36c-8daf00466b71")
    public _GmGoal() {
        // Nothing specific to do.
    }

    @objid ("19415011-7019-4912-8f83-30e0b3e6efb2")
    @Override
    public int getMajorVersion() {
        return _GmGoal.MAJOR_VERSION;
    }

    @objid ("f25b9595-bbdd-4b00-9a30-db44bf74c789")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmGoal.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmGoal.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmGoal.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmGoal.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmGoal.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("be9f8fdd-64ad-400b-8675-be76b012efff")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmGoal.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmGoal.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmGoal.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmGoal.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmGoal.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("0e7f0c29-7791-4ab8-867e-ce4462b4abe0")
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

    @objid ("deec9025-d333-466d-8de0-66a791b80e06")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmGoal.", _GmGoal.MINOR_VERSION);

    }

    @objid ("cc39cac6-1b39-4f83-b756-a94fb100bbbd")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
