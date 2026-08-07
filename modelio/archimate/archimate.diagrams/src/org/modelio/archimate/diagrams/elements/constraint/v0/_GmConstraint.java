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
package org.modelio.archimate.diagrams.elements.constraint.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.constraint.GmConstraintImageStyleKeys;
import org.modelio.archimate.diagrams.elements.constraint.GmConstraintSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.constraint.GmConstraintStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.constraint.GmConstraintUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.motivation.Constraint;
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
 * Specialized class for {@link Constraint}.
 */
@objid ("7503fd06-f7ab-4750-921a-bbb26d5124f1")
public class _GmConstraint extends GmArchiElement<Constraint> {
    @objid ("b9f0495a-f829-4a65-ad29-90b3baab16bb")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("88f63e50-7214-46d9-a07d-e3f361630455")
    private static final int MINOR_VERSION = 0;

    @objid ("1ae17c14-8d2a-47eb-a651-45a2380ecbe6")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmConstraintImageStyleKeys();

    @objid ("8148577d-6054-462b-b2bb-819ec2f59b07")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmConstraintSimpleStyleKeys();

    @objid ("2b28e75c-750c-4273-bae5-135844f34526")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmConstraintStructuredStyleKeys();

    @objid ("68fe2249-1317-424c-bf32-14e378c1e920")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmConstraintUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Constraint is unmasked.
     * @param el the unmasked Constraint.
     * @param ref a reference to the unmasked Constraint.
     */
    @objid ("0dbfe742-8193-4182-a0a5-af690770287e")
    public _GmConstraint(IGmDiagram diagram, Constraint el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("ea9cc95b-8a32-4e27-a7bc-e46fb780c67e")
    public _GmConstraint() {
        // Nothing specific to do.
    }

    @objid ("828e4be0-a683-412c-a772-9897c24baa77")
    @Override
    public int getMajorVersion() {
        return _GmConstraint.MAJOR_VERSION;
    }

    @objid ("6512b2ab-7a70-438f-8f93-b8bf7a55b92a")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmConstraint.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmConstraint.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmConstraint.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmConstraint.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmConstraint.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("58b8e5ef-7aea-444c-9b50-4b1cb50b073b")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmConstraint.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmConstraint.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmConstraint.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmConstraint.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmConstraint.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("00448d99-cb45-4e9c-888e-474b57dae357")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmConstraint.");
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

    @objid ("10277453-3733-4b72-9287-05cfbb24026d")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmConstraint.", _GmConstraint.MINOR_VERSION);

    }

    @objid ("b18b138b-b595-41fc-a9bd-28cf31e81acf")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
