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
package org.modelio.archimate.diagrams.elements.node;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmNode when its representation mode is RepresentationMode.IMAGE
 */
@objid ("6b3b4afd-c5bb-402b-82aa-16bd5682bca1")
public class GmNodeImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("4565b530-285b-484c-9419-3903ce8b899a")
    static final StyleKey REPMODE = GmNodeStructuredStyleKeys.REPMODE;

    @objid ("bbc2c9af-3591-4b11-9c10-45aeaf13fd29")
    static final StyleKey FONT = GmNodeStructuredStyleKeys.FONT;

    @objid ("3b9f67f3-7a3e-4b7e-b2ec-c5d9246c03d4")
    static final StyleKey TEXTCOLOR = GmNodeStructuredStyleKeys.TEXTCOLOR;

    @objid ("c6ae3d67-0d30-4234-b885-f73abd466d2e")
    static final StyleKey SHOWSTEREOTYPES = GmNodeStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("4714070a-2c06-4c75-a3b8-b15f19c00f3c")
    static final StyleKey SHOWTAGS = GmNodeStructuredStyleKeys.SHOWTAGS;

}
