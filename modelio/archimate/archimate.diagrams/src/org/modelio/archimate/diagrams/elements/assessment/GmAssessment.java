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
package org.modelio.archimate.diagrams.elements.assessment;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.assessment.v0._GmAssessment;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.motivation.Assessment;
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
 * Specialized class for {@link Assessment}.
 */
@objid ("e2639667-0318-44b4-a6ee-5d35e1a41617")
public class GmAssessment extends GmArchiElementPortContainer<Assessment> {
    @objid ("95d26dcb-f6c8-4fb9-8294-91f16071920f")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("d4917bf4-a7d9-40cf-b640-d04aee37f616")
    private static final int MINOR_VERSION = 0;

    @objid ("b8ffd398-712d-43a9-b8cb-2a7615e6156b")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmAssessmentImageStyleKeys();

    @objid ("2181b6d0-176f-4a42-93aa-bd8d97de35c3")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmAssessmentSimpleStyleKeys();

    @objid ("2948f488-0844-4484-93c5-c1cbb99e1f9f")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmAssessmentStructuredStyleKeys();

    @objid ("1de37e99-a87d-4e56-9fea-102606502b59")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmAssessmentUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Assessment is unmasked.
     * @param el the unmasked Assessment.
     * @param ref a reference to the unmasked Assessment.
     */
    @objid ("0388ada7-7780-4f3a-bd0e-655292e58f5b")
    public GmAssessment(IGmDiagram diagram, Assessment el, MRef ref) {
        super(diagram, el, ref);

        GmAssessmentPrimaryNode mainNode = new GmAssessmentPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("8600d434-62d6-4b22-8b74-dadc6cb41b4e")
    public GmAssessment() {
        // Nothing specific to do.
    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("c6f6a43b-ae94-47f2-8ea7-d783857ef1dd")
    GmAssessment(final _GmAssessment oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmAssessmentPrimaryNode primary = new GmAssessmentPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("7f142dc5-07ba-4e63-915a-cd3802b286fd")
    @Override
    public int getMajorVersion() {
        return GmAssessment.MAJOR_VERSION;
    }

    @objid ("5f605a3d-c77c-4fe4-a92e-efbedd6c5800")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmAssessment.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmAssessment.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmAssessment.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmAssessment.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmAssessment.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("e2cbd12f-019a-4431-920a-3a2746c51481")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmAssessment.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmAssessment.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmAssessment.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmAssessment.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmAssessment.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("7d4c59f5-60bf-4dda-9ea6-0b0415442ac2")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmAssessment.");
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

    @objid ("2c92df71-b3e5-4826-a774-b390186b95b3")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmAssessment.", GmAssessment.MINOR_VERSION);

    }

    @objid ("fa177f09-d768-4e2a-b30f-86e4991713ac")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
