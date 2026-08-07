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
@objid ("bf81db7d-75fa-40f2-b4c2-62c4e5ea5d0c")
public class GmValueStreamImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("d31c0168-1151-4047-af26-9b93f5a56165")
    static final StyleKey REPMODE = GmValueStreamStructuredStyleKeys.REPMODE;

    @objid ("ff85dd07-4368-4201-8479-56cc65fb8392")
    static final StyleKey FONT = GmValueStreamStructuredStyleKeys.FONT;

    @objid ("0ffdfcc3-cc38-457f-aabc-8fc8b9e20f50")
    static final StyleKey TEXTCOLOR = GmValueStreamStructuredStyleKeys.TEXTCOLOR;

    @objid ("e2f0bd03-2576-4b9b-b78d-b685f9fc3ac8")
    static final StyleKey SHOWSTEREOTYPES = GmValueStreamStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("36f1b293-9e6c-42e2-a8b5-2d4b23e339ee")
    static final StyleKey SHOWTAGS = GmValueStreamStructuredStyleKeys.SHOWTAGS;

}
