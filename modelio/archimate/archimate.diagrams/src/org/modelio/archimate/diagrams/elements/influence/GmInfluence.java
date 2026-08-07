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
package org.modelio.archimate.diagrams.elements.influence;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archilink.GmArchiRelationship;
import org.modelio.archimate.metamodel.relationships.dependency.Influence;
import org.modelio.diagram.elements.core.link.ExtensionLocation;
import org.modelio.diagram.elements.core.link.extensions.IGmLocator;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Graphic model for {@link Influence}.
 */
@objid ("73892896-d61d-4d4c-b50f-0d9ba6b0f9d7")
public class GmInfluence extends GmArchiRelationship<Influence> {
    @objid ("3e3719ba-9e1a-4bbe-99e6-dbde55a464c4")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("eb5a1df2-4851-4fb0-bb70-1388fffb5f17")
    private static final int MINOR_VERSION = 2;

    @objid ("087d6301-9969-40ae-9d55-f9f59548f3b1")
    private static final String ROLE_STRENGTH_LABEL = "strength_label";

    /**
     * Style keys.
     */
    @objid ("20e37887-bd64-4bb0-96d6-9550717a665e")
    public static final GmInfluenceLinkStyleKeys styleKeyProvider = new GmInfluenceLinkStyleKeys();

    /**
     * Initialize a graphic model.
     *
     * @param diagram The owning diagram.
     * @param elt The link element, may be <code>null</code>.
     * @param ref The link reference, may not be <code>null</code>.
     */
    @objid ("d919f949-c684-43b7-bd53-2478913a34c2")
    public GmInfluence(IGmDiagram diagram, Influence elt, MRef ref) {
        super(diagram, elt, ref);

        addExtension(ExtensionLocation.MiddleSE, IGmLink.ROLE_MAIN_LABEL, (GmNodeModel) getFirstExtension(IGmLink.ROLE_MAIN_LABEL));
        addExtension(ExtensionLocation.MiddleNW, GmInfluence.ROLE_STRENGTH_LABEL, new GmInfluenceStrengthLabel(diagram, ref));

    }

    /**
     * For deserialization only.
     */
    @objid ("7cbebd08-c29a-4e41-b182-a2c5ae60983c")
    public GmInfluence() {
        // Empty
    }

    @objid ("9180e6d9-f409-4f6c-abdf-8eb552c280ff")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        return GmInfluence.styleKeyProvider.getStyleKey(metakey);
    }

    @objid ("e7d1431e-3278-4069-9f05-5595b19b9d63")
    @Override
    public List<StyleKey> getStyleKeys() {
        return GmInfluence.styleKeyProvider.getStyleKeys();
    }

    @objid ("dbb88aeb-2341-405d-b90d-8dd0d70eed3f")
    @Override
    protected void readLink(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmInfluence.");
        switch (readVersion) {
        case 0: {
            read_0(in);
            break;
        }
        case 1: {
            read_1(in);
            break;
        }
        case 2: {
            read_2(in);
            break;
        }
        default: {
            assert (false) : readVersion + " version number not covered!";
            // reading as last handled version: 2
            read_2(in);
            break;
        }
        }

    }

    @objid ("ef0a023b-f824-4164-a3bf-0d6744180bf3")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmInfluence.", GmInfluence.MINOR_VERSION);

    }

    @objid ("4105a8cf-9016-4bb8-8fa3-5e07c46c1d0b")
    @Override
    public int getMajorVersion() {
        return GmInfluence.MAJOR_VERSION;
    }

    @objid ("9d0dd14d-6c71-458c-b492-ede4bdeb53e1")
    private void read_0(IDiagramReader in) {
        read_1(in);

        // Move main label from Middle NW to middle SE
        addExtension(ExtensionLocation.MiddleSE, IGmLink.ROLE_MAIN_LABEL, (GmNodeModel) getFirstExtension(IGmLink.ROLE_MAIN_LABEL));

        // Add Strength label
        if (getExtensions(GmInfluence.ROLE_STRENGTH_LABEL).isEmpty()) {
            addExtension(ExtensionLocation.MiddleNW, GmInfluence.ROLE_STRENGTH_LABEL, new GmInfluenceStrengthLabel(getDiagram(), getRepresentedRef()));
        }

    }

    /**
     * Modelio 3.7.0 -> Modelio 3.7.1 migration.
     * Reset width and height values for strength label.
     */
    @objid ("a1072854-1370-43d5-8908-a9e5a36955f0")
    private void read_1(IDiagramReader in) {
        read_2(in);

        for (GmNodeModel n : getExtensions()) {
            if (n.getRoleInComposition().equals(GmInfluence.ROLE_STRENGTH_LABEL)) {
                IGmLocator layoutContraint = getLayoutContraint(n);
                if (layoutContraint.getWidthConstraint() != -1) {
                    layoutContraint.setWidthConstraint(-1);
                }
                if (layoutContraint.getHeightConstraint() != -1) {
                    layoutContraint.setHeightConstraint(-1);
                }
            }
        }

    }

    @objid ("f0270a1b-6e84-4a8f-abda-774d2a52453c")
    private void read_2(IDiagramReader in) {
        super.readLink(in);
    }

}
