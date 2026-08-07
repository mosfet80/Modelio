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
package org.modelio.archimate.diagrams.elements.businessfunction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessFunction when its representation mode is RepresentationMode.IMAGE
 */
@objid ("77ae27d6-2cb5-4124-af51-68e630001a16")
public class GmBusinessFunctionUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("6e05e493-73e7-4f08-8224-04767548cb37")
    static final StyleKey REPMODE = GmBusinessFunctionStructuredStyleKeys.REPMODE;

    @objid ("6fee460e-1e19-4397-bf7f-d9c9b090c18a")
    static final StyleKey FONT = GmBusinessFunctionStructuredStyleKeys.FONT;

    @objid ("6fa8ab4d-66a0-4c09-8e2a-32e6f2329a38")
    static final StyleKey TEXTCOLOR = GmBusinessFunctionStructuredStyleKeys.TEXTCOLOR;

    @objid ("22803032-f586-4cc5-8f82-77e6dd7bd1be")
    static final StyleKey SHOWSTEREOTYPES = GmBusinessFunctionStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("9a919a28-d812-489e-b68a-8b1b41ed6a49")
    static final StyleKey SHOWTAGS = GmBusinessFunctionStructuredStyleKeys.SHOWTAGS;

}
