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
 * This class provides the StyleKey constants for a GmPlateau when its representation mode is RepresentationMode.IMAGE
 */
@objid ("abe134d1-fd97-4aed-9ff1-b47caf2d37c9")
public class GmPlateauImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("46e38eb6-0095-473c-9cf2-07d19c5eadc3")
    static final StyleKey REPMODE = GmPlateauStructuredStyleKeys.REPMODE;

    @objid ("a44a55c7-f86d-41a3-886a-486ce02a5cdf")
    static final StyleKey FONT = GmPlateauStructuredStyleKeys.FONT;

    @objid ("dd01cd80-5a15-430b-affc-cc63aea6fce9")
    static final StyleKey TEXTCOLOR = GmPlateauStructuredStyleKeys.TEXTCOLOR;

    @objid ("d75f57fd-03ad-4f05-807f-4174984bd4cc")
    static final StyleKey SHOWSTEREOTYPES = GmPlateauStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("1affbb45-23f7-421e-8ee9-64b8fb36f589")
    static final StyleKey SHOWTAGS = GmPlateauStructuredStyleKeys.SHOWTAGS;

}
