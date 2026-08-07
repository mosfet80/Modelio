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
 * This class provides the StyleKey constants for a GmFacility when its representation mode is RepresentationMode.IMAGE
 */
@objid ("245a8453-a288-468b-b05b-1e8d4632b065")
public class GmFacilityImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("d20fa52d-596d-4b32-96c0-ac26afce654b")
    static final StyleKey REPMODE = GmFacilityStructuredStyleKeys.REPMODE;

    @objid ("38b9275e-852c-41f8-86b2-2eb4625bc491")
    static final StyleKey FONT = GmFacilityStructuredStyleKeys.FONT;

    @objid ("000f515c-81d7-468d-bf3a-2f8bd8444bc5")
    static final StyleKey TEXTCOLOR = GmFacilityStructuredStyleKeys.TEXTCOLOR;

    @objid ("41362759-5068-4fb7-9ffb-469fc9419d75")
    static final StyleKey SHOWSTEREOTYPES = GmFacilityStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("6837d580-2616-4eed-88e2-577b9e06d345")
    static final StyleKey SHOWTAGS = GmFacilityStructuredStyleKeys.SHOWTAGS;

}
