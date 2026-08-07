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
package org.modelio.archimate.diagrams.elements.distributionnetwork;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmDistributionNetwork when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("80583ac1-ba15-4098-8081-7b403c87dbf2")
public class GmDistributionNetworkSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("05659ad8-9ef9-4ea5-9b7b-55e0092313b5")
    static final StyleKey REPMODE = GmDistributionNetworkStructuredStyleKeys.REPMODE;

    @objid ("3f8047fd-d7a5-4374-b9a5-24d08e7bb728")
    static final StyleKey LINECOLOR = GmDistributionNetworkStructuredStyleKeys.LINECOLOR;

    @objid ("f9e84b30-d9ce-49d5-ad0d-15aebc74800e")
    static final StyleKey FONT = GmDistributionNetworkStructuredStyleKeys.FONT;

    @objid ("4763db2b-af5b-4cf4-bbfa-42ea706da076")
    static final StyleKey TEXTCOLOR = GmDistributionNetworkStructuredStyleKeys.TEXTCOLOR;

    @objid ("e3639a3b-2628-4e88-915f-aff6f70c3c79")
    static final StyleKey SHOWSTEREOTYPES = GmDistributionNetworkStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("54249d3d-6cc2-40d0-8be5-dc570230ea68")
    static final StyleKey SHOWTAGS = GmDistributionNetworkStructuredStyleKeys.SHOWTAGS;

    @objid ("7cc498e2-23ca-4964-b2fb-23f4fdcd7a25")
    static final StyleKey FILLCOLOR = GmDistributionNetworkStructuredStyleKeys.FILLCOLOR;

}
