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
package org.modelio.archimate.diagrams.elements.businessinterface;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessInterface when its representation mode is RepresentationMode.IMAGE
 */
@objid ("e9a05cd1-2e7b-4e1b-9bad-3b380e582b53")
public class GmBusinessInterfaceImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("55fbcc51-ff75-47a9-a2fd-89c0d1ac4fb6")
    static final StyleKey REPMODE = GmBusinessInterfaceStructuredStyleKeys.REPMODE;

    @objid ("45be6d3f-23e7-473f-9456-4b707ba89ac7")
    static final StyleKey FONT = GmBusinessInterfaceStructuredStyleKeys.FONT;

    @objid ("0479e588-5c8e-4fdf-87c8-e631ac06b29f")
    static final StyleKey TEXTCOLOR = GmBusinessInterfaceStructuredStyleKeys.TEXTCOLOR;

    @objid ("6fe57f96-d795-4220-ba63-10ef1cbbe3f2")
    static final StyleKey SHOWSTEREOTYPES = GmBusinessInterfaceStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("e4a757b2-4be3-4935-a525-df59eb836afa")
    static final StyleKey SHOWTAGS = GmBusinessInterfaceStructuredStyleKeys.SHOWTAGS;

}
