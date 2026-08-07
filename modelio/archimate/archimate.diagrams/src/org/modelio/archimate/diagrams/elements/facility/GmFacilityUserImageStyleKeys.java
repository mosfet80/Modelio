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
@objid ("6e293c14-5987-4240-86ae-d0caf75be1b4")
public class GmFacilityUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("89efe0a9-8701-47e8-959e-f135f0f9c9dd")
    static final StyleKey REPMODE = GmFacilityStructuredStyleKeys.REPMODE;

    @objid ("901d66d6-2aa2-449c-b90c-0d7209c533f9")
    static final StyleKey FONT = GmFacilityStructuredStyleKeys.FONT;

    @objid ("60e74507-a5f6-4e7f-83df-cc8dc4e96107")
    static final StyleKey TEXTCOLOR = GmFacilityStructuredStyleKeys.TEXTCOLOR;

    @objid ("0e9ce779-1703-4daa-8d9b-dcbcf5360559")
    static final StyleKey SHOWSTEREOTYPES = GmFacilityStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("6b0020b9-8a58-4709-a5e3-8b0bddcdcd4f")
    static final StyleKey SHOWTAGS = GmFacilityStructuredStyleKeys.SHOWTAGS;

}
