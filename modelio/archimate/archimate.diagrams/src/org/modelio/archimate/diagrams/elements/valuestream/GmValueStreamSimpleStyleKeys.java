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
 * This class provides the StyleKey constants for a GmValueStream when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("2ee0bde5-4abb-448b-b613-34917f334cfb")
public class GmValueStreamSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("48a622d2-c0f7-4912-9d01-da6b328972b7")
    static final StyleKey REPMODE = GmValueStreamStructuredStyleKeys.REPMODE;

    @objid ("036825cb-b077-4bf8-a80f-ee7e866ed57f")
    static final StyleKey FILLCOLOR = GmValueStreamStructuredStyleKeys.FILLCOLOR;

    @objid ("b55913c4-ce58-4e3c-a87a-bd0ddec9d022")
    static final StyleKey FILLMODE = GmValueStreamStructuredStyleKeys.FILLMODE;

    @objid ("99e10298-11f3-4665-97ba-af8678ed56e9")
    static final StyleKey LINECOLOR = GmValueStreamStructuredStyleKeys.LINECOLOR;

    @objid ("d82b103c-8370-4770-950e-690d91d44335")
    static final StyleKey LINEWIDTH = GmValueStreamStructuredStyleKeys.LINEWIDTH;

    @objid ("a3fa4dbf-0b70-4f06-b45b-b610c7424aea")
    static final StyleKey FONT = GmValueStreamStructuredStyleKeys.FONT;

    @objid ("38c4f2f6-753c-415e-b5df-387c212ea821")
    static final StyleKey TEXTCOLOR = GmValueStreamStructuredStyleKeys.TEXTCOLOR;

    @objid ("8dd4f0b0-29b0-4d18-be45-546bfc99d8f6")
    static final StyleKey SHOWSTEREOTYPES = GmValueStreamStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("a91820e8-64b0-447c-b57e-e4a990594aab")
    static final StyleKey SHOWTAGS = GmValueStreamStructuredStyleKeys.SHOWTAGS;

}
