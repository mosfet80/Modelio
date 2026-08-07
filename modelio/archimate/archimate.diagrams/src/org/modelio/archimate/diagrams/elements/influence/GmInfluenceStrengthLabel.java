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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.relationships.dependency.Influence;
import org.modelio.archimate.metamodel.relationships.dependency.InfluenceStrength;
import org.modelio.diagram.elements.common.label.base.GmElementLabel;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Label for the Strength of an {@link Influence} relationship.
 */
@objid ("3ec1bb7b-6d8c-40c7-acec-33c08e532abf")
public class GmInfluenceStrengthLabel extends GmElementLabel {
    /**
     * Current version of this Gm. Defaults to 0.
     */
    @objid ("8904c4be-5d0a-458b-99ed-88523fc4a5d6")
    private static final int MINOR_VERSION = 0;

    @objid ("1c2ebf6f-e8f5-4220-8a0d-02370192f9fb")
    private static final int MAJOR_VERSION = 0;

    @objid ("fa738884-2060-4bf1-a2cc-3c29ca4b8769")
    @Override
    protected String computeLabel() {
        Influence influence = (Influence) getRelatedElement();
        if (influence != null && influence.isValid()) {
            switch (influence.getStrength()) {
            case InfluenceStrength.STRONGLYNEGATIVE_NAME:
                return "--";
            case InfluenceStrength.SLIGHTLYNEGATIVE_NAME:
                return "-";
            case InfluenceStrength.SLIGHTLYPOSITIVE_NAME:
                return "+";
            case InfluenceStrength.STRONGLYPOSITIVE_NAME:
                return "++";
            case InfluenceStrength.ZERO_NAME:
                return "0";
            case InfluenceStrength.ONE_NAME:
                return "1";
            case InfluenceStrength.TWO_NAME:
                return "2";
            case InfluenceStrength.THREE_NAME:
                return "3";
            case InfluenceStrength.FOUR_NAME:
                return "4";
            case InfluenceStrength.FIVE_NAME:
                return "5";
            case InfluenceStrength.SIX_NAME:
                return "6";
            case InfluenceStrength.SEVEN_NAME:
                return "7";
            case InfluenceStrength.EIGHT_NAME:
                return "8";
            case InfluenceStrength.NINE_NAME:
                return "9";
            case InfluenceStrength.TEN_NAME:
                return "10";
            case InfluenceStrength.UNDEFINED_NAME:
            case "":
                return "+/-";
            default:
                return influence.getStrength();
            }
        }
        return "+/-";
    }

    /**
     * Empty c'tor for deserialisation.
     */
    @objid ("f82f7ae7-effc-4a6c-b339-f35f97106871")
    public GmInfluenceStrengthLabel() {
        super();
    }

    /**
     * C'tor.
     *
     * @param diagram the diagram in which this gm is created.
     * @param relatedRef a reference to the represented element.
     */
    @objid ("e2100f9f-ed42-4376-9f05-f49b62bcc498")
    public GmInfluenceStrengthLabel(final IGmDiagram diagram, final MRef relatedRef) {
        super(diagram, relatedRef);
    }

    @objid ("ff7aace5-c429-45a1-a308-92b94c8ab431")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmInfluenceStrengthLabel.");
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

    @objid ("9906beff-0904-4e51-9a2c-6979fbc5e535")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmInfluenceStrengthLabel.", GmInfluenceStrengthLabel.MINOR_VERSION);

    }

    @objid ("bc7186fa-fb9f-4087-884c-43e8b405e726")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("295e5ae3-0453-4c85-828b-78c57c9e7537")
    @Override
    public int getMajorVersion() {
        return GmInfluenceStrengthLabel.MAJOR_VERSION;
    }

    @objid ("3fb441d1-153d-4e81-9bba-69c0058df323")
    @Override
    public boolean isWrapped() {
        return false;
    }

}
