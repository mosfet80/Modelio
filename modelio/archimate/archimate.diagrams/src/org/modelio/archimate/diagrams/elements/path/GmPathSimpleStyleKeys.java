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
 * This class provides the StyleKey constants for a GmPath when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("a899e662-1de4-47d2-9ac4-f38af219468a")
public class GmPathSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("f2c17bf4-34f4-4276-96ec-35d2a6644c37")
    static final StyleKey REPMODE = GmPathStructuredStyleKeys.REPMODE;

    @objid ("bc46d900-0e57-4935-87db-33f2b15b601b")
    static final StyleKey LINECOLOR = GmPathStructuredStyleKeys.LINECOLOR;

    @objid ("a8427262-af25-4353-9066-4b7524b0d657")
    static final StyleKey FONT = GmPathStructuredStyleKeys.FONT;

    @objid ("7b92a922-bdd0-44a2-8dec-ba9c81869458")
    static final StyleKey TEXTCOLOR = GmPathStructuredStyleKeys.TEXTCOLOR;

    @objid ("13ceb467-b982-47c4-acca-079f4508d66b")
    static final StyleKey SHOWSTEREOTYPES = GmPathStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("048a77f2-c2bc-4620-a792-3a9adfd002c9")
    static final StyleKey SHOWTAGS = GmPathStructuredStyleKeys.SHOWTAGS;

}
