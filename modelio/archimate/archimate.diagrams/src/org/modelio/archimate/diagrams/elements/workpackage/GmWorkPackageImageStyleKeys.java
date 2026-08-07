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
package org.modelio.archimate.diagrams.elements.workpackage;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmWorkPackage when its representation mode is RepresentationMode.IMAGE
 */
@objid ("c9615bbb-f14f-4438-9da4-90f0f117fb1c")
public class GmWorkPackageImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("31cc7b9f-01c6-4407-9fb5-004fbe250ef0")
    static final StyleKey REPMODE = GmWorkPackageStructuredStyleKeys.REPMODE;

    @objid ("52a7829f-c716-4b62-8bbe-e2fe22f30af1")
    static final StyleKey FONT = GmWorkPackageStructuredStyleKeys.FONT;

    @objid ("4a8d3f65-a0b7-4042-91fb-7ce028382ac1")
    static final StyleKey TEXTCOLOR = GmWorkPackageStructuredStyleKeys.TEXTCOLOR;

    @objid ("9415da92-3e19-4670-ada5-e346928e24e4")
    static final StyleKey SHOWSTEREOTYPES = GmWorkPackageStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("8b415c7c-552b-4cb1-bc74-71c9b186dbe9")
    static final StyleKey SHOWTAGS = GmWorkPackageStructuredStyleKeys.SHOWTAGS;

}
