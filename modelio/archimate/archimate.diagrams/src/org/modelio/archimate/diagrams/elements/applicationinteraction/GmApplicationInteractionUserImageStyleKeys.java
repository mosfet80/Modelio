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
@objid ("4f5d24d7-03a1-4188-b634-d1af8a171798")
public class GmApplicationInteractionUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("e6e97139-2d17-419a-b230-f3547f134fbc")
    static final StyleKey REPMODE = GmApplicationInteractionStructuredStyleKeys.REPMODE;

    @objid ("1980cc68-33e6-4070-8b1e-921d95e2af25")
    static final StyleKey FONT = GmApplicationInteractionStructuredStyleKeys.FONT;

    @objid ("9d21444e-adca-4f06-896d-e44b702cd0a6")
    static final StyleKey TEXTCOLOR = GmApplicationInteractionStructuredStyleKeys.TEXTCOLOR;

    @objid ("806791d4-67d0-4db3-a344-506f7c6e629d")
    static final StyleKey SHOWSTEREOTYPES = GmApplicationInteractionStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("417d7e20-761d-49f9-9100-15dd6efa3229")
    static final StyleKey SHOWTAGS = GmApplicationInteractionStructuredStyleKeys.SHOWTAGS;

}
