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
package org.modelio.archimate.diagrams.elements.outcome;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmOutcome when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("622bb447-fb4e-4710-a05d-d048f95e8fec")
public class GmOutcomeSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("73f38c13-2cca-4735-a3a2-3af693a4949d")
    static final StyleKey REPMODE = GmOutcomeStructuredStyleKeys.REPMODE;

    @objid ("5963c7b0-d19e-4b63-bd90-254bdf305868")
    static final StyleKey FILLCOLOR = GmOutcomeStructuredStyleKeys.FILLCOLOR;

    @objid ("5d24c4a3-537e-4167-b1b2-82fe414f5779")
    static final StyleKey FILLMODE = GmOutcomeStructuredStyleKeys.FILLMODE;

    @objid ("7c9b5d62-1a59-4f24-b50e-cedcc8eb0fd1")
    static final StyleKey LINECOLOR = GmOutcomeStructuredStyleKeys.LINECOLOR;

    @objid ("400c0f06-a5f9-4226-bd58-e0523817b688")
    static final StyleKey LINEWIDTH = GmOutcomeStructuredStyleKeys.LINEWIDTH;

    @objid ("81a92c79-21a7-4155-b64a-797da2cfc8da")
    static final StyleKey FONT = GmOutcomeStructuredStyleKeys.FONT;

    @objid ("88ba8656-803d-4684-a21c-94cd70ffcdfe")
    static final StyleKey TEXTCOLOR = GmOutcomeStructuredStyleKeys.TEXTCOLOR;

    @objid ("4eab7673-6669-4f12-afec-d7e30e5c55ba")
    static final StyleKey SHOWSTEREOTYPES = GmOutcomeStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("0c11b838-a35a-4ea7-a944-f5ff7e49dada")
    static final StyleKey SHOWTAGS = GmOutcomeStructuredStyleKeys.SHOWTAGS;

}
