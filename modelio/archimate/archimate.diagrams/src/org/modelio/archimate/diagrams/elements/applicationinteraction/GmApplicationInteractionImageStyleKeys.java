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
package org.modelio.archimate.diagrams.elements.applicationinteraction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationInteraction when its representation mode is RepresentationMode.IMAGE
 */
@objid ("e1102b2c-a406-4084-aae4-21699932aca1")
public class GmApplicationInteractionImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("6f5cbfad-640d-4d0d-93b5-4b70909fe8a2")
    static final StyleKey REPMODE = GmApplicationInteractionStructuredStyleKeys.REPMODE;

    @objid ("e95cdece-9627-4a4a-b899-1201cf710b7f")
    static final StyleKey FONT = GmApplicationInteractionStructuredStyleKeys.FONT;

    @objid ("cd618aff-e6e3-4ec3-a742-6359d669fe28")
    static final StyleKey TEXTCOLOR = GmApplicationInteractionStructuredStyleKeys.TEXTCOLOR;

    @objid ("753fc060-dfc7-42cb-b58b-8b584b84d3fe")
    static final StyleKey SHOWSTEREOTYPES = GmApplicationInteractionStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("b0e5b967-d4ae-4424-bde0-8e35b4d9be15")
    static final StyleKey SHOWTAGS = GmApplicationInteractionStructuredStyleKeys.SHOWTAGS;

}
