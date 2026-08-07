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
package org.modelio.archimate.diagrams.elements.principle;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;

/**
 * This class provides the StyleKey constants for a GmPrinciple when its representation mode is {@link RepresentationMode#IMAGE}.
 */
@objid ("1b2f338e-c25f-4816-940d-2b919e8ff614")
public class GmPrincipleImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("66020e0a-acac-48bc-8982-6ea9993de592")
    static final StyleKey REPMODE = GmPrincipleStructuredStyleKeys.REPMODE;

    @objid ("dcad0a83-0bf3-4ac7-b8ba-423ffa2a10ce")
    static final StyleKey FONT = GmPrincipleStructuredStyleKeys.FONT;

    @objid ("16862e89-2bc3-4f1e-893d-02e6b5e3f0d8")
    static final StyleKey TEXTCOLOR = GmPrincipleStructuredStyleKeys.TEXTCOLOR;

    @objid ("e46461c6-651f-4680-9181-9fb12ed2190e")
    static final StyleKey SHOWSTEREOTYPES = GmPrincipleStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("07d70579-3139-433f-9af2-ff159de4e503")
    static final StyleKey SHOWTAGS = GmPrincipleStructuredStyleKeys.SHOWTAGS;

}
