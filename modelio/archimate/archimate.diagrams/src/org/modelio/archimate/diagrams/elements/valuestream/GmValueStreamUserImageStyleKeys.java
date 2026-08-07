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
package org.modelio.archimate.diagrams.elements.valuestream;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmValueStream when its representation mode is RepresentationMode.IMAGE
 */
@objid ("99644cc2-e5b0-490b-a036-4d013021b79a")
public class GmValueStreamUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("ccc98f82-f770-4480-89da-c04c45b17d82")
    static final StyleKey REPMODE = GmValueStreamStructuredStyleKeys.REPMODE;

    @objid ("a31e028b-c5cb-4776-8840-45640d1d0e0c")
    static final StyleKey FONT = GmValueStreamStructuredStyleKeys.FONT;

    @objid ("57339841-52e6-4771-b4f0-7ed2a8c3207d")
    static final StyleKey TEXTCOLOR = GmValueStreamStructuredStyleKeys.TEXTCOLOR;

    @objid ("ebd2506d-e2e5-43ac-af3f-0d0dcbb3b4e7")
    static final StyleKey SHOWSTEREOTYPES = GmValueStreamStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("c58a6ee9-e075-4b73-b2be-1a3c7aead5c0")
    static final StyleKey SHOWTAGS = GmValueStreamStructuredStyleKeys.SHOWTAGS;

}
