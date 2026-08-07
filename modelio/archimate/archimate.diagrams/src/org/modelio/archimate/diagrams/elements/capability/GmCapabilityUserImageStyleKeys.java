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
package org.modelio.archimate.diagrams.elements.capability;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmCapability when its representation mode is RepresentationMode.IMAGE
 */
@objid ("9761b39a-9126-4a54-aa43-ecaef7222ff9")
public class GmCapabilityUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("664ef69e-5301-446e-bf24-a011f14ac131")
    static final StyleKey REPMODE = GmCapabilityStructuredStyleKeys.REPMODE;

    @objid ("fd030615-70ed-4b42-a07e-9656570c1d46")
    static final StyleKey FONT = GmCapabilityStructuredStyleKeys.FONT;

    @objid ("275f9e81-6de9-4fd2-8096-fe60febd0e45")
    static final StyleKey TEXTCOLOR = GmCapabilityStructuredStyleKeys.TEXTCOLOR;

    @objid ("2c92ec9a-8126-4c99-b42e-4a007cbc8808")
    static final StyleKey SHOWSTEREOTYPES = GmCapabilityStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("2d4f5c32-b0ed-4100-8f6e-d3c46be8df44")
    static final StyleKey SHOWTAGS = GmCapabilityStructuredStyleKeys.SHOWTAGS;

}
