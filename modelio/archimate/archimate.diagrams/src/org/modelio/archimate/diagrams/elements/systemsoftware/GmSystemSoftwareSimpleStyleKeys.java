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
package org.modelio.archimate.diagrams.elements.systemsoftware;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmSystemSoftware when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("b70cf432-fd49-4d52-bb02-af854d83a035")
public class GmSystemSoftwareSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("9214ad50-9775-41ef-ae6a-106a1b67854c")
    static final StyleKey REPMODE = GmSystemSoftwareStructuredStyleKeys.REPMODE;

    @objid ("43af0d6e-9978-4f33-8c85-45b0202300d7")
    static final StyleKey FILLCOLOR = GmSystemSoftwareStructuredStyleKeys.FILLCOLOR;

    @objid ("aebece57-e06d-4d75-8e68-a1db135a0dbc")
    static final StyleKey FILLMODE = GmSystemSoftwareStructuredStyleKeys.FILLMODE;

    @objid ("40403d00-7e4b-44e8-8ef3-ade5f2efad7a")
    static final StyleKey LINECOLOR = GmSystemSoftwareStructuredStyleKeys.LINECOLOR;

    @objid ("c56e2a95-a12b-49ee-bdc5-dd37c65d2148")
    static final StyleKey LINEWIDTH = GmSystemSoftwareStructuredStyleKeys.LINEWIDTH;

    @objid ("58c18c10-c72f-427a-afe5-ffbb4cba9cb0")
    static final StyleKey FONT = GmSystemSoftwareStructuredStyleKeys.FONT;

    @objid ("2a666873-7bce-494e-bb76-5fbc19573371")
    static final StyleKey TEXTCOLOR = GmSystemSoftwareStructuredStyleKeys.TEXTCOLOR;

    @objid ("6292a292-1b41-4bc0-8e95-e386dbb53f3d")
    static final StyleKey SHOWSTEREOTYPES = GmSystemSoftwareStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("81068ba1-b6d1-4a27-91d4-941ad1b23f46")
    static final StyleKey SHOWTAGS = GmSystemSoftwareStructuredStyleKeys.SHOWTAGS;

}
