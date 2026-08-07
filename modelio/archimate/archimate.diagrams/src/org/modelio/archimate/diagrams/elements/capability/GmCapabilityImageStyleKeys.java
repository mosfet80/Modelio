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
@objid ("fc1682f7-f0d3-4124-bf4e-1ad1c03f7e7d")
public class GmCapabilityImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("a5de823d-5dd1-469e-a9fd-18b95795d9b3")
    static final StyleKey REPMODE = GmCapabilityStructuredStyleKeys.REPMODE;

    @objid ("f7b527b2-b6d8-4f54-9e4c-720ef350a71c")
    static final StyleKey FONT = GmCapabilityStructuredStyleKeys.FONT;

    @objid ("ef5615d7-d1e0-4036-8dff-41f691350f54")
    static final StyleKey TEXTCOLOR = GmCapabilityStructuredStyleKeys.TEXTCOLOR;

    @objid ("f544d70a-541b-4ce9-8d8d-8dea21505b3e")
    static final StyleKey SHOWSTEREOTYPES = GmCapabilityStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("c39a0903-3d41-4915-83bc-2a783659dad2")
    static final StyleKey SHOWTAGS = GmCapabilityStructuredStyleKeys.SHOWTAGS;

}
