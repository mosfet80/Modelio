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
package org.modelio.archimate.diagrams.elements.technologyfunction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmTechnologyFunction when its representation mode is RepresentationMode.IMAGE
 */
@objid ("ce926ee0-30f0-4fe7-a337-6dcf26c0f5f5")
public class GmTechnologyFunctionUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("803c88af-6f0d-4336-b096-aff4acb8e5b6")
    static final StyleKey REPMODE = GmTechnologyFunctionStructuredStyleKeys.REPMODE;

    @objid ("66f71293-a495-4159-a8d5-19db95f981d5")
    static final StyleKey FONT = GmTechnologyFunctionStructuredStyleKeys.FONT;

    @objid ("e17f1324-29b2-41aa-aa11-a94d6c282791")
    static final StyleKey TEXTCOLOR = GmTechnologyFunctionStructuredStyleKeys.TEXTCOLOR;

    @objid ("38b2f63c-0bd5-410f-9667-3a51a9a83647")
    static final StyleKey SHOWSTEREOTYPES = GmTechnologyFunctionStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("b26ed488-be8e-4188-b55e-ee080c61ae5d")
    static final StyleKey SHOWTAGS = GmTechnologyFunctionStructuredStyleKeys.SHOWTAGS;

}
