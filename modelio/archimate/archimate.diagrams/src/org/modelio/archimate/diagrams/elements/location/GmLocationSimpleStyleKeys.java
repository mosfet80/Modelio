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
package org.modelio.archimate.diagrams.elements.location;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmLocation when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("fcd7ac26-b051-4b5a-b6d2-aa5df88cc7c2")
public class GmLocationSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("8efa0789-6f79-4074-bdef-61dac21429e4")
    static final StyleKey REPMODE = GmLocationStructuredStyleKeys.REPMODE;

    @objid ("f2d44bb8-d215-4f54-aab5-943311a10853")
    static final StyleKey FILLCOLOR = GmLocationStructuredStyleKeys.FILLCOLOR;

    @objid ("f0e2f9df-bf01-4a0b-bd1a-7f2b3f1625de")
    static final StyleKey FILLMODE = GmLocationStructuredStyleKeys.FILLMODE;

    @objid ("08973ecc-93b4-44b4-a643-435d877e6549")
    static final StyleKey LINECOLOR = GmLocationStructuredStyleKeys.LINECOLOR;

    @objid ("9325d4fb-9227-46cc-811b-6428ad07be5f")
    static final StyleKey LINEWIDTH = GmLocationStructuredStyleKeys.LINEWIDTH;

    @objid ("e1bb1b12-ee7e-4ab1-ab1b-336e95264416")
    static final StyleKey FONT = GmLocationStructuredStyleKeys.FONT;

    @objid ("e7b80507-9019-453c-a666-20b5708d3429")
    static final StyleKey TEXTCOLOR = GmLocationStructuredStyleKeys.TEXTCOLOR;

    @objid ("c95e5343-c1cc-4754-9c50-efdb2c18ec11")
    static final StyleKey SHOWSTEREOTYPES = GmLocationStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("db6c988e-2774-46a4-975a-10e84f561856")
    static final StyleKey SHOWTAGS = GmLocationStructuredStyleKeys.SHOWTAGS;

}
