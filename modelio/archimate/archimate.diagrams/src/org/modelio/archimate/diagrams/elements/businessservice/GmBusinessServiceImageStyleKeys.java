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
package org.modelio.archimate.diagrams.elements.businessservice;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessService when its representation mode is RepresentationMode.IMAGE
 */
@objid ("aa978726-a459-4157-b85d-75f0f3c0708f")
public class GmBusinessServiceImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("576de718-2241-4ca5-a911-c6ff5e2d3423")
    static final StyleKey REPMODE = GmBusinessServiceStructuredStyleKeys.REPMODE;

    @objid ("e507801c-7586-4d2d-b8da-ebe5d0acb197")
    static final StyleKey FONT = GmBusinessServiceStructuredStyleKeys.FONT;

    @objid ("8d3e38d9-ad79-4af4-913b-92bda7d132f7")
    static final StyleKey TEXTCOLOR = GmBusinessServiceStructuredStyleKeys.TEXTCOLOR;

    @objid ("17e04156-e878-4264-a0c2-94f247406687")
    static final StyleKey SHOWSTEREOTYPES = GmBusinessServiceStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("590f22ad-0037-4d88-b933-a9a4e308b558")
    static final StyleKey SHOWTAGS = GmBusinessServiceStructuredStyleKeys.SHOWTAGS;

}
