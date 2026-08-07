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
package org.modelio.archimate.diagrams.elements.businessinteraction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessInteraction when its representation mode is RepresentationMode.IMAGE
 */
@objid ("5512c9ec-1dda-4029-8921-e99b03af9173")
public class GmBusinessInteractionUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("34664054-2f5a-4b98-92fe-c751182a026a")
    static final StyleKey REPMODE = GmBusinessInteractionStructuredStyleKeys.REPMODE;

    @objid ("1f3c25b3-4b0b-4870-9c0e-c165ddea201f")
    static final StyleKey FONT = GmBusinessInteractionStructuredStyleKeys.FONT;

    @objid ("fdfb1398-bb66-445d-aa91-917ef957948c")
    static final StyleKey TEXTCOLOR = GmBusinessInteractionStructuredStyleKeys.TEXTCOLOR;

    @objid ("b27d875b-f74d-461f-9654-d48ae686df7d")
    static final StyleKey SHOWSTEREOTYPES = GmBusinessInteractionStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("e49ef142-e492-45f9-88b8-4e5bf186a3b7")
    static final StyleKey SHOWTAGS = GmBusinessInteractionStructuredStyleKeys.SHOWTAGS;

}
