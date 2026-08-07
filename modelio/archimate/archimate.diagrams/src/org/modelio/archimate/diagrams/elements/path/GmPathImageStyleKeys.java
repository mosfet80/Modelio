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
package org.modelio.archimate.diagrams.elements.path;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmPath when its representation mode is RepresentationMode.IMAGE
 */
@objid ("cbbeb8c6-e14c-4f5b-acbb-174f538f243b")
public class GmPathImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("21b2dea4-6462-4c6c-9191-3b5fb4898382")
    static final StyleKey REPMODE = GmPathStructuredStyleKeys.REPMODE;

    @objid ("cd482751-b076-4ff4-a2d5-cedef2e1394f")
    static final StyleKey FONT = GmPathStructuredStyleKeys.FONT;

    @objid ("e4943a44-6bb2-4be4-a79f-84a4708db984")
    static final StyleKey TEXTCOLOR = GmPathStructuredStyleKeys.TEXTCOLOR;

    @objid ("3ceaf7c0-5718-484f-a15d-776cbaeb21d1")
    static final StyleKey SHOWSTEREOTYPES = GmPathStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("f30fb24f-5389-4b53-a458-091528eb4b75")
    static final StyleKey SHOWTAGS = GmPathStructuredStyleKeys.SHOWTAGS;

}
