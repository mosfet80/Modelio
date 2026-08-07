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
package org.modelio.archimate.diagrams.elements.technologyservice;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmTechnologyService when its representation mode is RepresentationMode.IMAGE
 */
@objid ("80cd8503-e73d-4bb4-b21f-559068c9ba58")
public class GmTechnologyServiceUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("a5893f27-4caf-4b19-a544-962889976a06")
    static final StyleKey REPMODE = GmTechnologyServiceStructuredStyleKeys.REPMODE;

    @objid ("5cd3c31d-dfe1-4fcf-8192-90d4d505a2b5")
    static final StyleKey FONT = GmTechnologyServiceStructuredStyleKeys.FONT;

    @objid ("1c36a58e-081e-4abe-8fa2-9cc515141648")
    static final StyleKey TEXTCOLOR = GmTechnologyServiceStructuredStyleKeys.TEXTCOLOR;

    @objid ("22abba40-0684-4df6-80fe-aa391ec11482")
    static final StyleKey SHOWSTEREOTYPES = GmTechnologyServiceStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("49682066-37e9-4b41-8d38-814a69f59349")
    static final StyleKey SHOWTAGS = GmTechnologyServiceStructuredStyleKeys.SHOWTAGS;

}
