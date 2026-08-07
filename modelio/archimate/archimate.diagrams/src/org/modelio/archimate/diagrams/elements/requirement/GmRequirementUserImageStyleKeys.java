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
package org.modelio.archimate.diagrams.elements.requirement;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmRequirement when its representation mode is RepresentationMode.IMAGE
 */
@objid ("2f31997e-113a-4e90-b069-ca79de5ed5aa")
public class GmRequirementUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("8bb42e16-78f7-49e4-844f-5a0879b57767")
    static final StyleKey REPMODE = GmRequirementStructuredStyleKeys.REPMODE;

    @objid ("3d67ecf9-de04-4adb-baa6-c05a23ff28e6")
    static final StyleKey FONT = GmRequirementStructuredStyleKeys.FONT;

    @objid ("8d96962b-3160-4fa5-80b6-c1663bdfdf35")
    static final StyleKey TEXTCOLOR = GmRequirementStructuredStyleKeys.TEXTCOLOR;

    @objid ("07c8e7f7-94c8-4bb3-b7ad-57e6edde5ffa")
    static final StyleKey SHOWSTEREOTYPES = GmRequirementStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("d0862738-0a20-415c-97fe-5aa3ff2ef170")
    static final StyleKey SHOWTAGS = GmRequirementStructuredStyleKeys.SHOWTAGS;

}
