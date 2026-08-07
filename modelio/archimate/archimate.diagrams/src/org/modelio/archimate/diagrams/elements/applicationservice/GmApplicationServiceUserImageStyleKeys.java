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
package org.modelio.archimate.diagrams.elements.applicationservice;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationService when its representation mode is RepresentationMode.IMAGE
 */
@objid ("429fa271-9e0d-4162-9f62-47b31c3693f8")
public class GmApplicationServiceUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("d6893031-d816-42e7-a653-ea9dda0b74a0")
    static final StyleKey REPMODE = GmApplicationServiceStructuredStyleKeys.REPMODE;

    @objid ("22178447-e261-4a80-b5aa-f7e382bd267c")
    static final StyleKey FONT = GmApplicationServiceStructuredStyleKeys.FONT;

    @objid ("b6a15d6a-18f8-479e-90b6-075225ac5464")
    static final StyleKey TEXTCOLOR = GmApplicationServiceStructuredStyleKeys.TEXTCOLOR;

    @objid ("0fa19cc5-6464-4fbe-8382-f3c3b3d0eb14")
    static final StyleKey SHOWSTEREOTYPES = GmApplicationServiceStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("8d511733-fb73-4baf-a03e-6f241d023746")
    static final StyleKey SHOWTAGS = GmApplicationServiceStructuredStyleKeys.SHOWTAGS;

}
