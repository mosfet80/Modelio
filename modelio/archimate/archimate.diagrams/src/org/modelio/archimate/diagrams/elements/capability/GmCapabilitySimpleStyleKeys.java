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
 * This class provides the StyleKey constants for a GmCapability when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("fe076420-531c-4577-854b-a4041ebb250a")
public class GmCapabilitySimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("fae86281-a47e-486d-8028-f9ea1c0b6e3c")
    static final StyleKey REPMODE = GmCapabilityStructuredStyleKeys.REPMODE;

    @objid ("c8ef0699-5592-4423-afaf-f547e4a6628e")
    static final StyleKey FILLCOLOR = GmCapabilityStructuredStyleKeys.FILLCOLOR;

    @objid ("d015a264-580c-4815-9816-3b4273b65dbe")
    static final StyleKey FILLMODE = GmCapabilityStructuredStyleKeys.FILLMODE;

    @objid ("dd850378-3d39-414c-8a00-add726a32d46")
    static final StyleKey LINECOLOR = GmCapabilityStructuredStyleKeys.LINECOLOR;

    @objid ("f993d646-67ab-4254-a1aa-1009e848bead")
    static final StyleKey LINEWIDTH = GmCapabilityStructuredStyleKeys.LINEWIDTH;

    @objid ("a2025dea-1895-4ab1-a4c3-5c14f9b9694d")
    static final StyleKey FONT = GmCapabilityStructuredStyleKeys.FONT;

    @objid ("6335821a-6599-4a22-976d-c2102cd89c44")
    static final StyleKey TEXTCOLOR = GmCapabilityStructuredStyleKeys.TEXTCOLOR;

    @objid ("35cb9db4-f468-46c7-86d9-3d1954a7bf11")
    static final StyleKey SHOWSTEREOTYPES = GmCapabilityStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("646b2a0b-b70a-4a19-a622-39ac3c86e54c")
    static final StyleKey SHOWTAGS = GmCapabilityStructuredStyleKeys.SHOWTAGS;

}
