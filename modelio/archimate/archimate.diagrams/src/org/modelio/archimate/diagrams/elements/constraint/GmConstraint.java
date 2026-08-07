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
package org.modelio.archimate.diagrams.elements.constraint;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.constraint.v0._GmConstraint;
import org.modelio.archimate.metamodel.layers.motivation.Constraint;
import org.modelio.diagram.elements.common.portcontainer.GmPortContainer;
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
 * Specialized class for {@link Constraint}.
 */
@objid ("129f4927-fd4e-4cbd-ba68-9833753e846b")
public class GmConstraint extends GmArchiElementPortContainer<Constraint> {
    @objid ("cc2cf926-9f1b-455e-ade6-9cd1c2b81902")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("67bb5222-18c7-4567-8240-b0857c2e698d")
    private static final int MINOR_VERSION = 0;

    @objid ("fdaa4db7-2007-4ff1-a584-34bdf0042190")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmConstraintImageStyleKeys();

    @objid ("b2476627-6e62-4fb1-95a4-ac08db70bb0b")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmConstraintSimpleStyleKeys();

    @objid ("52552e5b-9012-452d-bdae-6a8aa6b8c57d")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmConstraintStructuredStyleKeys();

    @objid ("5914ecd5-0bf9-4f1a-b6a4-cd15ebe6ad82")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmConstraintUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Constraint is unmasked.
     * @param el the unmasked Constraint.
     * @param ref a reference to the unmasked Constraint.
     */
    @objid ("fb9257ef-c2aa-49f5-89c6-d658fabf0305")
    public GmConstraint(IGmDiagram diagram, Constraint el, MRef ref) {
        super(diagram, el, ref);

        GmConstraintPrimaryNode mainNode = new GmConstraintPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("d84fc09f-50e5-4192-b1bb-bd02289231a6")
    public GmConstraint() {
        // Nothing specific to do.
    }

    @objid ("7a1d2abc-258d-4724-b531-78827dbd14d2")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("39328bc0-8c9d-4dc4-8ce2-7105f3637d10")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("4698ac39-3b8a-4e55-bb76-64a3b95d6060")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("422076e8-3a49-4a94-af24-02039d6e7191")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmConstraint.");
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

    @objid ("80134823-ae64-4980-a129-78b86bad220b")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmConstraint.", MINOR_VERSION);

    }

    @objid ("15a697cf-da54-4062-a154-fbc11dbb59bc")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("aa3f1444-930f-427c-a6be-5b1f137c7499")
    GmConstraint(final _GmConstraint oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmConstraintPrimaryNode primary = new GmConstraintPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("45fe96b7-8865-4d97-be4e-7341fc6f5290")
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
