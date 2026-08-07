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
@objid ("b8ce8785-f6ce-4b0d-b204-6b68ca7de568")
public class GmBusinessFunctionImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("ae4472a5-ce6c-4f79-80d3-caa9a3cf0b2c")
    static final StyleKey REPMODE = GmBusinessFunctionStructuredStyleKeys.REPMODE;

    @objid ("61596011-e4f8-4d6e-a868-8478cc78258d")
    static final StyleKey FONT = GmBusinessFunctionStructuredStyleKeys.FONT;

    @objid ("9097c358-7926-4557-8e8e-0995a40c778b")
    static final StyleKey TEXTCOLOR = GmBusinessFunctionStructuredStyleKeys.TEXTCOLOR;

    @objid ("3a865db3-487e-47d2-b8cc-3b5aa8a0f558")
    static final StyleKey SHOWSTEREOTYPES = GmBusinessFunctionStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("b09098dc-f70b-4a9d-98bd-03090c65938e")
    static final StyleKey SHOWTAGS = GmBusinessFunctionStructuredStyleKeys.SHOWTAGS;

}
