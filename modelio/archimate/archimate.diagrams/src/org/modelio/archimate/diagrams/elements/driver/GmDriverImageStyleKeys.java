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
package org.modelio.archimate.diagrams.elements.driver;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmDriver when its representation mode is RepresentationMode.IMAGE
 */
@objid ("03c1aab5-57e1-4be0-8adf-d9e13abf3339")
public class GmDriverImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("2c2a40a5-6c28-45ae-a974-c3ba74423f2c")
    static final StyleKey REPMODE = GmDriverStructuredStyleKeys.REPMODE;

    @objid ("0d34cf74-58a5-4eb7-9ecf-996c53d4658b")
    static final StyleKey FONT = GmDriverStructuredStyleKeys.FONT;

    @objid ("92160cfd-1d65-4c77-b5a8-6118ac86fbe3")
    static final StyleKey TEXTCOLOR = GmDriverStructuredStyleKeys.TEXTCOLOR;

    @objid ("0d31a54a-e360-4a58-a747-59b989ded7e4")
    static final StyleKey SHOWSTEREOTYPES = GmDriverStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("595dd588-93f2-41bf-9c49-9449682cb423")
    static final StyleKey SHOWTAGS = GmDriverStructuredStyleKeys.SHOWTAGS;

}
