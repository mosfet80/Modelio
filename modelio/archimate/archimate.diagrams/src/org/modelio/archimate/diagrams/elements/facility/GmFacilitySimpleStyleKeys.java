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
package org.modelio.archimate.diagrams.elements.facility;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmFacility when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("186b4872-935c-492c-9a61-6cc452994b4c")
public class GmFacilitySimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("6f5702ca-2cfb-40ee-a904-3f32be21c273")
    static final StyleKey REPMODE = GmFacilityStructuredStyleKeys.REPMODE;

    @objid ("d5898afb-4357-4e22-ac45-65bc1a2a92ac")
    static final StyleKey FILLCOLOR = GmFacilityStructuredStyleKeys.FILLCOLOR;

    @objid ("d6760cdb-3847-4794-9fc5-3b041f1fda82")
    static final StyleKey FILLMODE = GmFacilityStructuredStyleKeys.FILLMODE;

    @objid ("084d9e49-c36d-406f-9218-54fe13273808")
    static final StyleKey LINECOLOR = GmFacilityStructuredStyleKeys.LINECOLOR;

    @objid ("58762c21-4694-4a24-aeaa-3a8e393add2f")
    static final StyleKey LINEWIDTH = GmFacilityStructuredStyleKeys.LINEWIDTH;

    @objid ("d34318dc-26a3-40ad-aa4d-6505b04017d5")
    static final StyleKey FONT = GmFacilityStructuredStyleKeys.FONT;

    @objid ("2e450865-0f19-4522-97be-c1efc1395961")
    static final StyleKey TEXTCOLOR = GmFacilityStructuredStyleKeys.TEXTCOLOR;

    @objid ("bc945e8e-2396-4bd0-b388-1b4ef40e2d9c")
    static final StyleKey SHOWSTEREOTYPES = GmFacilityStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("322d2948-0304-4e84-b706-6469981758ba")
    static final StyleKey SHOWTAGS = GmFacilityStructuredStyleKeys.SHOWTAGS;

}
