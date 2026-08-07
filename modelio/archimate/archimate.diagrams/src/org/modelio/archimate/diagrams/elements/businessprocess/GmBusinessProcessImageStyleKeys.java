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
package org.modelio.archimate.diagrams.elements.businessprocess;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessProcess when its representation mode is RepresentationMode.IMAGE
 */
@objid ("3d9bbf38-510a-4713-a78c-250cca168f91")
public class GmBusinessProcessImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("03a04871-b7a6-4bfa-8008-4f054d871b86")
    static final StyleKey REPMODE = GmBusinessProcessStructuredStyleKeys.REPMODE;

    @objid ("c6c7a1fb-609d-4816-b7a6-bef90e02c995")
    static final StyleKey FONT = GmBusinessProcessStructuredStyleKeys.FONT;

    @objid ("30f938bb-0b23-4e1d-b5d6-016d234e7d30")
    static final StyleKey TEXTCOLOR = GmBusinessProcessStructuredStyleKeys.TEXTCOLOR;

    @objid ("7a0468b3-d4dc-40e5-90fe-28fef42b26d0")
    static final StyleKey SHOWSTEREOTYPES = GmBusinessProcessStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("75447bb7-a062-401b-ae9a-22fddab7b92f")
    static final StyleKey SHOWTAGS = GmBusinessProcessStructuredStyleKeys.SHOWTAGS;

}
