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
@objid ("6b8a444c-004f-4d56-903c-3c9b542c1ae5")
public class GmTechnologyFunctionImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("01b2b123-9b53-4273-9eff-0211857b6f59")
    static final StyleKey REPMODE = GmTechnologyFunctionStructuredStyleKeys.REPMODE;

    @objid ("97e35c48-352b-4e05-84cf-7df9db870c11")
    static final StyleKey FONT = GmTechnologyFunctionStructuredStyleKeys.FONT;

    @objid ("9eb0c9fa-0c0e-4820-8341-c9f58b1473c9")
    static final StyleKey TEXTCOLOR = GmTechnologyFunctionStructuredStyleKeys.TEXTCOLOR;

    @objid ("34ed9ff1-29af-497b-9686-c47937bcdf1a")
    static final StyleKey SHOWSTEREOTYPES = GmTechnologyFunctionStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("987c5c2d-8318-4e11-9a4c-9521d97d7e0a")
    static final StyleKey SHOWTAGS = GmTechnologyFunctionStructuredStyleKeys.SHOWTAGS;

}
