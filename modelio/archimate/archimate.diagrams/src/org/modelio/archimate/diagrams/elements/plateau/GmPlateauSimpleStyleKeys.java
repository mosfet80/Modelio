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
package org.modelio.archimate.diagrams.elements.plateau;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmPlateau when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("cdab5bbc-969a-43e5-9e02-ce923e4ce55f")
public class GmPlateauSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("7ab8e691-a2eb-4091-8546-b2a2d5b97f87")
    static final StyleKey REPMODE = GmPlateauStructuredStyleKeys.REPMODE;

    @objid ("83af59f4-5641-411d-a9bb-28fa61cda6f1")
    static final StyleKey FILLCOLOR = GmPlateauStructuredStyleKeys.FILLCOLOR;

    @objid ("f69268c3-d5c3-4271-a027-73b1c2beb766")
    static final StyleKey FILLMODE = GmPlateauStructuredStyleKeys.FILLMODE;

    @objid ("e6621228-23e0-428e-af5c-a4e44cdd7c74")
    static final StyleKey LINECOLOR = GmPlateauStructuredStyleKeys.LINECOLOR;

    @objid ("040c88a0-4015-474c-b6bb-6e15578e456d")
    static final StyleKey LINEWIDTH = GmPlateauStructuredStyleKeys.LINEWIDTH;

    @objid ("c436f1db-f25f-41f1-bd4a-c50019c21d0f")
    static final StyleKey FONT = GmPlateauStructuredStyleKeys.FONT;

    @objid ("b77b0799-156c-4d3c-9d6b-6b51392c05b5")
    static final StyleKey TEXTCOLOR = GmPlateauStructuredStyleKeys.TEXTCOLOR;

    @objid ("71053e69-0816-4e35-8e46-004716eadcc5")
    static final StyleKey SHOWSTEREOTYPES = GmPlateauStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("036af31c-dd1a-4ddc-a565-ca13d944f201")
    static final StyleKey SHOWTAGS = GmPlateauStructuredStyleKeys.SHOWTAGS;

}
